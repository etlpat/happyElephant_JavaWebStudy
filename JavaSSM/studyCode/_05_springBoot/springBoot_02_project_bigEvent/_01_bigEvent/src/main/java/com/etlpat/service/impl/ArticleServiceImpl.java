package com.etlpat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.etlpat.mapper.ArticleMapper;
import com.etlpat.pojo.Article;
import com.etlpat.pojo.PageBean;
import com.etlpat.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;


    @Override
    public void add(Article article) {
        article.setCreateTime(LocalDateTime.now());
        article.setUpdateTime(LocalDateTime.now());
        articleMapper.insert(article);
    }


    @Override
    public PageBean<Article> getPageArticleByCreateUser(
            Integer pageNum, Integer pageSize,
            Integer categoryId, String state,
            Integer createUser) {

        // 设置分页参数
        Page<Article> page = new Page<>(pageNum, pageSize);

        // 设置Wrapper查询条件
        LambdaQueryWrapper<Article> wrapper = new LambdaQueryWrapper<Article>()
                .eq(categoryId != null, Article::getCategoryId, categoryId)// condition判断：不为空时才执行
                .eq(state != null, Article::getState, state)// condition判断：不为空时才执行
                .eq(Article::getCreateUser, createUser);

        // 进行分页查询（查询结果封装在page对象中）
        articleMapper.selectPage(page, wrapper);

        // 获取分页数据
        PageBean<Article> pageBean = new PageBean<>();
        pageBean.setTotal(page.getTotal());// 设置总记录数
        pageBean.setItems(page.getRecords());// 设置本页数据列表
        return pageBean;
    }


    @Override
    public Article getArticleById(Integer id) {
        return articleMapper.selectById(id);
    }

    @Override
    public void update(Article article) {
        LambdaUpdateWrapper<Article> wrapper = new LambdaUpdateWrapper<Article>()
                .set(Article::getTitle, article.getTitle())
                .set(Article::getContent, article.getContent())
                .set(Article::getCoverImg, article.getCoverImg())
                .set(Article::getState, article.getState())
                .set(Article::getCategoryId, article.getCategoryId())
                .set(Article::getUpdateTime, LocalDateTime.now())
                .eq(Article::getId, article.getId());
        articleMapper.update(null, wrapper);
    }

    @Override
    public void delete(Integer id) {
        articleMapper.deleteById(id);
    }
}
