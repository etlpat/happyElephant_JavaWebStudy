package com.etlpat.mapper;

import com.etlpat.pojo.Employee;


// Mapper接口，用于声明操纵数据库的方法
public interface EmployeeMapper {
    public Employee queryByID(int id);
}
