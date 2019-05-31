package com.it666.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;

public class MyformAction2 extends ActionSupport {
    public String execute(){
        //使用Servlet的API的原生方式
        //获取原生API
        HttpServletRequest request = ServletActionContext.getRequest();

        /*
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (String key : parameterMap.keySet()) {
            String[] strings = parameterMap.get(key);
            System.out.println(Arrays.toString(strings));
        }
        */

        String username = request.getParameter("username");
        System.out.println(username);
        String nick = request.getParameter("nick");
        System.out.println(nick);
        //获取多个参数
        String[] hobbies = request.getParameterValues("hobby");
        System.out.println(Arrays.toString(hobbies));
        //往request域 存数据
        request.setAttribute("reqName","reqValue");
        //往session
        request.getSession().setAttribute("sessionName","sessionValue");
        ServletActionContext.getServletContext().setAttribute("applicationName","applicationValue");
        return LOGIN;
    }
}
