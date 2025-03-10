package com.etlpat.controller;

import com.etlpat.pojo.Employee;
import com.etlpat.service.EmpService;
import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@CrossOrigin// 允许跨域访问（允许非同源资源，访问本服务器资源）
@Controller
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    EmpService empService;

    @Autowired
    ServletContext servletContext;

    String state = "";


    // 示员工表
    @RequestMapping("/empTable")
    public String empTable() {
        List<Employee> employees = empService.selectAllEmp();
        servletContext.setAttribute("employees", employees);
        return "empTable";
    }

    @RequestMapping("/insert")
    public String insert() {
        state = "insert";
        return gotoGetEmp();
    }

    @RequestMapping("/update")
    public String update(int id) {
        state = "update";
        servletContext.setAttribute("updateId", id);
        return gotoGetEmp();
    }

    @RequestMapping("/delete")
    public String delete(int id) {
        empService.deleteEmp(id);
        return empTable();
    }

    // 跳转到getEmp.jsp界面
    @RequestMapping("/gotoGetEmp")
    public String gotoGetEmp() {
        return "getEmp";
    }

    // 获取员工信息
    @RequestMapping("/getEmp")
    public String getEmp(Employee employee) {
        if (state.equals("insert")) {
            empService.insertEmp(employee);
        } else if (state.equals("update")) {
            employee.setEmpId((int) servletContext.getAttribute("updateId"));
            empService.updateEmp(employee);
        }
        state = "";
        return empTable();
    }
}