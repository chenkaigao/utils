package com.it666.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtils {
    public static final SessionFactory sessionFactory;
    static {
        //1.加载Hibernate核心配置文件
        //configure.addResource("com/it666/domain/Customer.hbm.xml");
        Configuration configure = new Configuration().configure();
        //2.创建sessionFactory ---JDBC连接池
        sessionFactory = configure.buildSessionFactory();
    }

    public static Session openSession(){
        //3.获取session对象 ---连接对象
        Session session = sessionFactory.openSession();
        return session;
    }
    //一般都用这个获取session
    public static Session getCurrentSession(){
        //3.获取当前线程的session对象 ---连接对象
        Session session = sessionFactory.getCurrentSession();
        return session;
    }

}
