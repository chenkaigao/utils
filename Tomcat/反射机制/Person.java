package com.kico.test;

public class Person {
    public String name;
    public Integer age;
    private String gender;

    public Person() {
    }

    public Person(String name, Integer age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void show(){
        System.out.println("姓名："+this.name+"，年龄："+this.age+"，性别："+this.gender);
    }
    private void eat(String food){
        System.out.println(this.name+"在吃："+food);
    }
}
