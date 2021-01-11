package com.servlet;

import com.entity.User;
import com.service.impl.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateUserServletTrans")
public class updateUserServletTrans extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 接收前端的修改id和当前页
        String ids = request.getParameter("id");
        Integer id = Integer.parseInt(ids);
        String pages = request.getParameter("page");
        Integer page = Integer.parseInt(pages);
        //利用id查询信息用户的信息
        User user=new UserServiceImp().selectById(id);
        //转发页面到userUpdate.jsp
        request.setAttribute("page", page);
        request.setAttribute("User", user);
        request.getRequestDispatcher("userUpdate.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }
}
