package com.kico.code;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        System.out.println(code);
        String word = (String) req.getSession().getAttribute("checkcode_session");
        resp.setContentType("text/html;charset=UTF-8");
        if(code.equals(word)){
            resp.getWriter().write("注册成功");
        }else {
            resp.getWriter().write("注册失败");
            resp.setHeader("refresh","3;url=/index.jsp");
        }
    }
}
