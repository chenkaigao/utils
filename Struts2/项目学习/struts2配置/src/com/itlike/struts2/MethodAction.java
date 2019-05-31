package com.itlike.struts2;

import com.opensymphony.xwork2.ActionSupport;

public class MethodAction extends ActionSupport {
    public String add(){
        System.out.println("add");
        return SUCCESS;
    }
    public String delete(){
        System.out.println("delete");
        return SUCCESS;
    }
    public String update(){
        System.out.println("update");
        return SUCCESS;
    }
    public String find(){
        System.out.println("find");
        return SUCCESS;
    }
}
