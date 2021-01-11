package com.servlet;

import com.entity.User;
import com.service.impl.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateUserServlet")
public class updateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 接收前端用户信息
        String id1 = request.getParameter("id");
        String loginname=request.getParameter("loginname");
        String password=request.getParameter("password");
        String username=request.getParameter("username");
        String page1=request.getParameter("page");
        // 强转信息
        int id=Integer.parseInt(id1);
        int page=Integer.parseInt(page1);

        //封装信息,只修改loginname, username, password,
        User user=new User(id, loginname, username, password, "sex", 0);
        //调用service层修改信息

        if(new UserServiceImp().updUserById(user)){
            //修改成功,返回相应的页面
            request.setAttribute("mag", "修改成功！");
            request.getRequestDispatcher("showAllPageServlet?Page="+page).forward(request, response);
        }else {
            //修改失败
            request.setAttribute("mag", "修改失败！");
            request.getRequestDispatcher("showAllPageServlet?Page="+page)
                    .forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }
}
