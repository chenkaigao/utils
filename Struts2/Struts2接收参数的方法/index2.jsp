<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/31 0031
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/myform6.action">
    名称：<input type="text" placeholder="请输入商品名称..." name="goodsList[0].name"><br/>
    价格：<input type="text" placeholder="请输入商品价格..." name="goodsList[0].price"><br/>
    <hr>
    名称：<input type="text" placeholder="请输入商品名称..." name="goodsList[1].name"><br/>
    价格：<input type="text" placeholder="请输入商品价格..." name="goodsList[1].price"><br/>
    <input type="submit" value="提交">
</form>

<hr>

<form action="${pageContext.request.contextPath}/myform7.action">
    名称：<input type="text" placeholder="请输入商品名称..." name="goodsMap['one'].name"><br/>
    价格：<input type="text" placeholder="请输入商品价格..." name="goodsMap['one'].price"><br/>
    <hr>
    名称：<input type="text" placeholder="请输入商品名称..." name="goodsMap['two'].name"><br/>
    价格：<input type="text" placeholder="请输入商品价格..." name="goodsMap['two'].price"><br/>
    <input type="submit" value="提交">
</form>
</body>
</html>
