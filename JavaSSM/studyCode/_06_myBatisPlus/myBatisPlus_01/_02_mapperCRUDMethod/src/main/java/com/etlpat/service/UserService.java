package com.etlpat.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.etlpat.mapper.UserMapper;
import com.etlpat.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


// baseMapper接口提供的CRUD方法
//
//
// (1)insert方法
//  ①插入一条记录（默认主键生成策略为雪花算法）
//      int insert(T entity);
//
//
// (2)delete方法
//  ①根据Wrapper条件，删除记录
//      int delete(@Param(Constants.WRAPPER) Wrapper<T> wrapper);
//  ②根据ID删除
//      int deleteById(Serializable id);
//  ③根据ID批量删除
//      int deleteBatchIds(@Param(Constants.COLLECTION) Collection<? extends Serializable> idList);
//  ④根据Map条件，删除记录（map为<列名,值>）
//      int deleteByMap(@Param(Constants.COLUMN_MAP) Map<String, Object> columnMap);
//
//
// (3)update方法
//  ①根据Wrapper条件，更新记录
//      int update(@Param(Constants.ENTITY) T entity, @Param(Constants.WRAPPER) Wrapper<T> wrapper);
//  ②根据ID修改（主键属性不能为null）
//      int updateById(@Param(Constants.ENTITY) T entity);
//  注意：update方法，当属性值为null时，对应列不进行修改
//
//
// (4)select方法
//  ①根据Wrapper条件，查询一条记录
//      T selectOne(@Param(Constants.WRAPPER) Wrapper<T> wrapper);
//  ②根据Wrapper条件，查询多条记录
//      List<T> selectList(@Param(Constants.WRAPPER) Wrapper<T> wrapper);
//  ③根据ID查询
//      T selectById(Serializable id);
//  ④根据ID批量查询
//      List<T> selectBatchIds(@Param(Constants.COLLECTION) Collection<? extends Serializable> idList);
//  ⑤根据Map条件查询
//      List<T> selectByMap(@Param(Constants.COLUMN_MAP) Map<String, Object> columnMap);
//  ⑥根据Wrapper条件，查询Map记录
//      List<Map<String, Object>> selectMaps(@Param(Constants.WRAPPER) Wrapper<T> wrapper);
//  ⑦根据Wrapper条件，查询总记录数
//      Integer selectCount(@Param(Constants.WRAPPER) Wrapper<T> wrapper);
//  ⑧根据Wrapper条件，进行分页查询（需要引入分页插件）
//      IPage<T> selectPage(IPage<T> page, @Param(Constants.WRAPPER) Wrapper<T> wrapper);
//


@SpringBootTest// 用于将该类设为测试类
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;


    // (1)insert方法
    //  ①插入一条记录（默认主键生成策略为雪花算法）
    //      int insert(T entity);
    @Test
    public void insertMethod() {
        // 插入一条记录
        User user = new User("jimmy", "88888888");
        int num = userMapper.insert(user);
        System.out.println(num);
    }


    // (2)delete方法
    //  ①根据Wrapper条件，删除记录
    //      int delete(@Param(Constants.WRAPPER) Wrapper<T> wrapper);
    //  ②根据ID删除
    //      int deleteById(Serializable id);
    //  ③根据ID批量删除
    //      int deleteBatchIds(@Param(Constants.COLLECTION) Collection<? extends Serializable> idList);
    //  ④根据Map条件，删除记录（map为<列名,值>）
    //      int deleteByMap(@Param(Constants.COLUMN_MAP) Map<String, Object> columnMap);
    @Test
    public void deleteMethod() {
        // 根据id删除
        int num1 = userMapper.deleteById(5);
        System.out.println(num1);

        // 根据Map条件，删除记录
        HashMap hashMap = new HashMap();
        hashMap.put("username", "王五");// 把"username=王五"的记录删除
        int num2 = userMapper.deleteByMap(hashMap);
        System.out.println(num2);
    }


    // (3)update方法
    //  ①根据Wrapper条件，更新记录
    //      int update(@Param(Constants.ENTITY) T entity, @Param(Constants.WRAPPER) Wrapper<T> wrapper);
    //  ②根据ID修改（主键属性不能为null）
    //      int updateById(@Param(Constants.ENTITY) T entity);
    //  注意：update方法，当属性值为null时，对应列不进行修改
    @Test
    public void updateMethod() {
        // 根据ID修改
        User user = new User(1L, "JIM", null);// 注意：实体对象中null属性对应的表中字段，不会被修改！
        int num = userMapper.updateById(user);
        System.out.println(num);
    }


    // (4)select方法
    //  ①根据Wrapper条件，查询一条记录
    //      T selectOne(@Param(Constants.WRAPPER) Wrapper<T> wrapper);
    //  ②根据Wrapper条件，查询多条记录
    //      List<T> selectList(@Param(Constants.WRAPPER) Wrapper<T> wrapper);
    //  ③根据ID查询
    //      T selectById(Serializable id);
    //  ④根据ID批量查询
    //      List<T> selectBatchIds(@Param(Constants.COLLECTION) Collection<? extends Serializable> idList);
    //  ⑤根据Map条件查询
    //      List<T> selectByMap(@Param(Constants.COLUMN_MAP) Map<String, Object> columnMap);
    //  ⑥根据Wrapper条件，查询Map记录
    //      List<Map<String, Object>> selectMaps(@Param(Constants.WRAPPER) Wrapper<T> wrapper);
    //  ⑦根据Wrapper条件，查询总记录数
    //      Integer selectCount(@Param(Constants.WRAPPER) Wrapper<T> wrapper);
    //  ⑧根据Wrapper条件，进行分页查询（需要引入分页插件）
    //      IPage<T> selectPage(IPage<T> page, @Param(Constants.WRAPPER) Wrapper<T> wrapper);
    @Test
    public void selectMethod() {
        // 根据ID查询
        User user = userMapper.selectById(1);
        System.out.println("#############################################");
        System.out.println(user);
        System.out.println("#############################################");

        // 根据ID批量查询
        ArrayList<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        list.add(4L);
        List<User> users1 = userMapper.selectBatchIds(list);
        System.out.println("#############################################");
        for (User user1 : users1) {
            System.out.println(user1);
        }
        System.out.println("#############################################");

        // 查询全部
        List<User> users2 = userMapper.selectList(null);// 当wrapper为null时，表示没有条件
        System.out.println("#############################################");
        for (User user2 : users2) {
            System.out.println(user2);
        }
        System.out.println("#############################################");
    }


    // (5)分页查询
    //  ①根据Wrapper条件，进行分页查询（需要引入分页插件）
    //      IPage<T> selectPage(IPage<T> page, @Param(Constants.WRAPPER) Wrapper<T> wrapper);
    @Test
    public void selectPageMethod() {
        // 设置分页参数
        Page<User> page = new Page<>(2, 3);// Page参数：(当前页, 每页条数)
        userMapper.selectPage(page, null);// 进行分页查询！（查询结果封装在page对象中！）
        // 获取分页数据
        System.out.println("#############################################");
        List<User> list = page.getRecords();// 获取本页的记录集合
        for (User user : list) {
            System.out.println(user);
        }
        System.out.println("#############################################");
        System.out.println("当前页：" + page.getCurrent());
        System.out.println("每页显示的条数：" + page.getSize());
        System.out.println("总记录数：" + page.getTotal());
        System.out.println("总页数：" + page.getPages());
        System.out.println("是否有上一页：" + page.hasPrevious());
        System.out.println("是否有下一页：" + page.hasNext());
        System.out.println("#############################################");
    }
}
