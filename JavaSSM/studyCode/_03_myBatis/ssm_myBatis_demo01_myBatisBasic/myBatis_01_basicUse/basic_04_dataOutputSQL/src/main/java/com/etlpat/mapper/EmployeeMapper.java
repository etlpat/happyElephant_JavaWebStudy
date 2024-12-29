package com.etlpat.mapper;

import com.etlpat.pojo.Employee;

import java.util.List;
import java.util.Map;

// Mapper接口，用于声明操纵数据库的方法
public interface EmployeeMapper {

    // DML语句，返回int，表示影响行数。
    int deleteById(int id);

    // ①返回单个简单类型
    String queryNameById(int id);

    // ②返回单个实体类型
    Employee queryById(int id);

    // ③返回Map类型
    Map queryMapById(int id);

    // ④返回List集合
    List<Employee> queryAll();

    // 自增长主键的回显
    int insertEmployee(Employee employee);
}
