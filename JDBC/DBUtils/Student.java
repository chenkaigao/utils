package com.kico.domain;

public class Student {
    private Integer s_id;
    private String s_name;
    private Integer s_age;

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public Integer getS_age() {
        return s_age;
    }

    public void setS_age(Integer s_age) {
        this.s_age = s_age;
    }

    @Override
    public String toString() {
        return "student{" +
                "s_id=" + s_id +
                ", s_name='" + s_name + '\'' +
                ", s_age='" + s_age + '\'' +
                '}';
    }
}