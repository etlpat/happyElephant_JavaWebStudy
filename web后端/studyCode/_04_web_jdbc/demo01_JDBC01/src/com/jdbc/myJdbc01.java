package com.jdbc;

import java.sql.*;

// JDBC
//
// (1)JDBC操作数据库流程
//  1.加载驱动
//  2.连接数据库，并获取数据库的连接对象
//  3.获取通道对象
//  4.使用通道对象执行sql语句
//  5.使用通道对象获取、处理查询结果集（仅select语句）
//  6.关闭资源
//
//
// (2)流程演示
//  通过如下代码详细演示JDBC的流程


public class myJdbc01 {

    public static void main(String[] args) {

        // 声明对象
        // （以下对象在try代码块中声明，在finally代码块中销毁；位于不同的代码块，因此必须提前声明）
        Connection connection = null;// 连接对象
        Statement statement = null;// 通道对象
        ResultSet resultSet = null;// 结果集对象

        try {
            // 1.加载驱动
            // 加载驱动后，才可以使用DriverManager类
            Class.forName("com.mysql.jdbc.Driver");


            // 2.连接数据库，并获取数据库的连接对象
            // 数据库的url：协议://ip:端口号/数据库名
            // （其中，jdbc连接MySQL的协议是jdbc:mysql；MySQL默认的端口号是3306）
            String url = "jdbc:mysql://localhost:3306/jdbc";
            String username = "root";
            String password = "JMGMKSZ1919810";
            // getConnection是DriverManager类的静态方法，可以直接通过类名调用
            connection = DriverManager.getConnection(url, username, password);


            // 3.通过连接对象，获取通道对象（也叫执行者对象）
            statement = connection.createStatement();


            // 4.使用通道对象执行sql语句
            // statement通道对象用于执行sql语句，以及保存返回的结果集对象
            String str1 = "select * from students";
            // execute：v.执行 [该方法可以执行所有dml方法（insert、delete、select、update）]
            statement.execute(str1);


            // 5.使用通道对象获取、处理查询结果集（仅select语句）
            // 获取结果集对象（只有select语句才返回结果集对象）
            resultSet = statement.getResultSet();
            // resultSet对象初始指向数据表的前一行，每次调用next()方法就会指向下一行，若下一行没有数据则返回false。
            // 也就是说，resultSet并不代表整个结果集，而是代表table中的“一行数据”
            while (resultSet.next()) {
                // 方法：resultSet.getString("字段名");  功能：以String的形式，获取本行中指定字段对应的值。
                System.out.println(resultSet.getString("id") + "\t" +
                        resultSet.getString("name") + "\t" +
                        resultSet.getString("sex") + "\t" +
                        resultSet.getString("age") + "\t" +
                        resultSet.getString("email")
                );
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            // 6.关闭资源
            // （为了保证无论是否异常都要关闭资源，我们把关闭资源的代码放入finally中）
            if (resultSet != null) {
                try {// 用于out()方法也会抛出异常，因此与需要分别try-catch处理
                    resultSet.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }
}
