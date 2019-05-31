<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/30 0030
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <s:fielderror/>
  <form action="${pageContext.request.contextPath}/myform.action">
    用户名:<input type="text" placeholder="请输入用户名..." name="username"><br/>
    昵称:<input type="text" placeholder="请输入用户名..." name="nick"><br/>
    爱  好: <input type="checkbox" value="足球" name="hobby">足球
    <input type="checkbox" value="篮球" name="hobby">篮球
    <input type="checkbox" value="乒乓球" name="hobby">乒乓球<br/>
    <input type="submit" value="提交">
  </form>
  <hr>
  <h3>原生API</h3>
  <form action="${pageContext.request.contextPath}/myform2.action">
    用户名:<input type="text" placeholder="请输入用户名..." name="username"><br/>
    昵称:<input type="text" placeholder="请输入用户名..." name="nick"><br/>
    爱  好: <input type="checkbox" value="足球" name="hobby">足球
    <input type="checkbox" value="篮球" name="hobby">篮球
    <input type="checkbox" value="乒乓球" name="hobby">乒乓球<br/>
    <input type="submit" value="提交">
  </form>
  <hr>
  <h3>1.提供属性set方法的方式</h3>
  <form action="${pageContext.request.contextPath}/myform3.action">
    用户名:<input type="text" placeholder="请输入用户名..." name="username"><br/>
    昵称:<input type="text" placeholder="请输入年龄..." name="age"><br/>
    爱  好: <input type="checkbox" value="足球" name="hobby">足球
    <input type="checkbox" value="篮球" name="hobby">篮球
    <input type="checkbox" value="乒乓球" name="hobby">乒乓球<br/>
    <input type="submit" value="提交">
  </form>
  <hr>
  <h3>2.页面中提供表达式方式</h3>
  <form action="${pageContext.request.contextPath}/myform4.action">
    用户名:<input type="text" placeholder="请输入用户名..." name="user.username"><br/>
    昵称:<input type="text" placeholder="请输入年龄..." name="user.age"><br/>
    爱  好: <input type="checkbox" value="足球" name="user.hobby">足球
    <input type="checkbox" value="篮球" name="user.hobby">篮球
    <input type="checkbox" value="乒乓球" name="user.hobby">乒乓球<br/>
    <input type="submit" value="提交">
  </form>
  <hr>
  <h3>3.采用模型驱动方式</h3>
  <form action="${pageContext.request.contextPath}/myform5.action">
    用户名:<input type="text" placeholder="请输入用户名..." name="username"><br/>
    昵称:<input type="text" placeholder="请输入年龄..." name="age"><br/>
    爱  好: <input type="checkbox" value="足球" name="hobby">足球
    <input type="checkbox" value="篮球" name="hobby">篮球
    <input type="checkbox" value="乒乓球" name="hobby">乒乓球<br/>
    <input type="submit" value="提交">
  </form>
  </body>
</html>
