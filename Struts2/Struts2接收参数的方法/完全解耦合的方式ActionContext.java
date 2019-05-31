package com.it666.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.dispatcher.HttpParameters;

import java.util.Arrays;

public class MyformAction extends ActionSupport {
    public String execute(){
        //完全解耦合的方式
        //接收表单当中的参数
        ActionContext context = ActionContext.getContext();
        HttpParameters parameters = context.getParameters();
        //获取参数
        String username = parameters.get("username").getValue();
        System.out.println(username);
        String nick = parameters.get("nick").getValue();
        System.out.println(nick);
        //获取多个参数
        String[] hobbies = parameters.get("hobby").getMultipleValues();
        System.out.println(Arrays.toString(hobbies));
        System.out.println("接收到表单");
        //往request域写入参数
        context.put("reqName","reqValue");
        //往session
        context.getSession().put("sessionName","sessionValue");
        //往Application
        context.getApplication().put("applicationName","applicationValue");
        return SUCCESS;
    }
}
