package com.etlpat.controller;

import com.etlpat.pojo.Result;
import com.etlpat.pojo.User;
import com.etlpat.service.UserService;
import com.etlpat.utils.JWTUtil;
import com.etlpat.utils.MD5Util;
import com.etlpat.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


// (1)使用Spring Validation框架,对注册接口的请求参数进行合法性校验
//
//  Validation对普通参数的校验：
//      1.引入Spring Validation起步依赖
//      2.在Controller类上添加@Validated注解
//      3.在参数前面添加注解@Pattern(regexp="正则表达式")
//  注意：若请求参数不满足正则表达式，则服务器返回500号异常
//
//
//  Validation对实体类参数的校验：
//      1.在实体类中，添加参数校验注解
//      2.在接口方法的实体参数上，添加@Validated注解
//
//
//  常见的Validation注解：
//      @Pattern(regexp="正则表达式")：必须满足正则表达式
//      @NotNull：值不能为null
//      @NotEmpty：值不能为null,并且内容不为空
//      @Email：满足邮箱格式
//      @URL：满足URL格式
//


@Controller
@RequestMapping("/user")
@ResponseBody// 表示返回json
@Validated// 参数校验注解
public class UserController {

    @Autowired
    private UserService userService;


    // 用户注册
    // 注意：Validation框架的@Pattern注解--使用正则表达式对请求参数进行合法性验证。
    @PostMapping("/register")// 请求方式为post
    public Result register(@Pattern(regexp = "^\\S{1,16}$") String username,// 参数验证功能：使该参数必须由[1,16]个非空字符组成
                           @Pattern(regexp = "^\\S{1,16}$") String password) {
        // ①查询该用户是否已经注册
        User user = userService.findUserByUsername(username);
        if (user != null) {// 若用户已经被注册
            return Result.error("用户名已被占用");
        }

        // ②注册该用户
        userService.register(username, password);
        return Result.success();
    }


    // 用户登录
    @PostMapping("/login")
    public Result login(@Pattern(regexp = "^\\S{1,16}$") String username,// 参数验证功能：使该参数必须由[1,16]个非空字符组成
                        @Pattern(regexp = "^\\S{1,16}$") String password) {
        // ①根据用户名获取用户
        User user = userService.findUserByUsername(username);
        if (user == null) {// 若用户不存在
            return Result.error("用户名错误");
        }

        // ②判断密码是否正确
        boolean isTrue = MD5Util.match(password, user.getPassword());
        if (!isTrue) {// 若密码错误
            return Result.error("密码错误");
        }

        // ③登录成功，将该用户的JWT令牌发送给前端
        HashMap<String, Object> userMap = new HashMap<>();// JWT令牌的有效载荷
        userMap.put("id", user.getId());
        userMap.put("username", user.getUsername());
        String token = JWTUtil.createToken(userMap);// 获取该用户的JWT令牌
        return Result.success(token);// 将令牌作为响应数据，发送给前端
    }


//    // 测试方法：保证必须登录后才能使用该方法！
//    //（后续将以下步骤写到拦截器中，使用拦截器统一验证令牌）
//    @RequestMapping("/test")
//    public Result test(@RequestHeader(name = "Authorization") String token,// 接收请求头中，Authorization键对应的JWT令牌值。
//                       HttpServletResponse httpServletResponse) {
//        try {
//            Map<String, Object> userMap = JWTUtil.verifyToken(token);// 验证令牌，并获取令牌中登录用户的数据
//            return Result.success(userMap.toString());
//        } catch (Exception e) {// 若令牌验证失败（令牌不存在/被篡改/超时）
//            httpServletResponse.setStatus(401);// 返回响应状态码
//            return Result.error("用户未登录");
//        }
//    }


    // 获取当前登录用户的全部信息（通过令牌获取当前正在登录的用户）
    @GetMapping("/userInfo")
    public Result userInfo() {
        Map<String, Object> userMap = ThreadLocalUtil.get();// 从ThreadLocal中获取本次登录的用户的map
        User user = userService.findUserByUsername(userMap.get("username").toString());
        return Result.success(user);
    }


    // 更新用户信息
    @PutMapping("/update")
    public Result update(@RequestBody @Validated User user) {
        // @RequestBody注解用于接收json数据，并将其转换为实体类； @Validated注解，使得User实体类中的Validated参数校验注解生效。
        userService.update(user);
        return Result.success();
    }


    // 更新用户头像
    @PatchMapping("/updateAvatar")
    public Result updateAvatar(@RequestParam @URL String avatarUrl) {// 参数用于接收头像的URL地址（@URL是Validated对url的格式校验）
        Map<String, Object> userMap = ThreadLocalUtil.get();// 获取本次登录用户信息
        userService.updateAvatarById((Integer) userMap.get("id"), avatarUrl);
        return Result.success();
    }


    // 更新用户密码
    // 注意：使用map集合接收密码，其中(原密码：old_pwd，新密码：new_pwd，确认新密码：re_pwd)
    @PatchMapping("/updatePassword")
    public Result updatePassword(@RequestBody Map<String, String> pwdMap) {// 接收请求体中的json数据
        Map<String, Object> userMap = ThreadLocalUtil.get();// 获取本次登录用户信息
        Integer id = (Integer) userMap.get("id");
        String username = (String) userMap.get("username");
        String oldPwd = pwdMap.get("old_pwd");
        String newPwd = pwdMap.get("new_pwd");
        String rePwd = pwdMap.get("re_pwd");

        // 检验密码是否为空
        if (!StringUtils.hasLength(oldPwd) || !StringUtils.hasLength(newPwd) || !StringUtils.hasLength(rePwd)) {
            return Result.error("缺少必要参数");
        }

        // 验证旧密码是否正确
        String password = userService.findUserByUsername(username).getPassword();
        if (!MD5Util.match(oldPwd, password)) {
            return Result.error("原密码书写不正确");
        }

        // 验证两次新密码是否一致
        if (!newPwd.equals(rePwd)) {
            return Result.error("两次新密码填写不一致");
        }

        // 验证全部正确，更新密码
        userService.updatePasswordById(id, newPwd);
        return Result.success();
    }

}
