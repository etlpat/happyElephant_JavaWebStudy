package com.etlpat.controller;

import com.etlpat.pojo.Article;
import com.etlpat.pojo.PageBean;
import com.etlpat.pojo.Result;
import com.etlpat.service.ArticleService;
import com.etlpat.utils.ThreadLocalUtil;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Controller
@RequestMapping("/article")
@ResponseBody// 表示返回json
@Validated// 参数校验注解
public class ArticleController {
    @Autowired
    private ArticleService articleService;


    // 添加文章
    @PostMapping
    public Result add(@RequestBody @Validated(Article.Add.class) Article article) {
        Map<String, Object> userMap = ThreadLocalUtil.get();// 获取本次登录用户信息
        article.setCreateUser((Integer) userMap.get("id"));
        articleService.add(article);
        return Result.success();
    }


    // 分页查询文章列表
    @GetMapping
    public Result<PageBean<Article>> getPageArticleByCreateUser(
            @NotNull Integer pageNum,// 页数
            @NotNull Integer pageSize,// 每页条数
            @RequestParam(required = false) Integer categoryId,// 文章分类id（非必须）
            @RequestParam(required = false) @Pattern(regexp = "^(已发布|草稿)$") String state// 发布状态（非必须）
    ) {
        Integer id = (Integer) ((Map) ThreadLocalUtil.get()).get("id");// 本次登录用户id
        PageBean<Article> pageBean = articleService.getPageArticleByCreateUser(pageNum, pageSize, categoryId, state, id);
        return Result.success(pageBean);
    }


    // 根据id获取文章
    @GetMapping("/getArticleById")
    public Result<Article> getArticleById(@NotNull Integer id) {
        return Result.success(articleService.getArticleById(id));
    }


    // 更新文章信息
    @PutMapping
    public Result update(@RequestBody @Validated(Article.Update.class) Article article) {
        articleService.update(article);
        return Result.success();
    }


    // 删除文章
    @DeleteMapping
    public Result delete(@NotNull Integer id) {
        articleService.delete(id);
        return Result.success();
    }
}
