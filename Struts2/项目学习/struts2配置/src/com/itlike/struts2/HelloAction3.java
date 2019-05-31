package com.itlike.struts2;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction3 extends ActionSupport {
    public String execute(){
        System.out.println("HelloAction3");
        return SUCCESS;
    }
}
