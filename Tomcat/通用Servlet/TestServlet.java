package com.myxq;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
//让这个类继承BaseServlet，BaseServlet这个类继承了HttpServlet
//浏览器发送请求来到这个servlet，找service方法，这个类没有，就去父类BaseServlet方法找
@WebServlet("/TestServlet")
public class TestServlet extends BaseServlet {
	
	public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("添加");
		return "add.jsp";
	}

	public String del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("删除");
		return "del.jsp";
	}

	public String  update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("更新");
		return "update.jsp";
	}
	
	public String  find(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("查找");
		return "find.jsp";
	}
}
