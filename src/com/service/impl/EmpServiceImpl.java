package com.service.impl;

import com.Bean.Employee;
import com.dao.EmployeeDao;
import com.dao.impl.EmployeeDaoImpl;
import com.service.EmpService;

import java.util.List;

public class EmpServiceImpl implements EmpService {
    EmployeeDao employeeDao = new EmployeeDaoImpl();
    @Override
    public Employee isLogin(String name, String pwd) {
        Employee employee = employeeDao.isLogin(name,pwd);
        if (employee!=null){
            return employee;
        }
        return null;
    }

    @Override
    public List<Employee> selectAll() {
        List<Employee> employees = employeeDao.findAllEmpInfo();
        if(employees !=null){
            return  employees;
        }
        return null;
    }

    @Override
    public int insertEmp(Employee employee) {
        if (employee!=null){
            int num = employeeDao.insertEmp(employee);
            return num;
        }
        return 0;
    }

    @Override
    public Employee updateEmployee(String empId) {
        Employee employee = employeeDao.updateSelect(empId);
        if(employee !=null){
            //调用Dao 返回结果
            return  employee;
        }
        return null;
    }

    @Override
    public int updateOneEmployee(Object... objs) {
        int i = employeeDao.updateEmployee(objs);
        if(i !=0){
            return  i;
        }
        return 0;
    }

    @Override
    public int deleteEmployee(String empId) {
        int i = employeeDao.deleteEmployee(empId);
        if(i !=0){
            return  i;
        }
        return 0;
    }

    @Override
    public List<Employee> selectEmployeeM(Object... obj) {
        if(obj.length>0){

            List<Employee> list = employeeDao.selectEmployeeM(obj);
            System.out.println(list.toString());
            return list;
        }
        return null;
    }
}


