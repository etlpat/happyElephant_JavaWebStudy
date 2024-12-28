package com.etlpat.mapper;

import com.etlpat.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


// Mapper接口，用于声明操纵数据库的方法
public interface EmployeeMapper {

    Employee queryByID(int id);

    // ①参数为单个简单类型
    List<Employee> queryBySalary(double salary);

    // ②参数为单个实体对象
    int insertEmployee(Employee employee);

    // ③参数为多个简单类型
    List<Employee> queryByNameAndSalary(@Param("pName") String name, @Param("pSalary") double salary);

    // ④参数为单个Map类型（map(name=员工名, salary=薪水)）
    int insertMapEmp(Map mapEmp);
}
