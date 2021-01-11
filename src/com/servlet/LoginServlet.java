package com.servlet;

import com.entity.User;
import com.service.impl.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     //1.获取前端用户名、密码、验证码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String inputVcode = request.getParameter("inputVcode");
        User user=null;

        //从session域中获取生成的正确验证码
        String codes = (String) request.getSession().getAttribute("code");

        //判断用户输入的验证码是否和生成的验证码一致
        if (inputVcode != null && inputVcode.equalsIgnoreCase(codes)) {

            //进行后续的账户密码判断。。
           user= new UserServiceImp().loginService(username, password);
            if(user!=null){
                request.getSession().setAttribute("user", user);
                //登录成功->判断用户类型
                if(user.getType()==2){
                    //跳转到管理员用户界面
                    request.getSession().setAttribute("admin", user);
                    response.sendRedirect("loginIndex.jsp");
                }else if (user.getType()==1){
                    //跳转到普通用户界面
                    request.getSession().setAttribute("admin", user);
                    response.sendRedirect("#");
                }else {
                    request.setAttribute("msg", "登录失败,无法获取用户类型！");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            }else {
                //登录失败
                request.setAttribute("msg", "登录失败,用户名或密码错误！");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } else {
            //System.out.println("验证码不一致！");
            request.setAttribute("msg", "验证码不一致！");
            request.getRequestDispatcher("login.jsp").forward(request, response);

        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
