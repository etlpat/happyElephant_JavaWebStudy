package com.etlpat.pojo;
// pojo包，即(Plain Old Java Object)普通java对象包。
// pojo包等价于javaBean包，用于存放实体类对象。


// Employee员工类，对应数据库中的t_emp表
//
//  CREATE TABLE `t_emp`(
//      emp_id INT AUTO_INCREMENT,
//      emp_name VARCHAR(100),
//      emp_salary DOUBLE(10,5),
//      PRIMARY KEY(emp_id)
//  );
//
public class Employee {
    private Integer empId;
    private String empName;
    private Double empSalary;

    public Employee(Integer empId, String empName, Double empSalary) {
        this.empId = empId;
        this.empName = empName;
        this.empSalary = empSalary;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empSalary=" + empSalary +
                '}';
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(Double empSalary) {
        this.empSalary = empSalary;
    }
}
