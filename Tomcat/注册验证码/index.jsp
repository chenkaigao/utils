<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/24 0024
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <form action="${pageContext.request.contextPath}/RegistServlet">
    <img id="show" src="${pageContext.request.contextPath}/CheckCodeServlet"><br>
    <input type="text" placeholder="请输入验证码..." name="code"><br>
    <input type="submit" value="提交">
  </form>


  <script type="text/javascript" src="jQuery/jquery-3.3.1.js"></script>
  <script type="text/javascript">
    $(function () {
      $('#show').click(function () {
        //由于浏览器缓存，每次发送都是一样的地址，加上时间就会重新发送
        var time = new Date().getTime();
        $(this).attr('src',$(this).attr('src')+"?"+time)
      });
    })
  </script>
  </body>
</html>
