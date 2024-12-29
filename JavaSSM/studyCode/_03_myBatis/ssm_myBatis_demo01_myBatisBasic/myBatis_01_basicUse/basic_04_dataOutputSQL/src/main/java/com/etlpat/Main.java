package com.etlpat;

import com.etlpat.mapper.EmployeeMapper;
import com.etlpat.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


// 4.向外输出sql语句的返回结果

// 使用MyBatis提供的API，对数据库进行操纵
public class Main {
    public static void main(String[] args) throws IOException {
        // (1)获取MyBatis配置文件的输入流
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        // (2)获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // (3)获取sqlSession【参数为true，则自动提交事务】
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        // (4)获取mapper接口的代理对象
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);


        // (5)使用mapper代理对象的数据库操纵方法
        System.out.println(mapper.deleteById(10));
        System.out.println(mapper.queryNameById(4));
        System.out.println(mapper.queryById(3));
        System.out.println(mapper.queryMapById(3));
        List<Employee> employees = mapper.queryAll();
        System.out.println(employees);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println("======================================");

        Employee employee = new Employee("赵六", 19.81);
        System.out.println(employee);
        System.out.println(mapper.insertEmployee(employee));
        System.out.println(employee);


        // (6)提交事务、释放资源
//        sqlSession.commit();// （已经设置了自动提交事务）
        sqlSession.close();
    }
}