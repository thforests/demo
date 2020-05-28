package com.servlet;

import com.Bean.Employee;
import com.service.EmpService;
import com.service.impl.EmpServiceImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmpService empService=new EmpServiceImpl();

        req.setCharacterEncoding("UTF-8");

        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        JSONObject json=new JSONObject();
        Employee emp = empService.isLogin(userId, password);
        if(emp !=null){
            HttpSession session = req.getSession();
            session.setAttribute("login",emp.getEmpName());
            json.put("flag",true);
            out.println(json);

            out.flush();
            out.close();
        }else {
            json.put("flag",false);
            out.println(json);

            out.flush();
            out.close();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
