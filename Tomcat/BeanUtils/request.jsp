<%--
  Created by IntelliJ IDEA.
  User: win7
  Date: 2019/4/25
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/Request" method="post">
    <input type="text" placeholder="请输入一些内容" name="name">
    <input type="text" placeholder="请输入一些内容" name="password"><br>
    性别：
    <input type="radio" value="man" name="gender">男
    <input type="radio" value="female" name="gender">女<br>
    爱好：
    <input type="checkbox" name="hobby" value="抽烟">抽烟
    <input type="checkbox" name="hobby" value="喝酒">喝酒
    <input type="checkbox" name="hobby" value="烫头">烫头<br>
    <input type="submit" value="提交">
</form>
</body>
</html>
