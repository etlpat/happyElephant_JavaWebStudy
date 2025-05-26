package com.etlpat.service;

import com.etlpat.mapper.ArticleMapper;
import com.etlpat.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    ArticleMapper articleMapper;

    public Article getArticleById(int id) {
        return articleMapper.selectById(id);
    }

    public List<Article> getAllArticle() {
        return articleMapper.selectList(null);
    }
}
