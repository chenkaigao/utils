package com.kico.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

@WebServlet("/Request")
public class Request extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*通用的解决乱码方式
        String name = req.getParameter("name");
        System.out.println(name);
        byte[] bytes = name.getBytes("ISO8859-1");
        String s = new String(bytes, "UTF-8");
        System.out.println(s);*/

        //现在使用的方法可以设置请求时使用的编码   只适用post提交方式     get方式使用无效
        //form表单以后都是post方式提交
        req.setCharacterEncoding("UTF-8");
        /**********************1.获取请求行********************/
        //1.1获取请求方式    get post
        String method = req.getMethod();
        System.out.println("method = "+method);
        //1.2获取请求资源    URL URI
        StringBuffer requestURL = req.getRequestURL();
        String requestURI = req.getRequestURI();
        System.out.println("requestURL = "+requestURL);
        System.out.println("requestURI = "+requestURI);
        //1.3获取get请求参数
        String queryString = req.getQueryString();
        System.out.println("queryString = "+queryString);
        //1.4获取当前web应用名称
        String contextPath = req.getContextPath();
        System.out.println("contextPath = "+contextPath);
        System.out.println("------------------------------------------------------");
        /**********************2.获取请求头********************/
        //2.1获取所有请求头名称
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()){
            System.out.println("name = "+headerNames.nextElement());
        }
        //2.2根据名称获取指定的头信息
        String referer = req.getHeader("referer");
        System.out.println("referer = "+referer);
        //2.3打印所有请求头和请求头内容
        Enumeration<String> headerNames2 = req.getHeaderNames();
        while (headerNames2.hasMoreElements()){
            String name = headerNames2.nextElement();
            String value = req.getHeader(name);
            System.out.println(name+" : "+value);
        }
        System.out.println("------------------------------------------------------");
        /**********************3.获取请求体********************/
        //3.1获取一个值
        String name = req.getParameter("name");
        System.out.println(name);
        //3.2获取多个值
        String[] hobbies = req.getParameterValues("hobby");
        System.out.println(Arrays.toString(hobbies));
        //3.3获取所有请求参数名称
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()){
            System.out.println("name = "+parameterNames.nextElement());
        }
        //3.4获取所有请求参数
        Map<String, String[]> parameterMap = req.getParameterMap();
        for (Map.Entry<String, String[]> stringEntry : parameterMap.entrySet()) {
            System.out.println(stringEntry.getKey()+" : "+Arrays.toString(stringEntry.getValue()));
        }
    }
}
