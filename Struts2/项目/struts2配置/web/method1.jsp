<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/30 0030
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--动态调用goods!add.action前面必须得是goods--%>
<a href="${pageContext.request.contextPath}/goods!add.action">添加</a>
<a href="${pageContext.request.contextPath}/goods!delete.action">删除</a>
<a href="${pageContext.request.contextPath}/goods!update.action">修改</a>
<a href="${pageContext.request.contextPath}/goods!find.action">查询</a>
</body>
</html>
