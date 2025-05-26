package com.etlpat.pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity// 表示该类为实体类
@Table(name = "students")// 将Students类与数据库的table对应
public class Students {

    @Id// 声明主键
    @Column(name = "id")// 将属性与表的字段映射（若一致则可省略）
    @GeneratedValue(strategy = GenerationType.IDENTITY)// 定义主键策略--自增长
    private Integer id;

    @Column(name = "name")// 将属性与表的字段映射（若一致则可省略）
    private String name;

    private Integer age;

    private String gender;

    private String number;

    private String address;

    private Integer status;
}
