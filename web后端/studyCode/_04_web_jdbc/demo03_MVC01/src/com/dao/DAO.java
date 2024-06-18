package com.dao;

import com.bean.RequestParamUser;
import com.bean.User;
import com.util.JBDCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


// DAO类用于实现数据库的CRUD
// 注意：每个C/R/U/D方法中都要完整的包含JDBC的流程

public class DAO {

    // 向数据库添加元素
    public boolean insert(RequestParamUser user) {
        Connection conn = null;
        Statement stmt = null;
        // 获取当前的"yyyy-MM-dd HH:mm:ss"格式的Date数据
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        try {
            // 获取连接对象
            conn = JBDCUtil.myGetConnection();
            // 获取通道对象
            stmt = conn.createStatement();
            // 执行sql语言
            String sql = "insert into users values(null,'"
                    + user.getUsername() + "','"
                    + user.getEmail() + "','"
                    + user.getPassword() + "','"
                    + date + "')";
            int num = stmt.executeUpdate(sql);
            // 处理结果
            if (num > 0) {
                // 若修改的行数>0，说明DB语句执行成功
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            // 关闭资源
            JBDCUtil.myClose(conn, stmt, null);
        }
        return false;
    }


//    // 删除数据库元素
//    public boolean delete(int id) {
//        Connection conn = null;
//        Statement stmt = null;
//        try {
//            // 获取连接对象
//            conn = JBDCUtil.myGetConnection();
//            // 获取通路对象
//            stmt = conn.createStatement();
//            // 执行sql语句
//            String sql = "delete from users where id =" + id;
//            int num = stmt.executeUpdate(sql);
//            // 处理结果
//            if (num > 0) {
//                return true;
//            } else {
//                return false;
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        } finally {
//            // 关闭资源
//            JBDCUtil.myClose(conn, stmt, null);
//        }
//        return false;
//    }


//    // 更改数据库元素
//    public boolean update(int id, RequestParamUser user) {
//        Connection conn = null;
//        Statement stmt = null;
//        // 获取当前的"yyyy-MM-dd HH:mm:ss"格式的Date数据
//        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
//        try {
//            // 获取连接对象
//            conn = JBDCUtil.myGetConnection();
//            // 获取通道对象
//            stmt = conn.createStatement();
//            // 执行sql语言
//            String sql = "update users set " +
//                    "username='" + user.getUsername() +
//                    "',email='" + user.getEmail() +
//                    "',password='" + user.getPassword() +
//                    "',lastlogintime='" + date +
//                    "' where id=" + id;
//            int num = stmt.executeUpdate(sql);
//            // 处理结果
//            if (num > 0) {
//                return true;
//            } else {
//                return false;
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        } finally {
//            // 关闭资源
//            JBDCUtil.myClose(conn, stmt, null);
//        }
//        return false;
//    }


//    // 查询指定id的元素
//    public User find(int id) {
//        Connection conn = null;
//        Statement stmt = null;
//        ResultSet rs = null;
//        try {
//            // 获取连接对象
//            conn = JBDCUtil.myGetConnection();
//            // 获取通道对象
//            stmt = conn.createStatement();
//            // 执行sql语言
//            String str = "select * from users where id =" + id;
//            stmt.execute(str);
//            // 处理结果集
//            rs = stmt.getResultSet();
//            rs.next();// rs执行要寻找的行（原本指向前一行）
//            User user = new User(rs.getInt("id"),
//                    rs.getString("username"),
//                    rs.getString("email"),
//                    rs.getString("password"),
//                    rs.getString("lastlogintime")
//            );
//            return user;
//        } catch (Exception e) {
//            System.out.println(e);
//        } finally {
//            // 关闭资源
//            JBDCUtil.myClose(conn, stmt, rs);
//        }
//        return null;
//    }


    // 获取包含全部元素的列表
    public ArrayList<User> getAll() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // 获取连接对象
            conn = JBDCUtil.myGetConnection();
            // 获取通道对象
            stmt = conn.createStatement();
            // 执行sql语言
            String str = "select * from users";
            stmt.execute(str);
            // 处理结果集
            rs = stmt.getResultSet();
            ArrayList<User> users = new ArrayList<>();// 定义列表，用于存储数据库的行信息
            while (rs.next()) {
                users.add(new User(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("lastlogintime")));
            }
            return users;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            // 关闭资源
            JBDCUtil.myClose(conn, stmt, rs);
        }
        return null;
    }
}
