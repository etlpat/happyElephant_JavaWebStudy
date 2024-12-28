package com.etlpat.mapper;

// Mapper接口，用于声明操纵数据库的方法
public interface EmployeeMapper {

    // DML语句，返回int，表示影响行数。
    int deleteById(int id);

    // ①返回单个简单类型
    String queryNameById(int id);
}
