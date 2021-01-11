package com.servlet;

import com.entity.PageBean;
import com.entity.User;
import com.service.impl.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/showAllPageServlet")
public class showAllPageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取查询的当前页
        String page0=request.getParameter("Page");
        Integer page=Integer.parseInt(page0);
        //2.定义每页要显示的条数
        int pagesum=5;

        //3.总条数
        int countnum=new UserServiceImp().selectUserCount();

        //4.总页数
        int countPage=countnum%pagesum==0?countnum/pagesum:(countnum/pagesum)+1;
        if(page>countPage){
            page=countPage;
        }
        //5.查询数据返回集合
        List<User> list=new UserServiceImp().selPageList(page,pagesum);

        //封装页面显示元素
        PageBean pa=new PageBean(page,pagesum,countnum,countPage,list);

        //转发showAllUser.jsp展示
        request.setAttribute("showAll", pa);
        request.getRequestDispatcher("showAllUsers.jsp").forward(request, response);



    }
}
