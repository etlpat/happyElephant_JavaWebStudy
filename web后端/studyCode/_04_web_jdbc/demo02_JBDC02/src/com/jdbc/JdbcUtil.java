package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcUtil {

    // 用于加载驱动、建立数据库连接的方法
    public static Connection myGetConnection() throws Exception {
        // 加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 获得数据库连接
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String username = "root";
        String password = "JMGMKSZ1919810";
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    // 用于关闭数据库，释放资源的方法
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
