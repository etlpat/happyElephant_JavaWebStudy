package com.etlpat.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_article")
public class Article {
    Integer id;
    String title;
    String content;
    @TableField(exist=false)
    List<Comment> commentList;
}
