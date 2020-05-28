package com.service;

import com.Bean.Employee;

import java.util.List;

public interface EmpService {
    public Employee isLogin(String name,String pwd);

    public List<Employee> selectAll();

    public int insertEmp(Employee employee);

    //更新数据前查询数据
    public Employee updateEmployee(String empId);

    //更新后的数据
    public int updateOneEmployee(Object... objs);

    public int deleteEmployee(String empId);

    public List<Employee> selectEmployeeM(Object... obj);
}
