package com.etlpat;

import com.etlpat.mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


// 4.向外输出sql语句的返回结果

// 使用MyBatis提供的API，对数据库进行操纵
public class Main {
    public static void main(String[] args) throws IOException {
        // (1)获取MyBatis配置文件的输入流
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        // (2)获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // (3)获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // (4)获取mapper接口的代理对象
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);


        // (5)使用mapper代理对象的数据库操纵方法
        System.out.println(mapper.deleteById(10));
        System.out.println(mapper.queryNameById(4));

        // (6)提交事务、释放资源
        sqlSession.commit();
        sqlSession.close();
    }
}