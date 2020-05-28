package com.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {
    private Integer id;
    private String empId;
    private String username;
    private String password;
    private String empName;
    private String empSex;
    private Integer empAge;
    private Date birthday;
    private Department dp_Id;
    private Integer level;
    private String phone;

    public Employee() {

    }
    public Employee( String empId, String userName, String password, String empName, String empSex, int empAge, Date brithday,String phone, int level) {
        this.empId = empId;
        this.username = userName;
        this.password = password;
        this.empName = empName;
        this.empSex = empSex;
        this.empAge = empAge;
        this.birthday = brithday;
        this.level = level;
        this.phone = phone;
    }


    public Employee(Integer id, String empId, String username, String password, String empName, String empSex, Integer empAge, Date birthday, Department dp_Id, Integer level, String phone) {
        this.id = id;
        this.empId = empId;
        this.username = username;
        this.password = password;
        this.empName = empName;
        this.empSex = empSex;
        this.empAge = empAge;
        this.birthday = birthday;
        this.dp_Id = dp_Id;
        this.level = level;
        this.phone = phone;
    }

    @Override
    public String toString() {
        SimpleDateFormat  simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String format =null;
        if(birthday !=null){
            format = simpleDateFormat.format(birthday);
        }else {
            format = simpleDateFormat.format(new Date());
        }

        return "Employee{" +
                "id=" + id +
                ", empId='" + empId + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", empName='" + empName + '\'' +
                ", empSex='" + empSex + '\'' +
                ", empAge=" + empAge +
                ", birthday=" + birthday +
                ", dp_Id=" + dp_Id +
                ", level=" + level +
                ", phone=" + phone +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpSex() {
        return empSex;
    }

    public void setEmpSex(String empSex) {
        this.empSex = empSex;
    }

    public Integer getEmpAge() {
        return empAge;
    }

    public void setEmpAge(Integer empAge) {
        this.empAge = empAge;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Department getDp_Id() {
        return dp_Id;
    }

    public void setDp_Id(Department dp_Id) {
        this.dp_Id = dp_Id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}