package com.etlpat.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;


// myBatis-plus核心注解
//  注意：①若该实体类的类名、属性名 与对应table的表名、字段名完全相同，则不需要添加以下注解！
//       ②myBatis-plus默认自动开启下划线到驼峰式的自动映射！
//


//（1）@TableName注解
// 语法：@TableName("表名")
// 功能：用于映射实体类对应的表名
// 注意：①若不添加该注解，则表名默认为类名
//      ②表名/字段名不区分大小写
@TableName("user")
public class User {

    //（2）@TableId注解
    // 语法：@TableId(value="主键列名",type=主键策略)
    // 功能：用于映射主键，并设置主键策略
    // 主键策略：①AUTO -> 主键自增长（AUTO_INCREMENT）
    //         ②ASSIGN_ID（默认） -> 使用雪花算法分配ID
    // 注意：①若不添加该注解，则主键默认为与表中主键字段名相同的属性
    //      ②雪花算法详情，见文档"myBatis-plus的核心注解.txt"
    //      ③可以在application.yml中，配置全局的主键策略
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    //（3）@TableField注解
    // 语法：@TableField("普通字段名")
    // 功能：用于映射普通字段
    // 注意：若不添加该注解，则该属性默认为表中名称相同的字段
    @TableField("username")
    private String username;

    @TableField("password")
    private String password;


    public User() {
    }

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
