package com.jdbc;

import com.javaBean.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class DAO {

    // 方法：向数据库中增加一行数据
    public boolean insert(Student student) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // 获取连接对象
            conn = JdbcUtil.myGetConnection();
            // 获取通道对象
            stmt = conn.createStatement();
            // 执行sql代码
            String sql = "insert into students values("
                    + student.getId() + ",'"
                    + student.getName() + "','"
                    + student.getSex() + "',"
                    + student.getAge() + ",'"
                    + student.getEmail() + "');";
            int num = stmt.executeUpdate(sql);// executeUpdate返回增、删、改的行数

            // try中调用return前，自动指向finally中代码
            if (num > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            // 关闭资源
            JdbcUtil.myClose(conn, stmt, null);
        }
        return false;
    }


    // 方法：删除数据库中的一行元素
    public boolean delete(int id) {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = JdbcUtil.myGetConnection();
            stmt = conn.createStatement();
            String sql = "delete from students where id =" + id;
            int num = stmt.executeUpdate(sql);
            if (num > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            JdbcUtil.myClose(conn, stmt, null);
        }
        return false;
    }


    // 查找指定id对应的元素
    public Student find(int id) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtil.myGetConnection();
            stmt = conn.createStatement();
            String sql = "select * from students where id =" + id;
            stmt.execute(sql);
            rs = stmt.getResultSet();

            // ResultSet对象始终指向结果的前一行数据，这里用next()方法使rs指向找到的数据
            rs.next();
            Student student = new Student(rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("sex"),
                    rs.getInt("age"),
                    rs.getString("email"));

            // try中调用return前，自动指向finally中代码
            return student;

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            JdbcUtil.myClose(conn, stmt, rs);
        }
        return null;
    }


    // 输出全部元素
    public void printAll() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtil.myGetConnection();
            stmt = conn.createStatement();
            String sql = "select * from students;";
            stmt.execute(sql);
            rs = stmt.getResultSet();
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" +
                        rs.getString("name") + "\t" +
                        rs.getString("sex") + "\t" +
                        rs.getInt("age") + "\t" +
                        rs.getString("email"));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            JdbcUtil.myClose(conn, stmt, rs);
        }
    }


    // 修改对应id号的学生信息
    public boolean update(Student student) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = JdbcUtil.myGetConnection();
            stmt = conn.createStatement();
            String sql = "update students set name='" + student.getName()
                    + "',sex='" + student.getSex()
                    + "',age=" + student.getAge()
                    + ",email='" + student.getEmail()
                    + "' where id =" + student.getId();
            int num = stmt.executeUpdate(sql);
            if (num > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            JdbcUtil.myClose(conn, stmt, null);
        }
        return false;
    }
}
