package com.etlpat.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data// lombok注解，用于在编译阶段自动生成getter、setter、toString等方法
@NoArgsConstructor// 添加无参构造器
@AllArgsConstructor// 添加全参构造器
public class Category {// 分类表
    private Integer id;// ID
    private String categoryName;// 分类名称
    private String categoryAlias;// 分类别名
    private Integer createUser;// 创建人ID
    private LocalDateTime createTime;// 创建时间
    private LocalDateTime updateTime;// 修改时间
}
