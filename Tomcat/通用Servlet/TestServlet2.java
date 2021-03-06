package com.myxq;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet2")
public class TestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String desPath = null;
		// 接收参数
		String action = request.getParameter("action");
		if ("add".equals(action)) {
			// 添加
			desPath = add(request, response);
		} else if ("del".equals(action)) {
			// 删除
			desPath = del(request,response);
		} else if ("update".equals(action)) {
			// 更新
			desPath = update(request,response);
		}
		//转发
		if(desPath != null) {
			request.getRequestDispatcher(desPath).forward(request, response);
		}
		
	}

	protected String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("添加");
		return "add.jsp";
	}

	protected String del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("删除");
		return "del.jsp";
	}

	protected String  update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("更新");
		return "update.jsp";
	}
}