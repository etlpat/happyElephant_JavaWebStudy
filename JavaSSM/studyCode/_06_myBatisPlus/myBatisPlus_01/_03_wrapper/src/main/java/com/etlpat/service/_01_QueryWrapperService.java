package com.etlpat.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.etlpat.mapper.UserMapper;
import com.etlpat.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import java.util.List;


// 基于QueryWrapper组装条件
//
//
//（1）条件构造器Wrapper的介绍
//    条件构造器Wrapper对象，用于表示【sql语句中的where条件】！
//        ·使用MyBatis-Plus的条件构造器Wrapper，你可以构建灵活、高效的where查询条件，而不需要手动编写复杂的SQL语句。
//        ·它提供了许多方法来支持各种where条件的操作符，并且可以通过链式调用来组合多个条件。这样可以简化查询的编写过程，并提高开发效率。
//
//
//（2）条件构造器Wrapper的继承结构
//    Wrapper：条件构造抽象类，最顶端父类
//        -AbstractWrapper：用于查询条件封装，生成sql的where条件
//            -【QueryWrapper】：select/delete/update语句的where条件封装
//            -【UpdateWrapper】：update语句的where+set条件封装
//            - AbstractLambdaWrapper：支持使用Lambda语法
//                -【LambdaQueryWrapper】：支持使用Lambda语法的QueryWrapper
//                -【LambdaUpdateWrapper】：支持使用Lambda语法的UpdateWrapper
//
//
//（3）基于QueryWrapper的组装where条件方法
//    注意：以下为QueryWrapper的常用方法列表，且UpdateWrapper、LambdaQueryWrapper、LambdaUpdateWrapper均适用！
//    P.S.以下方法均返回wrapper对象本身，因此支持链式调用。
//    --------------------------------------------------------------------------------------------------------------------
//    函数	        说明	                    例子
//    --------------------------------------------------------------------------------------------------------------------
//    eq	        等于(=)	                queryWrapper.eq(“user_name”, “张三”); //user_name=“张三”
//    ne	        不等于(<>)	            queryWrapper.ne(“user_name”, “张三”); //user_name<>“张三”
//    gt	        大于(>)	                queryWrapper.gt(“level”, 1); //level>1
//    ge	        大于等于(>=)	            queryWrapper.ge(“level”, 1); //level>=1
//    lt	        小于(<)	                queryWrapper.lt(“level”, 1); //level<1
//    le	        小于等于(<=)	            queryWrapper.le(“level”, 1); //level<=1
//    between	    值1和值2之间	            queryWrapper.between(“level”, 1,10); //level>=1 and level <=10
//    notBetween    不在值1和值2之间	        queryWrapper.notBetween(“level”, 1,10); //level<1 or level >10
//    like	        模糊匹配 like %值%	    queryWrapper.like(“user_name”, “张三”); //user_name like “%张三%”
//    notLike	    不模糊匹配 not like %值%	queryWrapper.notLike(“user_name”, “张三”); //user_name not like “%张三%”
//    likeLeft	    左模糊匹配 like %值	    queryWrapper.likeLeft(“user_name”, “张三”); //user_name like “%张三”
//    likeRight	    右模糊匹配 like 值%	    queryWrapper.likeRight(“user_name”, “张三”); //user_name like “张三%”
//    isNull	    字段 为空	                queryWrapper.isNull(“user_name”); //user_name is null
//    isNotNull	    字段 不为空	            queryWrapper.isNotNull(“user_name”); //user_name is not null
//    in	        字段 in (v0，v1，…)	    queryWrapper.in(“user_name”, {“张三”,“李四”,“王五”}); // user_name in （“张三”,“李四”,“王五”）
//    notIn	        字段 not in (v0，vl，…)	queryWrapper.notIn(“user_name”, {“张三”,“李四”,“王五”}); // user_name not in （“张三”,“李四”,“王五”）
//    inSql	        字段 in (sql语句)	        queryWrapper.inSql(“user_name”, “select name from student where age< 23”); // user_name in (select name from student where age< 23)
//    notInSql	    字段 not in (sql语句)	    queryWrapper.notInSql(“user_name”, “select name from student where age< 23”); // user_name not in (select name from student where age< 23)
//    groupBy	    分组:GROUP BY 字段	    queryWrapper.groupBy(“user_name”); //group by user_name
//    orderByAsc	排序:ORDER BY 字段 ASC	queryWrapper.orderByAsc(“createTime”); //order by createTime asc
//    orderByDesc	排序:ORDER BY 字段 DESC	queryWrapper.orderByDesc(“createTime”); //order by createTime desc
//    orderBy	    排序:ORDER BY 字段	    queryWrapper.orderBy(true, true, “createTime”); //order by createTime asc
//    or	        拼接 OR                  queryWrapper.eq(“id”, “1”).or().eq(“user_name”, “张三”); //id = 1 or name =‘张三’
//    and	        拼接 AND	【不写默认为AND】  queryWrapper.eq(“id”, “1”).and(i->i.eq(“user_name”, “张三”)); //id = 1 and name =‘张三’
//    --------------------------------------------------------------------------------------------------------------------
//
//
//（4）使用Wrapper作为参数的CRUD方法
//    以下CRUD方法使用wrapper作为参数，用于表示where条件语句：
//        -int delete(@Param(Constants.WRAPPER) Wrapper<T> wrapper);
//        -int update(@Param(Constants.ENTITY) T entity, @Param(Constants.WRAPPER) Wrapper<T> wrapper);
//        -T selectOne(@Param(Constants.WRAPPER) Wrapper<T> wrapper);
//        -List<T> selectList(@Param(Constants.WRAPPER) Wrapper<T> wrapper);
//


