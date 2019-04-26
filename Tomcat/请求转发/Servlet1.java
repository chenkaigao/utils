package com.kico.test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req);
        //请求转发
        //1.获取转发器
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Servlet2");
        //这里的req对象和Servlet2里的req对象不是同一个，仅仅是内容传给了对方
        requestDispatcher.forward(req,resp);
    }
}
