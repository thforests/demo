package com.test;

import com.Bean.Employee;
import com.dao.EmployeeDao;
import com.dao.impl.EmployeeDaoImpl;

import org.junit.Test;

public class TestDemo {
    EmployeeDao employeeDao=new EmployeeDaoImpl();

    @Test
    public  void test1(){
        Employee emp = employeeDao.isLogin("admin", "123456");
        System.out.println(emp);
    }
}
