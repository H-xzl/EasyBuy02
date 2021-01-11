package com.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.UserService;
import com.service.impl.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/UserAjaxServlet")
public class UserAjaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收登录名loginname
        String registerName=req.getParameter("loginname");
        //调用service层判断是否已注册
        boolean T=new UserServiceImp().selectRegistName(registerName);
        //将信息放在容器Map中
        Map<String,Object> map=new HashMap<>();
        if(T){
            //已注册
            map.put("msg", "用户已存在,不可用!");
            map.put("flag", true);
        }else {
            //未注册
            map.put("msg", "用户不存在,可用!");
            map.put("flag", false);
        }
        //将信息转化为json类型返回给前端
        ObjectMapper om=new ObjectMapper();
        om.writeValue(resp.getWriter(),map);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
