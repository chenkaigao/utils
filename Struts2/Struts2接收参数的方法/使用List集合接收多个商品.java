package com.it666.action;


import com.it666.domain.Goods;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class MyformAction6 extends ActionSupport {
    //使用List集合接收多个商品
    private List<Goods> goodsList;

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public String execute(){
        System.out.println(goodsList);
        return SUCCESS;
    }


}
