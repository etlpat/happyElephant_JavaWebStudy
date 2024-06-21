package com.jdbc;


import com.javaBean.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DAO {

    // 为数据库增加对象
    public boolean insert(User user) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // 连接DB
            conn = JDBCUtil.myGetConnection();
            // 获取通道对象
            stmt = conn.createStatement();
            // 运行sql语句
            String sql = "insert into users1 values('"
                    + user.getUsername() + "','"
                    + user.getPassword() + "');";
            int num = stmt.executeUpdate(sql);
            // 处理结果
            if (num > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            // 关闭资源
            JDBCUtil.myClose(conn, stmt, null);
        }
        return false;
    }


    // 获取students1表全部行
    public ArrayList<User> getAll() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // 连接DB
            conn = JDBCUtil.myGetConnection();
            // 获取通道对象
            stmt = conn.createStatement();
            // 运行sql语句
            String sql = "select * from users1";
            stmt.execute(sql);
            // 处理结果
            rs = stmt.getResultSet();
            ArrayList<User> arrayList = new ArrayList<>();
            while (rs.next()) {
                arrayList.add(new User(
                        rs.getString("username"),
                        rs.getString("password")
                ));
            }
            return arrayList;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            // 关闭资源
            JDBCUtil.myClose(conn, stmt, null);
        }
        return null;
    }
}
