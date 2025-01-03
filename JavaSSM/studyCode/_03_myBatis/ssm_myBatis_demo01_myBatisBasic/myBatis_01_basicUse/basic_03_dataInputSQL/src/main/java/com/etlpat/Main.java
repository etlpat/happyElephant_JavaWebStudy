package com.etlpat;

import com.etlpat.mapper.EmployeeMapper;
import com.etlpat.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;


// 3.将外部数据输入SQL语句

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
        System.out.println(mapper.queryByID(1));
        System.out.println(mapper.queryBySalary(777.77));
//        System.out.println(mapper.insertEmployee(new Employee("张三", 114.5)));
        System.out.println(mapper.queryByNameAndSalary("张三", 114.5));
        Map map = new HashMap<String, Object>();
        map.put("name", "李四");
        map.put("salary", 514.19);
//        System.out.println(mapper.insertMapEmp(map));

        // (6)提交事务、释放资源
        sqlSession.commit();
        sqlSession.close();
    }
}