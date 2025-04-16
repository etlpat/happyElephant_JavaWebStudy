package com.etlpat.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


// PageBean：用于存储分页查询的文章列表
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean<T> {
    private Long total;// 总条数
    private List<T> items;// 本页数据列表
}
