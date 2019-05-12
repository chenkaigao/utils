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
//�������̳�BaseServlet��BaseServlet�����̳���HttpServlet
//��������������������servlet����service�����������û�У���ȥ����BaseServlet������
@WebServlet("/TestServlet")
public class TestServlet extends BaseServlet {
	
	public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("���");
		return "add.jsp";
	}

	public String del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ɾ��");
		return "del.jsp";
	}

	public String  update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("����");
		return "update.jsp";
	}
	
	public String  find(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("����");
		return "find.jsp";
	}
}
