package com.etlpat.service;

import com.etlpat.pojo.Category;

import java.util.List;

public interface CategoryService {
    // 新增分类
    void addCategory(Category category);

    // 查询某用户的全部分类
    List<Category> getListByCreateUser(Integer createUser);

    // 根据id查询分类信息
    Category getCategoryById(Integer id);

    // 更新分类
    void update(Category category);

    // 删除分类
    void delete(Integer id);
}
