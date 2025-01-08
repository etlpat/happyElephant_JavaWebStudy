package com.etlpat;

import com.etlpat.mapper.StudentMapper;
import com.etlpat.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        // (1)获取MyBatis配置文件的输入流
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        // (2)获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // (3)获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // (4)获取mapper接口的代理对象
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);


        // (5)使用mapper代理对象的数据库操纵方法
        // <1>查询全部信息
        System.out.println("====================1.查询全部信息====================");
        List<Student> students1 = mapper.selectAllStudent();
        for (Student student : students1) {
            System.out.println(student);
        }
        System.out.println("=====================================================");

        // <2>根据姓名模糊查询
        System.out.println("====================2.根据姓名模糊查询====================");
        List<Student> students2 = mapper.selectStudentLikeName("三");
        for (Student student : students2) {
            System.out.println(student);
        }
        System.out.println("=====================================================");

        // <3>动态sql语句，按照姓名、地址查询
        // <3.1>动态sql-都不为空
        System.out.println("====================3.1.动态sql-都不为空====================");
        List<Student> students3_1 = mapper.selectStudentByNameAndAddress("张三", "山西");
        for (Student student : students3_1) {
            System.out.println(student);
        }
        System.out.println("=====================================================");

        // <3.2>动态sql-姓名为空
        System.out.println("====================3.2.动态sql-姓名为空====================");
        List<Student> students3_2 = mapper.selectStudentByNameAndAddress(null, "山西");
        for (Student student : students3_2) {
            System.out.println(student);
        }
        System.out.println("=====================================================");

        // <3.3>动态sql-地址为空
        System.out.println("====================3.3.动态sql-地址为空====================");
        List<Student> students3_3 = mapper.selectStudentByNameAndAddress("张三", null);
        for (Student student : students3_3) {
            System.out.println(student);
        }
        System.out.println("=====================================================");

        // <3.4>动态sql-都为空
        System.out.println("====================3.4.动态sql-都为空====================");
        List<Student> students3_4 = mapper.selectStudentByNameAndAddress(null, null);
        for (Student student : students3_4) {
            System.out.println(student);
        }
        System.out.println("=====================================================");


        // (6)提交事务、释放资源
        sqlSession.commit();
        sqlSession.close();
    }
}