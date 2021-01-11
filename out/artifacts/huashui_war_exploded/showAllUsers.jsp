<%--
  Created by IntelliJ IDEA.
  User: 26728
  Date: 2020/11/2
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link type="text/css" rel="stylesheet" href="css/style.css"/>
    <!--[if IE 6]>
    <script src="js/iepng.js" type="text/javascript"></script>
    <script type="text/javascript">
        EvPNG.fix('div, ul, img, li, input, a');
    </script>
    <![endif]-->
    <script type="text/javascript" src="js/jquery-1.11.1.min_044d0927.js"></script>
    <script type="text/javascript" src="js/jquery.bxslider_e88acd1b.js"></script>

    <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="js/menu.js"></script>

    <script type="text/javascript" src="js/select.js"></script>

    <script type="text/javascript" src="js/lrscroll.js"></script>

    <script type="text/javascript" src="js/iban.js"></script>
    <script type="text/javascript" src="js/fban.js"></script>
    <script type="text/javascript" src="js/f_ban.js"></script>
    <script type="text/javascript" src="js/mban.js"></script>
    <script type="text/javascript" src="js/bban.js"></script>
    <script type="text/javascript" src="js/hban.js"></script>
    <script type="text/javascript" src="js/tban.js"></script>

    <script type="text/javascript" src="js/lrscroll_1.js"></script>
    <script type="text/javascript">
        function del(id,Page) {
            var b=confirm("是否删除?");
            if(b){
                location.href="deletUserServlet?id="+id+"&page="+Page;
            }
        }
        function upd(id,Page) {
                location.href="updateUserServletTrans?id="+id+"&page="+Page;
        }
    </script>


    <title>尤洪</title>
</head>
<body>
<!--Begin Header Begin-->

<div class="m_top_bg">
    <div class="top">
        <div class="m_logo"><a href="Index.html"><img src="images/logo.png" /></a></div>


    </div>
