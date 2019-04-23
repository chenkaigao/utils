package com.kico.test;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取全局域
        ServletContext servletContext = this.getServletContext();
        //获取web应用根目录    web项目部署路径    D:\Java\IdeaProjects\kico\out\artifacts\kico_war_exploded\
        // 拼接后面的路径     得到一个新路径D:\Java\IdeaProjects\kico\out\artifacts\kico_war_exploded\abc.xml
        String realPath = servletContext.getRealPath("abc.xml");
        System.out.println(realPath);
        //获取字节码目录绝对路径D:/Java/IdeaProjects/kico/out/artifacts/kico_war_exploded/WEB-INF/classes/
        // 然后加载后面路劲的资源文件
        String path = Servlet.class.getClassLoader().getResource("com/kico/test/Person.class").getPath();
        System.out.println(path);
    }
}
