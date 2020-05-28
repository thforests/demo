package com.dao;

import com.Bean.Employee;

import java.util.List;

public interface EmployeeDao {
    public Employee isLogin(String name,String pwd);

    public List<Employee> findAllEmpInfo();

    public int insertEmp(Employee employee);

    public Employee updateSelect(String empId);

    public  int updateEmployee(Object... emps);

    public int deleteEmployee(String empId);

    public List<Employee> selectEmployeeM(Object... obj);
}
