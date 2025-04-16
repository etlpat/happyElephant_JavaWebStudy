package com.etlpat.controller;

import com.etlpat.pojo.Category;
import com.etlpat.pojo.Result;
import com.etlpat.service.CategoryService;
import com.etlpat.utils.ThreadLocalUtil;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


// validated分组校验
//  功能：把校验项进行归类分组,在完成不同的功能的时候,校验指定组中的校验项。
//  步骤：
//      ①在实体类中定义分组接口。
//      ②为实体类中的校验注解设置分组。
//      ③在controller中使用@validated注解校验时，指定要校验的分组。
//  注意：定义校验项时如果没有指定分组,则属于Default分组,分组可以继承。


@Controller
@RequestMapping("/category")
@ResponseBody// 表示返回json
@Validated// 参数校验注解
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    // 添加文章分类
    @PostMapping
    public Result add(@RequestBody @Validated(Category.Add.class) Category category) {// @Validated注解执行Add分组的校验
        Map<String, Object> userMap = ThreadLocalUtil.get();// 获取本次登录用户信息
        category.setCreateUser((Integer) userMap.get("id"));// 设置创建用户的id
        categoryService.addCategory(category);
        return Result.success();
    }


    // 获取当前用户的全部文章分类
    @GetMapping
    public Result<List<Category>> getListByCreateUser() {
        Map<String, Object> userMap = ThreadLocalUtil.get();// 获取本次登录用户信息
        List<Category> list = categoryService.getListByCreateUser((Integer) userMap.get("id"));
        return Result.success(list);
    }


    // 根据id获取分类信息
    @GetMapping("/getCategoryById")
    public Result<Category> getCategoryById(@NotNull Integer id) {
        return Result.success(categoryService.getCategoryById(id));
    }


    // 更新分类信息
    @PutMapping
    public Result update(@RequestBody @Validated(Category.Update.class) Category category) {// @Validated注解执行Update分组的校验
        categoryService.update(category);
        return Result.success();
    }


    // 根据id删除分类
    @DeleteMapping
    public Result delete(@NotNull Integer id) {
        categoryService.delete(id);
        return Result.success();
    }
}
