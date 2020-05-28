package com.servlet;


import com.Bean.Department;
import com.Bean.Employee;
import com.service.EmpService;
import com.service.impl.EmpServiceImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;


@WebServlet("/view/employee/employeeServlet")
public class EmployeeServlet extends HttpServlet {
    EmpService empService=new EmpServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        if ("select".equals(method)) {
            List<Employee> list = empService.selectAll();
            resp.setCharacterEncoding("UTF-8");
            PrintWriter out = resp.getWriter();
            if (list != null) {
                JSONArray jsonArray = JSONArray.fromObject(list);
                out.println(jsonArray);
                out.flush();
                out.close();
            } else {
                JSONArray jsonArray = new JSONArray();
                out.println(jsonArray);
                out.flush();
                out.close();
            }
        }
        if ("add".equals(method)) {
            String empId = req.getParameter("empId");
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String empName = req.getParameter("empName");
            String empSex = req.getParameter("empSex");
            int empAge = Integer.parseInt(req.getParameter("empAge"));
            String empPhone = req.getParameter("empPhone");
            int empLevel = Integer.parseInt(req.getParameter("empLevel"));

            Employee employee = new Employee();
            employee.setEmpId(empId);
            employee.setUsername(username);
            employee.setPassword(password);
            employee.setEmpName(empName);
            employee.setEmpSex(empSex);
            employee.setEmpAge(empAge);
            employee.setLevel(empLevel);
            employee.setPhone(empPhone);

            System.out.println(employee);

            int num = empService.insertEmp(employee);
            if (num != 0) {
                resp.sendRedirect("employeeQuery.jsp");
            } else {
                resp.sendRedirect("employeeAdd.jsp");
            }

        }
        if ("update".equals(method)) {
            req.setCharacterEncoding("UTF-8");
            String empId = req.getParameter("empId");

            Employee employee = empService.updateEmployee(empId);
            if (employee != null) {
                // 查询功能，如果查询成功，则将数带到"employeeUpdate.jsp"页面上
                req.setAttribute("employee", employee);
                req.getRequestDispatcher("employeeUpdate.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("employeeUpdate.jsp").forward(req, resp);
            }


        }

        if ("updateEmp".equals(method)) {
            String empName = req.getParameter("empName");
            int empAge = Integer.parseInt(req.getParameter("empAge"));
            String empNum = req.getParameter("empNum");
            String empPhone = req.getParameter("empPhone");
            String empSex = req.getParameter("empSex");
            int empLevel = Integer.parseInt(req.getParameter("empLevel"));
            String name = req.getParameter("name");
            String pwd = req.getParameter("pwd");

            int i = empService.updateOneEmployee(name, pwd, empName, empSex, empAge,empLevel,empPhone, empNum);
            resp.setCharacterEncoding("UTF-8");
            PrintWriter out = resp.getWriter();
            JSONObject jsonObject = new JSONObject();
            if (i == 1) {
                jsonObject.put("msg", true);
                out.println(jsonObject);
                out.close();
            } else {
                jsonObject.put("msg", false);
                out.println(jsonObject);
                out.close();
            }


        }
        if("delete".equals(method)){
            String empId = req.getParameter("empId");
            System.out.println("===="+empId);
            int i = empService.deleteEmployee(empId);
            if(i == 1){
                resp.setCharacterEncoding("UTF-8");
                PrintWriter out = resp.getWriter();
                out.println("<script>window.alert('删除成功')</script>");
                out.println("<script>window.location.href='employeeQuery.jsp'</script>");
                out.close();
            }
        }

        if("selectM".equals(method)){
            String emp_id = req.getParameter("emp_id");
            System.out.println("emp_id="+emp_id);

            resp.setCharacterEncoding("UTF-8");
            PrintWriter out = resp.getWriter();

            List<Employee> list = empService.selectEmployeeM(emp_id);
            JSONArray jsonArray = JSONArray.fromObject(list);
            if(list !=null){
                out.println(jsonArray);
                out.flush();
                out.close();
            }else {
                out.println(jsonArray);
                out.flush();
                out.close();
            }


        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
