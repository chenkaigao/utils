package com.kico.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflect {
    public static void main(String[] args) throws Exception {
        //获取字节码文件
/*        Class<Person> clazz = (Class<Person>) Class.forName("com.kico.test.Person");
        Person person = new Person();
        Class<Person> clazz = (Class<Person>) person.getClass();*/
        Class<Person> clazz = Person.class;
        Person person1 = clazz.newInstance();
        //获取公共字段
        Field f1 = clazz.getField("name");
        //设置公共字段
        f1.set(person1,"张三");
        Field f2 = clazz.getField("age");
        f2.set(person1,18);
        //通过暴力反射获取私有字段
        Field f3 = clazz.getDeclaredField("gender");
        //去除私有权限
        f3.setAccessible(true);
        //设置私有字段
        f3.set(person1,"男");
        //获取公共方法
        Method show = clazz.getMethod("show");
        //调用方法
        show.invoke(person1);
        //通过反射获取构造器
        Constructor<Person> constructor = clazz.getConstructor(String.class, Integer.class, String.class);
        //通过构造器创建类
        Person person2 = constructor.newInstance("李四", 19, "男");
        show.invoke(person2);
        //通过反射暴力获取私有方法
        Method eat = clazz.getDeclaredMethod("eat", String.class);
        //设置方法去除私有
        eat.setAccessible(true);
        //调用私有方法
        eat.invoke(person1,"芒果");
    }
}
