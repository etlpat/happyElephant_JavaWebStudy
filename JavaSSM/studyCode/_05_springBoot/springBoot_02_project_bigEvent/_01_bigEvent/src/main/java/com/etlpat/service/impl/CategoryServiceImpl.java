package com.etlpat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.etlpat.mapper.CategoryMapper;
import com.etlpat.pojo.Category;
import com.etlpat.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;


    @Override
    public void addCategory(Category category) {
        category.setCreateTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());
        categoryMapper.insert(category);
    }

    @Override
    public List<Category> getListByCreateUser(Integer createUser) {
        LambdaQueryWrapper<Category> wrapper = new LambdaQueryWrapper<Category>()
                .eq(Category::getCreateUser, createUser);
        return categoryMapper.selectList(wrapper);
    }

    @Override
    public Category getCategoryById(Integer id) {
        return categoryMapper.selectById(id);
    }

    @Override
    public void update(Category category) {
        LambdaUpdateWrapper<Category> wrapper = new LambdaUpdateWrapper<Category>()
                .set(Category::getCategoryName, category.getCategoryName())
                .set(Category::getCategoryAlias, category.getCategoryAlias())
                .set(Category::getUpdateTime, LocalDateTime.now())
                .eq(Category::getId, category.getId());
        categoryMapper.update(null, wrapper);
    }

    @Override
    public void delete(Integer id) {
        categoryMapper.deleteById(id);
    }
}
