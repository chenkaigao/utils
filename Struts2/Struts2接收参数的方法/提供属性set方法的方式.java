package com.it666.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MyformAction3 extends ActionSupport {
    //1.提供属性set方法的方式
    private String username;
    private Date age;
    private List hobby;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(Date age) {
        this.age = age;
    }

    public void setHobby(List hobby) {
        this.hobby = hobby;
    }

    public String execute(){
        System.out.println(username);
        System.out.println(age);
        System.out.println(hobby);
        return SUCCESS;
    }
}
