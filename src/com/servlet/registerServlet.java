package com.servlet;

import com.entity.User;
import com.service.UserService;
import com.service.impl.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( "/registerServlet")
public class registerServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取信息
        String loginname=request.getParameter("loginname");
        String password=request.getParameter("password");
        String username=request.getParameter("username");
        String sex=request.getParameter("sex");
        //封装信息
        User user=new User(null,loginname,username,password,sex,1);
        //判断是否注册成功
        if(new UserServiceImp().addUser(user)){
            //注册成功，返回登录页面
            response.sendRedirect("login.jsp");
        }else {
            //注册失败，返回注册页面
            request.setAttribute("zh", "注册失败！");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }


    }
}