@SpringBootTest// 将该类设为测试类
@Service
public class _01_QueryWrapperService {
    @Autowired
    UserMapper userMapper;


    // 组装查询条件
    @Test
    public void test01() {
        // SELECT * FROM USER WHERE username LIKE '%jim%' AND PASSWORD IS NOT NULL;

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();// wrapper用于表示where语句
        queryWrapper.like("username", "jim")
                .isNotNull("password");
        // 注意：①条件方法的返回值是wrapper对象自身，因此支持链式调用。
        //      ②条件方法间，默认用AND拼接。
        List<User> users = userMapper.selectList(queryWrapper);

        for (User user : users) {
            System.out.println(user);
        }
    }


    // 组装排序条件
    @Test
    public void test02() {
        // SELECT * FROM USER ORDER BY username ASC,PASSWORD DESC;
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>()
                .orderByAsc("username")
                .orderByDesc("password");
        List<User> users = userMapper.selectList(queryWrapper);

        for (User user : users) {
            System.out.println(user);
        }
    }


    // 组装删除条件
    @Test
    public void test03() {
        // DELETE FROM USER WHERE username IS NULL;
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>()
                .isNull("username");
        int num = userMapper.delete(queryWrapper);
        // 注意：QueryWrapper可用于select/delete/update语句中！
        System.out.println(num);
    }


    // 组装更新条件 / or关键字的使用
    @Test
    public void test04() {
        // UPDATE USER SET PASSWORD='12345678' WHERE username LIKE '%jim%' AND PASSWORD LIKE '%8%' OR PASSWORD IS NULL;

        User user = new User();// user中为null的属性，对应的表中字段不会被修改！
        user.setPassword("12345678");

        QueryWrapper<User> queryWrapper = new QueryWrapper<User>()
                .like("username", "jim")
                .like("password", "8")
                .or() // 注意：wrapper条件的方法间，默认用AND拼接。若想用OR拼接，需要手动添加.or()方法。
                .isNull("password");

        int num = userMapper.update(user, queryWrapper);

        // QueryWrapper进行update的缺点：不能将table的某字段改为空值
        // 原因：若想将某列设为null，则需要将实体类bean的属性设为null，但是若属性为空，不会修改其对应的字段。
        // 解决方案：使用UpdateWrapper

        System.out.println(num);
    }


    // 查询指定列的条件
    @Test
    public void test05() {
        // SELECT id,username FROM USER;
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>()
                .select("id", "username");// 表示只查询id,username这两列
        List<User> users = userMapper.selectList(queryWrapper);

        for (User user : users) {
            System.out.println(user);
        }
    }


    // condition判断组织条件
    @Test
    public void test06(@Value("jimmy") String username,
                       @Value("12345678") String password) {
//        username = null;
        password = null;
        // 假设前端传来两个值：username和password
        //  -当username不为null，作为条件进行查询
        //  -当password不为null，作为条件进行查询
        // 若二者为null，则不将此作为条件进行拼接

        // (1)传统方式
        QueryWrapper<User> queryWrapper1 = new QueryWrapper<>();
        if (username != null) {// 当username不为null，拼接条件
            queryWrapper1.eq("username", username);
        }
        if (password != null) {// 当password不为null，拼接条件
            queryWrapper1.eq("password", password);
        }
        List<User> users1 = userMapper.selectList(queryWrapper1);
        for (User user : users1) {
            System.out.println(user);
        }
        System.out.println("##########################################");


        // (2)拼接condition判断
        //  wrapper的每个条件拼接方法，都有一个condition参数，用于传入一条判断语句，仅当语句为true时才拼接该方法!
        //  如：eq(condition,列名,值)
        //  注意：queryWrapper2与上面传统方式的queryWrapper1是等价的。
        QueryWrapper<User> queryWrapper2 = new QueryWrapper<User>()
                .eq(username != null, "username", username)// 当condition为true时，拼接该条件；否则不拼接。
                .eq(password != null, "password", password);
        List<User> users2 = userMapper.selectList(queryWrapper2);
        for (User user : users2) {
            System.out.println(user);
        }
    }

}
