package com.kico.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /***********************1.创建和响应cookie***********************/
        //创建Cookie
        Cookie cookie = new Cookie("lk", "it666");
        //Cookie默认是会话级别   存在浏览器内存中  浏览器一关就消失了
        //可以手动的设置Cookie保存时间  Cookie是被持久化到浏览器磁盘单中
        //cookie.setMaxAge(60);//60秒后自动删除，从响应给浏览器开始计时60秒。
        /**
         默认在创建Cookie的web资源相同路劲下都会携带
         http://localhost:8080/CookieServlet
         http://localhost:8080/在此路劲后边的资源都会携带

        可以设置指定的路劲携带Cookie
        cookie.setPath("/CookiePro/CookieServlet");指定的文件携带
        cookie.setPath("/CookiePro");指定的工程
        cookie.setPath("/");服务器部署下的所有工程     一般不会使用这个

         删除cookie   创建同名cookie
         Cookie cookie = new Cookie("lk", "it666");
         cookie.setMaxAge(0);
         */
        //把Cookie响应给浏览器
        resp.addCookie(cookie);
        /***********************2.获取cookie***********************/
        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            for (Cookie cookie1 : cookies) {
                String name = cookie1.getName();
                if(name.equals("lk")){
                    System.out.println("lk = " + cookie1.getValue());
                }
            }
        }
        /***********************3.获取上一次登录时间***********************/
        //因为要响应给浏览器所以设置编码格式
        resp.setContentType("text/html;charset=UTF-8");
        //获取时间
        Date date = new Date();
        //时间格式化器
        //格式化参数如果中间加空格会服务器会报错"yyyy-MM-dd HH:mm:ss"
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-dHH:mm:ss");
        String formatDate = sdf.format(date);
        System.out.println(formatDate);
        //创建cookie
        Cookie cookie1 = new Cookie("lasttime",formatDate );
        //响应给浏览器
        resp.addCookie(cookie1);
        //判断是否第一次访问
        Cookie[] cookies2 = req.getCookies();
        String lastTime = null;
        //遍历cookie，如果有就赋值给lastTime
        if(cookies != null){
            for (Cookie cookie2 : cookies2) {
                String name = cookie2.getName();
                if(name.equals("lasttime")){
                    lastTime = cookie2.getValue();
                }
            }
        }
        //判断lastTime是否有值
        if(lastTime != null){
            resp.getWriter().write("上一次访问时间是：" + lastTime);
        }else {
            resp.getWriter().write("你是第一次访问");
        }
    }
}
