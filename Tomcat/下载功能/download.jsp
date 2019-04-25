<%--
  Created by IntelliJ IDEA.
  User: win7
  Date: 2019/4/23
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>a标签下载</h1>
  <a href="${pageContext.request.contextPath}/download/abc.txt">abc.txt</a>  <hr>
  <a href="${pageContext.request.contextPath}/download/Day1.rar">Day1.rar</a>  <hr>
  <a href="${pageContext.request.contextPath}/download/GXG01.png">GXG01.png</a>  <hr>
  <a href="${pageContext.request.contextPath}/download/信仰.mp4">信仰.mp4</a>  <hr>
  <h1>servlet下载</h1>
  <a href="${pageContext.request.contextPath}/DownloadServlet?filename=abc.txt">abc.txt</a>  <hr>
  <a href="${pageContext.request.contextPath}/DownloadServlet?filename=Day1.rar">Day1.rar</a>  <hr>
  <a href="${pageContext.request.contextPath}/DownloadServlet?filename=GXG01.png">GXG01.png</a>  <hr>
  <a href="${pageContext.request.contextPath}/DownloadServlet?filename=信仰.mp4">信仰.mp4</a>  <hr>
  </body>
</html>
