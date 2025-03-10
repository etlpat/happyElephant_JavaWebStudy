package com.etlpat.service;

import com.etlpat.mapper.EmpMapper;
import com.etlpat.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {
    @Autowired
    EmpMapper empMapper;

    public int insertEmp(Employee employee) {
        return empMapper.insert(employee);
    }

    public int deleteEmp(int id) {
        return empMapper.delete(id);
    }

    public int updateEmp(Employee employee) {
        return empMapper.update(employee);
    }

    public Employee selectEmpById(int id) {
        return empMapper.selectById(id);
    }

    public List<Employee> selectAllEmp() {
        return empMapper.selectAll();
    }

}
