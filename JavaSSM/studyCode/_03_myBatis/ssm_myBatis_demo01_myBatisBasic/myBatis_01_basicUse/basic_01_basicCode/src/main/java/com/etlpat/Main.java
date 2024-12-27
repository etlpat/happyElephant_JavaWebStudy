package com.etlpat;

import com.etlpat.mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


// myBatis快速入门案例

// 通过MyBatis提供的API，进行Mapper层方法的调用
public class Main {
    public static void main(String[] args) throws IOException {
        // (1)将MyBatis配置文件转化为输入流对象
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        // (2)创建SqlSessionFactory对象（并将MyBatis配置文件设置给它）
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // (3)根据SqlSessionFactory工厂获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // (4)使用SqlSession对象，获取Mapper接口的代理对象（JDK动态代理技术）
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        // (5)使用Mapper代理对象，操纵数据库
        System.out.println(mapper.queryById(1));
        System.out.println(mapper.queryById(2));
        System.out.println(mapper.queryById(3));

        // (6)提交事务(DML语句)，并释放资源
        sqlSession.commit();
        sqlSession.close();
    }
}