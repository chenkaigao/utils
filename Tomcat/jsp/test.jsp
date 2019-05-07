<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.kico.domain.User" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/6 0006
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setAttribute("count",100);
%>
<c:if test="${1==1}">kico</c:if>
<br>
<c:if test="${count > 50}">
    大于50
</c:if>
<c:if test="${count <= 50}">
    小于等于50
</c:if>
<hr>
<%--从域中取数据  自动把数据存到pageScope--%>
<c:forEach begin="0" end="5" var="i">
   <%-- ${pageScope.i}--%>
    ${i}<br>
</c:forEach>
<hr>
<%
    List<String> strList = new ArrayList<>();
    strList.add("aaa");
    strList.add("bbb");
    strList.add("ccc");
    session.setAttribute("strList",strList);
%>
<%--会自动把取出来的数值保存到pageScope中--%>
<c:forEach items="${strList}" var="str">
    ${str}<br>
</c:forEach>
<hr>
<%
    List<User> userList = new ArrayList<>();
    User user1 = new User();
    user1.setUser_name("user1");
    User user2 = new User();
    user2.setUser_name("user2");
    userList.add(user1);
    userList.add(user2);
    session.setAttribute("userList",userList);
%>
<c:forEach items="${userList}" var="user">
    ${user.user_name}<br>
</c:forEach>
<hr>
<%
    Map<String,String> strMap = new HashMap<>();
    strMap.put("name","kico");
    strMap.put("age","33");
    strMap.put("gender","男");
    session.setAttribute("map", strMap);
%>
<c:forEach items="${map}" var="entry">
    ${entry.key}:${entry.value}<br>
</c:forEach>
</body>
</html>
