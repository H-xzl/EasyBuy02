<%--
  Created by IntelliJ IDEA.
  User: 26728
  Date: 2020/11/4
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link type="text/css" rel="stylesheet" href="css/style.css" />
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
        function update() {
            var  b=confirm("是否修改？");
            return b;
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
        <div class="logo"><a href="Index.html"><img src="images/logo.png" /></a></div>
    </div>
    <div class="regist">
        <div class="log_img"><img src="images/l_img.png" width="611" height="425" /></div>
        <div class="reg_c">
            <form action="shopServlet?action=upd&Page=${page}" method="post" onsubmit="return update()"
                  enctype="multipart/form-data">

                <table border="0" style="width:420px;
                font-size:14px; margin-top:20px;" cellspacing="0" cellpadding="0">

                    <tr height="50">
                        <td align="right"><font color="#ff4e00">*</font>&nbsp;id &nbsp;</td>
                        <td><input type="text" value="${shop.id }"
                                   class="l_user" name="id" readonly="readonly"/></td>
                    </tr>
                    <tr height="50">
                        <td align="right"><font color="#ff4e00">*</font>&nbsp;商品名称 &nbsp;</td>
                        <td><input type="text" value="${shop.name}" class="l_pwd"
                                   name="shopname"/></td>
                    </tr>
                    <tr height="50">
                        <td align="right"><font color="#ff4e00">*</font>&nbsp;商品描述 &nbsp;</td>
                        <td><input type="text" value="${shop.description }" class="l_pwd"
                                   name="description"/></td>
                    </tr>
                    <tr height="50">
                        <td align="right"><font color="#ff4e00">*</font>&nbsp;商品价格 &nbsp;</td>
                        <td><input type="text" value="${shop.price }" class="l_email"
                                   name="price"/></td>
                    </tr>
                    <tr height="50">
                        <td align="right"><font color="#ff4e00">*</font>&nbsp;商品库存 &nbsp;</td>
                        <td><input type="text" value="${shop.stock}" class="l_email"
                                   name="stock"/></td>
                    </tr>

                    <tr height="50">
                        <td align="right"><font color="#ff4e00">*</font>&nbsp;商品类别 &nbsp;</td>
                        <td><input type="text" value="${shop.level}" class="l_email"
                                   name="level"/></td>

                    </tr>

                    <tr height="50">
                        <td align="right"><font color="#ff4e00">*</font>&nbsp;商品图片 &nbsp;</td>
                        <td><img src="shopselectAll?action=img&filename=${shop.filename }">
                            <input type="file" name="filename" >
                        </td>
                    </tr>

                    <tr height="50">
                        <td align="right"><font color="#ff4e00">*</font>&nbsp;商品热卖 &nbsp;</td>
                        <td>
                            <c:if test="${shop.isDisCount==1 }">
                                <input type="radio" value="1" name="isDisCount"
                                       checked="checked"/>是
                                <input type="radio" value="0" name="isDisCount"/>否
                            </c:if>
                            <c:if test="${shop.isDisCount==0 }">
                                <input type="radio" value="1" name="isDisCount" />是
                                <input type="radio" value="0" name="isDisCount"
                                       checked="checked"/>否
                            </c:if>
                        </td>
                    </tr>
                    <tr height="60">
                        <td>&nbsp;</td>
                        <td>
<%--                            <input type="text" name="Page" value="${page}" >--%>
                            <input type="submit" value="立即修改" class="log_btn" /></td>
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
        备案/许可证编号：蜀ICP备12009302号-1-www.dingguagua.com   Copyright ? 2015-2018 尤洪商城网 All Rights Reserved. 复制必究 , Technical Support: Dgg Group <br />
        <img src="images/b_1.gif" width="98" height="33" /><img src="images/b_2.gif" width="98" height="33" /><img src="images/b_3.gif" width="98" height="33" /><img src="images/b_4.gif" width="98" height="33" /><img src="images/b_5.gif" width="98" height="33" /><img src="images/b_6.gif" width="98" height="33" />
    </div>
</div>
<!--End Footer End -->

</body>


<!--[if IE 6]>
<script src="//letskillie6.googlecode.com/svn/trunk/2/zh_CN.js"></script>
<![endif]-->
</html>
