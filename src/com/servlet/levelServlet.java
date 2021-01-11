package com.servlet;

import com.entity.Level;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.impl.LevelServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/levelServlet")
public class levelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理商品类型
        String action=request.getParameter("action");

        //添加商品类型
        if("insert".equals(action)){
            String shopLevel=request.getParameter("shopLevel");
            System.out.println(shopLevel);
            Level level=new Level(null,shopLevel);
            if (new LevelServiceImp().insLevelInfo(level)){
                //添加成功
                request.setAttribute("msg", "添加成功！");
                request.getRequestDispatcher("addLevel.jsp").forward(request, response);
            }else {
                //添加失败
                request.setAttribute("msg", "添加失败！");
                request.getRequestDispatcher("addLevel.jsp").forward(request, response);
            }
        }

        //查询商品类型
        if ("select".equals(action)){
            //查询找所有类型
            List<Level> list=new LevelServiceImp().selLevelInfo();
            //封装数据传递到前端
            String msg=request.getParameter("msg");
            request.setAttribute("msg",msg);
            request.setAttribute("showAll",list);
            request.getRequestDispatcher("showLevel.jsp").forward(request, response);
        }

        //ajax删除商品类型
        if("delete".equals(action)){
            String ids=request.getParameter("id");
            int id=Integer.parseInt(ids);
            //删除byId
            //将信息放在容器Map中
            Map<String,Object> map=new HashMap<>();
            if(new LevelServiceImp().delLevelInfo(id)){
                //已删除
                map.put("msg", "信息已删除!");
                map.put("flag", true);
            }else {
                map.put("msg", "信息删除失败!");
                map.put("flag", false);
            }
            //将信息转化为json类型
            ObjectMapper om=new ObjectMapper();
            om.writeValue(response.getWriter(), map);

        }

        //修改商品类型
        if("update".equals(action)){
            String ids=request.getParameter("id");
            int id=Integer.parseInt(ids);
            String updlevelname=request.getParameter("levelName");
            //封装数据
            Level level=new Level(id,updlevelname);
            //System.out.println(level.getId()+"+"+level.getShoplevelname());

            String msg=null;
            //修改
            if(new LevelServiceImp().updLevelInfo(level)){
                //修改成功
                msg="修改成功!";
                request.getRequestDispatcher("levelServlet?action=select&msg="+msg).forward(request, response);
            }else {
                //修改失败
                msg="修改失败!";
                request.getRequestDispatcher("levelServlet?action=select&msg="+msg).forward(request, response);

            }


        }




    }
}