</div>
<!--End Header End-->
<div class="i_bg bg_color">
    <!--Begin 用户中心 Begin -->
    <div class="m_content">
        <div class="m_left">
            <div class="left_n">管理中心</div>
            <div class="left_m">
                <div class="left_m_t t_bg1">用户管理</div>
                <ul>
                    <li><a href="loginIndex.jsp">个人信息</a></li>
                    <li><a href="showAllPageServlet?Page=1">用户查询</a></li>
                </ul>
            </div>

            <div class="left_m">
                <div class="left_m_t t_bg1">新闻资讯</div>
                <ul>
                    <li><a href="addnews.jsp">添加新闻</a></li>
                    <li><a href="">查询新闻</a></li>
                </ul>
            </div>
            <div class="left_m">
                <div class="left_m_t t_bg1">商品管理</div>
                <ul>
                    <li><a href="addshop.jsp">添加商品</a></li>
                    <li><a href="shopServlet?action=select&Page=1">查询商品</a></li>
                </ul>
            </div>

        </div>
        <div class="m_right">
            <span id="zh" style="color: red;font-size: 16px">${msg}</span>
            <table border="1" class="mem_tab" style="width:870px;
             text-align:center; margin-top:20px;" cellspacing="0" cellpadding="0">

                <tr>
                    <td width="145" class="td_bg">id</td>
                    <td width="145">用户名</td>
                    <td width="145" class="td_bg">登录名</td>
                    <td width="145">密码</td>
                    <td width="145" class="td_bg">性别</td>
                    <td width="145">类型</td>
                    <td width="145">操作</td>
                </tr>
                <c:forEach items="${showAll.list}" var="user">
                    <tr>
                        <td width="145" class="td_bg">${user.id}</td>
                        <td width="145" >${user.username}</td>

                        <td width="145" class="td_bg">${user.loginname}</td>
                        <td width="145" >${user.password}</td>

                        <td width="145" class="td_bg">${user.sex}</td>
                        <td width="145" >${user.type}</td>
                        <td width="145" >
                            <a href="javascript:del(${user.id},${showAll.page})">删除</a>/
                            <a href="javascript:upd(${user.id},${showAll.page})">修改</a>
                        </td>
                    </tr>
                </c:forEach>

                <tr>
                    <td colspan="7" width="145" class="td_bg">
                        <c:if test="${showAll.page!=1}">
                            <a href="showAllPageServlet?Page=${showAll.page-1}">上一页</a>
                        </c:if>
                        第${showAll.page}/${showAll.countPage}页
                        <c:if test="${showAll.page!=showAll.countPage}">
                            <a href="showAllPageServlet?Page=${showAll.page+1}">下一页</a>
                        </c:if>
                    </td>

                </tr>

            </table>

        </div>
    </div>
    <!--End 用户中心 End-->
    <!--Begin Footer Begin -->
    <div class="b_btm_bg b_btm_c">
        <div class="b_btm">
            <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
                <tr>
                    <td width="72"><img src="images/b1.png" width="62" height="62" /></td>
                    <td><h2>正品保障</h2>正品行货  放心购买</td>

                </tr>
            </table>
            <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
                <tr>
                    <td width="72"><img src="images/b2.png" width="62" height="62" /></td>
                    <td><h2>满38包邮</h2>满38包邮 免运费</td>
                </tr>
            </table>
            <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
                <tr>
                    <td width="72"><img src="images/b3.png" width="62" height="62" /></td>
                    <td><h2>天天低价</h2>天天低价 畅选无忧</td>
                </tr>
            </table>
            <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
                <tr>
                    <td width="72"><img src="images/b4.png" width="62" height="62" /></td>
                    <td><h2>准时送达</h2>收货时间由你做主</td>
                </tr>
            </table>
        </div>
    </div>
    <div class="b_nav">
        <dl>
            <dt><a href="#">新手上路</a></dt>
            <dd><a href="#">售后流程</a></dd>
            <dd><a href="#">购物流程</a></dd>
            <dd><a href="#">订购方式</a></dd>
            <dd><a href="#">隐私声明</a></dd>
            <dd><a href="#">推荐分享说明</a></dd>
        </dl>
        <dl>
            <dt><a href="#">配送与支付</a></dt>
            <dd><a href="#">货到付款区域</a></dd>
            <dd><a href="#">配送支付查询</a></dd>
            <dd><a href="#">支付方式说明</a></dd>
        </dl>
        <dl>
            <dt><a href="#">会员中心</a></dt>
            <dd><a href="#">资金管理</a></dd>
            <dd><a href="#">我的收藏</a></dd>
            <dd><a href="#">我的订单</a></dd>
        </dl>
        <dl>
            <dt><a href="#">服务保证</a></dt>
            <dd><a href="#">退换货原则</a></dd>
            <dd><a href="#">售后服务保证</a></dd>
            <dd><a href="#">产品质量保证</a></dd>
        </dl>
        <dl>
            <dt><a href="#">联系我们</a></dt>
            <dd><a href="#">网站故障报告</a></dd>
            <dd><a href="#">购物咨询</a></dd>
            <dd><a href="#">投诉与建议</a></dd>
        </dl>
        <div class="b_tel_bg">
            <a href="#" class="b_sh1">新浪微博</a>
            <a href="#" class="b_sh2">腾讯微博</a>
            <p>
                服务热线：<br />
                <span>400-123-4567</span>
            </p>
        </div>
        <div class="b_er">
            <div class="b_er_c"><img src="images/er.gif" width="118" height="118" /></div>
            <img src="images/ss.png" />
        </div>
    </div>
    <div class="btmbg">
        <div class="btm">
            备案/许可证编号：蜀ICP备12009302号-1-www.dingguagua.com   Copyright © 2015-2018 尤洪商城网 All Rights Reserved. 复制必究 , Technical Support: Dgg Group <br />
            <img src="images/b_1.gif" width="98" height="33" /><img src="images/b_2.gif" width="98" height="33" /><img src="images/b_3.gif" width="98" height="33" /><img src="images/b_4.gif" width="98" height="33" /><img src="images/b_5.gif" width="98" height="33" /><img src="images/b_6.gif" width="98" height="33" />
        </div>
    </div>
    <!--End Footer End -->
</div>

</body>


<!--[if IE 6]>
<script src="//letskillie6.googlecode.com/svn/trunk/2/zh_CN.js"></script>
<![endif]-->
</html>
