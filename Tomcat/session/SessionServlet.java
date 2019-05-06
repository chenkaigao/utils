package com.kico.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取session
        HttpSession session = req.getSession();
        //设置JSESSIONID持久化   关闭浏览器后再次访问会携带上次的JSESSIONID获取上次访问的session
        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        cookie.setPath("/");
        cookie.setMaxAge(60*2);
        resp.addCookie(cookie);
        //存数据
        session.setAttribute("lk","www.it666.com");
    }
}
