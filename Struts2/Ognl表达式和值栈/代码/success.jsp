<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/31 0031
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--取根元素数据    value里面写的是ognl表达式    只能取栈顶的数据--%>
用户名称：<s:property value="name"/><br>
用户的商品：<s:property value="goods"/><br>
商品的名称：<s:property value="goods.name"/><br>
商品的价格：<s:property value="goods.price"/><br>
<%--在页面中调用普通方法--%>
用户名称的长度：<s:property value="name.length()"/><br>
<%--在页面中调用静态方法--%>
hello的长度：<s:property value="'hello'.length()"/><br>
<s:property value = "@java.lang.Math@floor(12.34)" /><br>
生产一个随机数：<s:property value="@java.lang.Math@random()"/><br>
<%--取非根元素数据     value里面写的是ognl表达式--%>
request域reqName的值：<s:property value="#reqName"/><br>
session域sessionName的值：<s:property value="#session.sessionName"/><br>
application域applicationName的值<s:property value="#application.applicationName"/><br>
<s:debug></s:debug>
<h1>success</h1>
</body>
</html>
