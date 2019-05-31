package com.it666.action;

import com.it666.domain.User;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class MyformAction4 extends ActionSupport {
    //页面中提供表达式方式    jsp里面使用user.username
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String execute(){
        System.out.println(user);
        return SUCCESS;
    }
}
