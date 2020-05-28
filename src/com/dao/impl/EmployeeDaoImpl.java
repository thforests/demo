package com.dao.impl;

import com.Bean.Employee;
import com.dao.EmployeeDao;
import com.util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public Employee isLogin(String name, String pwd) {
        Employee employee = null;
        Connection connection = DBUtils.getConnection();
        String sql = "select * from employee where username=? and password =? ";
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            pstm = connection.prepareStatement(sql);
            pstm.setObject(1,name);
            pstm.setObject(2,pwd);

            rs = pstm.executeQuery();
            if (rs!=null){
                if (rs.next()){
                    employee = new Employee();
                    String userName = rs.getString(3);
                    String empName = rs.getString("emp_name");
                    employee.setUsername(userName);
                    employee.setEmpName(empName);
                    System.out.println(employee);
                    return employee;

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(rs,pstm,connection);
        }
        return null;

    }

    @Override
    public List<Employee> findAllEmpInfo() {

        ResultSet resultSet =null;
        PreparedStatement statement =null;
        List<Employee> emps=new ArrayList<>();
        Employee emp=null;
        Connection conn = DBUtils.getConnection();
        String sql="select * from employee";
        try {
            statement = conn.prepareStatement(sql);
            resultSet = statement.executeQuery();
            if(resultSet !=null){
                while (resultSet.next()){
                    emp=new Employee();
                    String empId = resultSet.getString(2);
                    String userName = resultSet.getString(3);
                    String password = resultSet.getString(4);
                    String empName = resultSet.getString("emp_name");
                    String empSex = resultSet.getString(6);
                    int empAge = resultSet.getInt(7);
                    String phone = resultSet.getString(11);
                    emp.setEmpId(empId);
                    emp.setUsername(userName);
                    emp.setPassword(password);
                    emp.setEmpName(empName);
                    emp.setEmpSex(empSex);
                    emp.setEmpAge(empAge);
                    emp.setPhone(phone);
                    System.out.println(emp);
                    emps.add(emp);
                }
                return emps;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(resultSet,statement,conn);
        }
        return null;
    }

    @Override
    public int insertEmp(Employee employee) {
        int num = 0;
        Connection conn = null;
        PreparedStatement pstm = null;
        conn = DBUtils.getConnection();
        String sql = "insert into employee(emp_id,username,password,emp_name,  " +
                "emp_sex,emp_age,levell,phone)   " +
                "values (?,?,?,?,?,?,?,?)";
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setObject(1,employee.getEmpId());
            pstm.setObject(2,employee.getUsername());
            pstm.setObject(3,employee.getPassword());
            pstm.setObject(4,employee.getEmpName());
            pstm.setObject(5,employee.getEmpSex());
            pstm.setObject(6,employee.getEmpAge());
            pstm.setObject(7,employee.getLevel());
            pstm.setObject(8,employee.getPhone());

            num = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(null,pstm,conn);
        }


        return num;
    }

    @Override
    public Employee updateSelect(String empId) {
        ResultSet resultSet =null;
        PreparedStatement statement =null;
        //1.声明实体对象
        Employee emp=null;
        //2.开始连接数据库
        Connection conn = DBUtils.getConnection();
        //3.通过连接数据库对象，返回执行SQL语句对象
        String sql="select * from employee where emp_id=?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setObject(1,empId);
            //4.查询结果
            resultSet = statement.executeQuery();
            if(resultSet !=null){
                if (resultSet.next()){
                    //4.1 创建对象
                    emp=new Employee();
                    //4.2 查询结果返回对象
                    String emp_Id = resultSet.getString(2);
                    String userName = resultSet.getString(3);
                    String password = resultSet.getString(4);
                    String empName = resultSet.getString("emp_name");
                    String empSex = resultSet.getString(6);
                    int empAge = resultSet.getInt(7);
                    Date date = resultSet.getDate(8);
                    String depId = resultSet.getString(9);
                    int level =Integer.parseInt(resultSet.getString(10));
                    String phone = resultSet.getString(11);
                    emp.setEmpId(emp_Id);
                    emp.setUsername(userName);
                    emp.setPassword(password);
                    emp.setEmpName(empName);
                    emp.setEmpSex(empSex);
                    emp.setEmpAge(empAge);
                    emp.setLevel(level);
                    emp.setPhone(phone);
                }
                return emp;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(resultSet,statement,conn);
        }

        return null;
    }

    @Override
    public int updateEmployee(Object... emps) {
        int num =0;
        PreparedStatement statement =null;
        Connection conn = DBUtils.getConnection();
        String sql="update employee set username=?,password=?,emp_name=?,emp_sex=?,emp_age=?,levell=?,phone=? WHERE emp_id=?";
        try {
            statement = conn.prepareStatement(sql);
            for(int i=0;i<emps.length;i++){
                statement.setObject((i+1),emps[i]);
            }
            num = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(null,statement,conn);
        }
        return num;
    }


    @Override
    public int deleteEmployee(String empId) {
        int num =0;
        Connection conn = null;
        PreparedStatement pstm = null;
        conn = DBUtils.getConnection();

        String sql="delete from employee where emp_id=?";

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setObject(1,empId);
            num= pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(null,pstm,conn);
        }
        return num;
    }

    @Override
    public List<Employee> selectEmployeeM(Object... obj) {

        ResultSet resultSet =null;
        PreparedStatement statement =null;
        List<Employee> emps=new ArrayList<>();
        Employee emp=null;
        Connection conn = DBUtils.getConnection();
        String sql="select * from tb_employee where emp_id like ?";
        try {
            statement = conn.prepareStatement(sql);
            for(int i=0;i<obj.length;i++){
                statement.setObject(i+1,"%"+obj[i]+"%");
            }
            resultSet = statement.executeQuery();
            if(resultSet !=null){
                while (resultSet.next()){
                    emp=new Employee();

                    String empId = resultSet.getString(2);
                    String userName = resultSet.getString(3);
                    String password = resultSet.getString(4);
                    String empName = resultSet.getString("emp_name");
                    String empSex = resultSet.getString(6);
                    int empAge = resultSet.getInt(7);
                    String phone = resultSet.getString(11);
                    emp.setEmpId(empId);
                    emp.setUsername(userName);
                    emp.setPassword(password);
                    emp.setEmpName(empName);
                    emp.setEmpSex(empSex);
                    emp.setEmpAge(empAge);
                    emp.setPhone(phone);

                    emps.add(emp);
                }
                return emps;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(resultSet,statement,conn);
        }


        return null;
    }
}
