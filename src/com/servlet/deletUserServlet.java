package com.servlet;

import com.service.impl.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deletUserServlet")
public class deletUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 接收前端的删除id和当前页
        String ids = request.getParameter("id");
        Integer id = Integer.parseInt(ids);
        String pages = request.getParameter("page");
        Integer page = Integer.parseInt(pages);

        //删除操作
        boolean b=new UserServiceImp().delUser(id.intValue());
        if(b){
            //删除成功
            request.setAttribute("msg","删除成功！");
            request.getRequestDispatcher("showAllPageServlet?Page="+page.intValue()).forward(request, response);
        }else {
            //删除失败
            request.setAttribute("msg","删除失败！");
            request.getRequestDispatcher("showAllPageServlet?Page="+page.intValue()).forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
