package com.etlpat.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


//  常见的Validation注解：（用于参数的合法性校验）
//      @Pattern(regexp="正则表达式")：必须满足正则表达式
//      NotNull：值不能为null
//      NotEmpty：值不能为null,并且内容不为空
//      Email：满足邮箱格式
//
//  Validation详细介绍，见：com.etlpat.controller.UserController
//


@Data// lombok注解，用于在编译阶段自动生成getter、setter、toString等方法
@NoArgsConstructor// 添加无参构造器
@AllArgsConstructor// 添加全参构造器
public class User {// 用户表

    @NotNull// Validation注解，值不能为null
    private Integer id;// ID

    private String username;// 用户名

    @JsonIgnore// 功能：当springMVC将user转换为json字符串时，忽略password属性，保证安全。
    private String password;// 密码

    @NotEmpty// Validation注解，值不能为null,并且内容不为空
    @Pattern(regexp = "^\\S{1,10}$")// Validation注解，必须满足正则表达式
    private String nickname;// 昵称

    @NotEmpty// Validation注解，值不能为null,并且内容不为空
    @Email// Validation注解，必须满足邮件格式
    private String email;// 邮箱

    private String userPic;// 头像

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;// 创建时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;// 修改时间

}
