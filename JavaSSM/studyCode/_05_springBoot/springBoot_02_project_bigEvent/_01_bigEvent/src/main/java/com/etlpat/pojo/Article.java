package com.etlpat.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data// lombok注解，用于在编译阶段自动生成getter、setter、toString等方法
@NoArgsConstructor// 添加无参构造器
@AllArgsConstructor// 添加全参构造器
public class Article {
    private Integer id;// ID
    private String title;// 文章标题
    private String content;// 文章内容
    private String coverImg;// 文章封面
    private String state;// 文章状态:只能是[已发布]或者[草稿]
    private Integer categoryId;// 文章分类ID
    private Integer createUser;// 创建人ID
    private LocalDateTime createTime;// 创建时间
    private LocalDateTime updateTime;// 修改时间
}
