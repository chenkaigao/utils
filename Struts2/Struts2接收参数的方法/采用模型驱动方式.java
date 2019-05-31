package com.it666.action;


import com.it666.domain.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class MyformAction5 extends ActionSupport implements ModelDriven<User> {
    private User user = new User();
    @Override
    public User getModel() {
        return user;
    }
    //采用模型驱动方式
    public String execute(){
        System.out.println(user);
        return SUCCESS;
    }


}
