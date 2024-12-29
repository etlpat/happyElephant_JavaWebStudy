package com.etlpat;

import com.etlpat.mapper.UserMapper;
import com.etlpat.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


// 调用MyBatis提供的API，对数据库进行操纵
public class Main {
    private SqlSession sqlSession;

    // junit会在每一个@Test方法前执行@BeforeEach方法
    @BeforeEach
    public void init() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession(true);
    }

    // junit会在每一个@Test方法后执行@@AfterEach方法
    @AfterEach
    public void destroy() {
        sqlSession.close();
    }

    @Test
    public void insertUserTest() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User("jimmy", "114514");
        System.out.println(mapper.insertUser(user));
        System.out.println("回显的主键为：" + user.getId());
    }

    @Test
    public void deleteUserByIdTest() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(mapper.deleteUserById(1));
    }

    @Test
    public void updateUserTest() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(2, "jim", "191981");
        System.out.println(mapper.updateUser(user));
    }

    @Test
    public void selectUserByIdTest() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user1 = mapper.selectUserById(2);
        User user2 = mapper.selectUserById(3);
        System.out.println(user1);
        System.out.println(user2);
    }

    @Test
    public void selectAllUserTest() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectAllUser();
        System.out.println("集合为：" + users);
        for (User user : users) {
            System.out.println(user);
        }
    }
}