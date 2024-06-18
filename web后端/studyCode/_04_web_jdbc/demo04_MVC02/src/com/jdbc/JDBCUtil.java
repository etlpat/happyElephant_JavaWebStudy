package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCUtil {

    // 加载驱动，获取连接对象
    public static Connection myGetConnection() throws Exception {
        // 加载驱动
        Class.forName("com.mysql.jdbc.Driver");

        // 连接数据库
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String user = "root";
        String password = "JMGMKSZ1919810";
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    // 关闭资源
    public static void myClose(Connection conn, Statement stmt, ResultSet rs) {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
