package com.etlpat.service;

import com.etlpat.pojo.Article;
import com.etlpat.pojo.PageBean;

public interface ArticleService {
    // 添加文章
    void add(Article article);

    // 分页查询文章列表
    PageBean<Article> getPageArticleByCreateUser(
            Integer pageNum, Integer pageSize,
            Integer categoryId, String state,
            Integer createUser);

    // 根据id获取文章
    Article getArticleById(Integer id);

    // 更新文章
    void update(Article article);

    // 删除文章
    void delete(Integer id);
}
