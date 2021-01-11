package com.servlet;

import com.entity.AllPageBean;
import com.entity.Shop;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.impl.ShopServiceImp;
import com.util.OnloadUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/shopServlet")
public class shopServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取前端选择的方法
        String action=request.getParameter("action");
        //System.out.println(action);

        //添加商品
        if(action.equals("add")){

            //以键值对的形式接收信息
            Map<String, String> map= OnloadUtil.getMap(request);
//            System.out.println(map.get("shopname"));
            //获取商品类
            Shop shop=OnloadUtil.getShop(map);

            //调用service层存储到数据库中
            if (new ShopServiceImp().saveShop(shop)){
                //保存成功
//                System.out.println("successful");
                request.setAttribute("msg", "保存成功！");
                request.getRequestDispatcher("addshop.jsp").forward(request,response );
            }else {
                //保存失败
//                System.out.println("failed");
                request.setAttribute("msg", "保存失败！");
                request.getRequestDispatcher("addshop.jsp").forward(request,response );
            }
        }

        //查询商品
        if ("select".equals(action)){
            //获取当前页
            String Pages=request.getParameter("Page");
            //调用service层<分页查询>
            //1.当前页
            int page=Integer.parseInt(Pages);
            //2.每页显示商品的条数
            int PageShopCount=5;
            //3.总条数
            //调用service层获取
            int AllShopNum=new ShopServiceImp().allShopsNum();
            //4.总页数
            int pagesNum=AllShopNum%PageShopCount==0?
                    AllShopNum/PageShopCount:(AllShopNum/PageShopCount)+1;
            if(page>pagesNum){
                page=pagesNum;
            }
            //5.每页显示的数据集合
            //service
            List<Shop> list= new ShopServiceImp().selPageshopInfo(page, PageShopCount);

            //封装数据
            AllPageBean allPageBean=new AllPageBean(page,
                    PageShopCount,AllShopNum,pagesNum,list);

            //将结果集合返回到前端shopshowAll.jsp
            request.setAttribute("pageBean", allPageBean);
            request.getRequestDispatcher("shopshowAll.jsp").forward(request, response);
        }

        //ajax删除商品
        if ("delete".equals(action)){
            String idS=request.getParameter("id");
            //强转
            int id=Integer.parseInt(idS);
            //int page=Integer.parseInt(pageS);

            //调用service层删除信息

            //将信息放在容器Map中
            Map<String,Object> map=new HashMap<>();
            if(new ShopServiceImp().delShopInfo(id)){
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

        //修改商品信息中的->查询商品
        if("update".equals(action)){
            String idS=request.getParameter("id");
            String pageS=request.getParameter("Page");
            //强转
            int id=Integer.parseInt(idS);
            int page=Integer.parseInt(pageS);

            //查询商品信息提交到修改界面shopUpdate.jsp+page信息
            Shop shop=new ShopServiceImp().selShopInfo(id);

            request.setAttribute("shop", shop);
            request.setAttribute("page", page);
            request.getRequestDispatcher("shopUpdate.jsp").forward(request, response);
        }

        //修改商品信息->修改数据库
        if("upd".equals(action)){
            //获取修改时的page所在页面
            String pageS=request.getParameter("Page");
            //强转
            Integer page=Integer.parseInt(pageS);

            //以键值对的形式接收信息
            Map<String, String> map= OnloadUtil.getMap(request);
            //获取商品类
            Shop shop=OnloadUtil.updShop(map);
            //调用service层修改
            if(new ShopServiceImp().updShopIngfo(shop)){
                //修改成功
                request.getSession().setAttribute("msg", "修改成功！");
                request.getRequestDispatcher("shopServlet?action=select&page="+page).forward(request, response);
            }else {
                //修改失败
                //修改成功
                request.getSession().setAttribute("msg", "修改失败！");
                request.getRequestDispatcher("shopServlet?action=select&page="+page).forward(request, response);
            }


        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
