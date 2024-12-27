package com.etlpat;

import com.etlpat.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


// 使用iBatis方式，进行数据库的调用
//
// (1)iBatis方式操纵数据库流程：
//  ①创建MapperXML文件，存放sql语句（不创建mapper接口）
//  ②创建MyBatis配置文件（与MyBatis方式完全一致）
//  ③获取SqlSession对象，使用该对象，直接调用CRUD方法，操纵数据库（不创建mapper代理对象）
//
// (2)iBatis如何封装成MyBatis？
//  MyBatis，本质上只是对iBatis的一层封装。
//  MyBatis通过创建mapper代理对象，将iBatis方式下的CRUD方法封装进了mapper代理对象的方法中。
//  mapper代理对象调用接口方法，底层仍是调用iBatis的CRUD方法。iBatis的(namespace.id, sql参数)，前者通过反射获取[类全名.方法名]即可自动填充。
//  因此，使用MyBatis后，我们只需调用简单的代理对象，即可代替iBat5is中对CRUD方法的复杂调用过程。
//

public class Main {
    public static void main(String[] args) throws IOException {
        // (1)将MyBatis配置文件转化为输入流对象
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        // (2)获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // (3)获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();


        // (4)直接使用SqlSession提供的CRUD方法，进行数据库的操纵
        //
        // <1>iBatis方式的CRUD方法
        //  SqlSession提供的DRUD方法：selectOne / selectList / insert / delete / update
        //  CRUD方法参数：
        //      参数1：字符串 = sql标签的 id / namespace.id
        //      参数2：Object = 执行sql语句传入的参数
        //  CRUD方法的功能：
        //      在mapperXML中，查找对应的sql语句标签，传入参数并执行sql语句。
        //
        // <2>iBatis方式使用的缺点：
        //      ①参数namespace.id字符串需手写，易出错。
        //      ②只能给sql语句传递1个参数，使用繁琐。
        //      ③返回值默认为Object，无自动提示。
        //
        // <3>
        //
        Employee employee1 = sqlSession.selectOne("myNamespace.id1", 1);
        Employee employee2 = sqlSession.selectOne("myNamespace.id1", 2);
        Employee employee3 = sqlSession.selectOne("myNamespace.id1", 3);
        System.out.println(employee1);
        System.out.println(employee2);
        System.out.println(employee3);


        // (5)提交事务并释放资源
        sqlSession.commit();
        sqlSession.close();
    }
}