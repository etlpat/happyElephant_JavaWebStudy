package com.etlpat.mapper;

import com.etlpat.pojo.Employee;


// Mapper接口，用于定义操作数据库的方法

public interface EmployeeMapper {

    // 根据id查询员工信息
    public Employee queryById(Integer id);

    // 根据id删除员工信息
    public int deleteById(Integer id);
}
