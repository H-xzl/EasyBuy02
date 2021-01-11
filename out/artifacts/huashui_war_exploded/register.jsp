<%--
  Created by IntelliJ IDEA.
  User: 26728
  Date: 2020/11/2
  Time: 9:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html xmlns="http://www.w3.org/1999/xhtml">
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
        var T=false;
        function fun1() {
            //使用ajax形式向后台发送请求
            var loginname =$("#loginname").val();
            if(loginname==""){
               //输入为空不做判断
            }else {
                //输入不为空做判断
                $.ajaxSettings.async = false;//禁用异步执行，便可设置js函数的返回值。

                $.get("UserAjaxServlet",{"loginname":loginname},function (data) {
                    if(data.flag){
                        //用户已存在,不可用!
                        $("#zh").html(data.msg);
                        $("#zh").css("color","red");
                        T=false;
                    }else {
                        //用户不存在,可用!
                        $("#zh").html(data.msg);
                        $("#zh").css("color","green");
                        T=true;
                    }
                },"json");


            }
            return T;
        }
        function fun2() {
           //判断确认密码
            //1.获取节点信息
            var  p1=$("#p1").val();
            var  p2=$("#p2").val();
            if(p1.length>=6){
                $("#pd1").html("<font color='green'>✔</font>");
                if(p1==p2){
                    //密码一致
                    $("#pd2").html("<font color='green'>✔</font>");
                    return true;
                }else {
                    //密码不一致
                    $("#pd2").html("<font color='red'>✖</font>");
                    return false;
                }
            }else {
                $("#pd1").html("<font color='red'>✖</font>");
                return false;
            }

        }
        function fun3() {
            //判断数据是否符合条件
            if (fun1()&&fun2()) {
                return true;
            }else {
                $("#zh").html("格式不符合");
                $("#zh").css("color","red");
                return false;
            }
        }

    </script>


    <title>尤洪</title>
</head>
<body>
<!--Begin Header Begin-->

<!--End Header End-->
<!--Begin Login Begin-->
<div class="log_bg">
    <div class="top">
        <div class="logo"><a href="Index.html"><img src="images/logo.png"/></a></div>
    </div>
    <div class="regist">
        <div class="log_img"><img src="images/l_img.png" width="611" height="425"/></div>
        <div class="reg_c">
            <form action="registerServlet" method="post" onsubmit="return fun3()">
                <span id="zh"></span>
                <table border="0"
                       style="width:420px; font-size:14px; margin-top:20px;"
                       cellspacing="0"
                       cellpadding="0">

                    <tr height="50">
                        <td align="right">
                            <font color="#ff4e00">*</font>&nbsp;登录帐号 &nbsp;
                        </td>
                        <td><input type="text" id="loginname"
                                   class="l_pwd" name="loginname" onblur="fun1()"/>
                        </td>
                    </tr>
                    <tr >
<%--                        <td><span id="zh"></span></td>--%>
                    </tr>

                    <tr height="50">
                        <td align="right">
                            <font color="#ff4e00">*</font>&nbsp;密码 &nbsp;
                        </td>
                        <td><input type="password"
                                   class="l_pwd"
                                   placeholder="至少输入6位"
                                   name="password"
                                   id="p1"/>
                        <span id="pd1"></span>
                        </td>
                    </tr>
                    <tr height="50">
                        <td align="right">
                            <font color="#ff4e00">*</font>&nbsp;确认密码 &nbsp;
                        </td>
                        <td><input type="password"
                                   class="l_pwd"
                                   placeholder="至少输入6位"
                                   name="password1"
                                   id="p2" onblur="fun2()"/>
                            <span id="pd2"></span>
                        </td>
                    </tr>
                    <tr height="50">
                        <td align="right">
                            <font color="#ff4e00">*</font>&nbsp;姓名 &nbsp;
                        </td>
                        <td><input type="text"
                                   class="l_email"
                                   name="username"/></td>
                    </tr>

                    <tr height="50">
                        <td align="right"><font color="#ff4e00">*</font>&nbsp;性别 &nbsp;</td>
                        <td>
                            <input type="radio" value="男" name="sex" checked="checked"/>男
                            <input type="radio" value="女" name="sex"/>女
                        </td>
                    </tr>


                    <tr height="60">
                        <td>&nbsp;</td>

                        <td>
                            <input type="submit" value="立即注册" class="log_btn"/></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
<!--End Login End-->
<!--Begin Footer Begin-->
<div class="btmbg">
    <div class="btm">
        备案/许可证编号：蜀ICP备12009302号-1-www.dingguagua.com Copyright © 2015-2018 尤洪商城网 All Rights Reserved. 复制必究 , Technical
        Support: Dgg Group <br/>
        <img src="images/b_1.gif" width="98" height="33"/><img src="images/b_2.gif" width="98" height="33"/><img
            src="images/b_3.gif" width="98" height="33"/><img src="images/b_4.gif" width="98" height="33"/><img
            src="images/b_5.gif" width="98" height="33"/><img src="images/b_6.gif" width="98" height="33"/>
    </div>
</div>
<!--End Footer End -->

</body>


<!--[if IE 6]>
<script src="//letskillie6.googlecode.com/svn/trunk/2/zh_CN.js"></script>
<![endif]-->
</html>
