package com.etlpat.controller;

import com.etlpat.pojo.Article;
import com.etlpat.service.ArticleService;
import com.etlpat.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    CommentService commentService;

    @RequestMapping("/findAll")
    public String findAll(Model model) {
        List<Article> allArticle = articleService.getAllArticle();
        model.addAttribute("articleList", allArticle);
        return "articleList";
    }

    @RequestMapping("/findById")
    public String findById(@RequestParam("id") int id, Model model) {
        Article article = articleService.getArticleById(id);
        article.setCommentList(commentService.getCommentsByAuthorId(id));
        model.addAttribute("article", article);
        return "articleDetail";
    }
}
