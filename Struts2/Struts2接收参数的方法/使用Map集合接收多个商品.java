package com.it666.action;


import com.it666.domain.Goods;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;
import java.util.Map;

public class MyformAction7 extends ActionSupport {
    //使用Map集合接收多个商品     注意：map集合顺序不是有序的
    private Map<String,Goods> goodsMap;

    public Map<String, Goods> getGoodsMap() {
        return goodsMap;
    }

    public void setGoodsMap(Map<String, Goods> goodsMap) {
        this.goodsMap = goodsMap;
    }

    public String execute(){
        System.out.println(goodsMap);
        return SUCCESS;
    }


}
