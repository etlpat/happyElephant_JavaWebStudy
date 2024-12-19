package com.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class JDBCUtil {

    // 加载驱动、获取连接
    public static Connection myGetConnection() throws Exception {
        // 加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 获取连接
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String username = "root";
        String password = "JMGMKSZ1919810";
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }


    // 关闭资源
    public static void myClose(Connection connection, Statement statement, ResultSet resultSet) {
        if (connection != null) {
            try {
                connection.close();
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
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
