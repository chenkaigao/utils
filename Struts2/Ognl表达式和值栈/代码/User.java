package com.it666.domain;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class User {
    private String name;
    private Goods goods;


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", goods=" + goods +
                '}';
    }
}
