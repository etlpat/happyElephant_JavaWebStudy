package com.etlpat.mapper;

import com.etlpat.pojo.Employee;

import java.util.List;

public interface EmpMapper {
    int insert(Employee employee);

    int delete(int id);

    int update(Employee employee);

    Employee selectById(int id);

    List<Employee> selectAll();
}
