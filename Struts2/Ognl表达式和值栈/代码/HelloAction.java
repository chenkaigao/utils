package com.it666.web;

import com.it666.domain.Goods;
import com.it666.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

public class HelloAction extends ActionSupport implements ModelDriven<Goods> {
    private Goods goods = new Goods();
    @Override
    public Goods getModel() {
        return goods;
    }
    public String execute(){
        //获取值栈
        //根区        非根区
        //根区：当前action相关数据都存在根区
        //非根区：是一些整个程序相关数据 相关域 request session application
        ActionContext context = ActionContext.getContext();
        ValueStack valueStack = context.getValueStack();
        //入栈
        Goods goods = new Goods();
        goods.setName("111");
        goods.setPrice(20.0);
        User user = new User();
        user.setName("kico");
        user.setGoods(goods);
        /*valueStack.getRoot().push(goods);下面是简写*/
        valueStack.push(user);
        //出栈
        /*valueStack.getRoot().pop();*/
        //valueStack.pop();
        //往域当中写入一些数据
        //往request域写入参数
        context.put("reqName","reqValue");
        //往session
        context.getSession().put("sessionName","sessionValue");
        //往Application
        context.getApplication().put("applicationName","applicationValue");
        System.out.println(goods);
        return SUCCESS;
    }


}
