package com.etlpat;

import com.etlpat.javaBean.User;
import com.etlpat.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        // 将MyBatis配置文件转换为输入流
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 获取MyBatis的SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 从工厂获取本次会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取mapper接口对应的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);


        // 使用代理对象，进行CRUD操作
        System.out.println("***********************************************");
        User user = new User("jimmy", "114514");
        mapper.insert(user);
        System.out.println(user);

        System.out.println("***********************************************");
        mapper.delete(2);

        System.out.println("***********************************************");
        User user1 = new User(1, "JIM", "1919810");
        mapper.update(user1);

        System.out.println("***********************************************");
        User user2 = mapper.selectById(5);
        System.out.println(user2);

        System.out.println("***********************************************");
        List<User> users = mapper.selectAll();
        for (User u : users) {
            System.out.println(u);
        }


        // 提交并关闭会话
        sqlSession.commit();
        sqlSession.close();
    }
}