package com.kico.test;

import java.io.FileInputStream;

public class Properties {
    public static void main(String[] args) throws Exception {
        //读取配置文件
        java.util.Properties p = new java.util.Properties();
        FileInputStream in = new FileInputStream("resouce/db.properties");
        p.load(in);
        //读取文件
        System.out.println(p.getProperty("url"));
        System.out.println(p.getProperty("user"));
    }
}
