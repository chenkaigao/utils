package com.it666.test;

import com.it666.domain.User;
import com.it666.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class HQLTest {
    //HQL查询：Hibernate Query Language，Hibernate的查询语言
    //是一种面向对象的方式的查询语言，语法类似SQL。
    //通过session.createQuery()，用于接收一个HQL进行查询方式。
    @Test
    public void test1(){
        //简单查询HQL
        Session session = HibernateUtils.openSession();
        /*Query query = session.createQuery("from User ");*/
        //别名查询
        /*Query query = session.createQuery("select c from User c");*/
        //排序查询  desc降序
        Query query = session.createQuery("select c from User c order by user_id desc ");
        List<User> list = query.list();
        System.out.println(list);
    }
    @Test
    public void test2(){
        //条件查询HQL
        /*占位符方法过时了，一般不用这种方法
        Session session = HibernateUtils.openSession();
        Query query = session.createQuery("from User where user_code=?0 and user_name=?1");
        query.setParameter(0,"user1");
        query.setParameter(1,"张三");
        List<User> list = query.list();
        System.out.println(list);*/
        //起别名条件查询
        Session session = HibernateUtils.openSession();
        Query query = session.createQuery("from User where user_code=:aaa and user_name=:bbb");
        query.setParameter("aaa","user1");
        query.setParameter("bbb","张三");
        List<User> list = query.list();
        System.out.println(list);
    }
    @Test
    public void test3(){
        //投影查询  查询单个属性
        Session session = HibernateUtils.openSession();
        Query query1 = session.createQuery("select u.user_name from User u");
        List<Object> list1 = query1.list();
        System.out.println(list1);
        System.out.println("------------------------------");
        //查询多个属性
        Query query2 = session.createQuery("select u.user_code,u.user_name from User u");
        List<Object[]> list2 = query2.list();
        for (Object[] objects : list2) {
            System.out.println(Arrays.toString(objects));
        }
        System.out.println("------------------------------");
        //把查询多个属性的结果封装成对象   关键点要提供多个属性的构造器
        Query query3 = session.createQuery("select new User(u.user_code,u.user_name) from User u");
        List<User> list = query3.list();
        System.out.println(list);
    }
    @Test
    public void test4(){
        //分页查询
        Session session = HibernateUtils.openSession();
        Query query = session.createQuery("from User ");
        query.setFirstResult(0);//角标的开始位置
        query.setMaxResults(2);//一次查询多少条
        List<User> list = query.list();
        System.out.println(list);
    }
    @Test
    public void test5(){
        //统计查询
        Session session = HibernateUtils.openSession();
        Query query = session.createQuery("select count(*) from User ");
        Object o = query.uniqueResult();
        System.out.println(o);
    }
    @Test
    public void test6(){
        //分组查询
        Session session = HibernateUtils.openSession();
        Query query = session.createQuery("select u.user_code,count(*) from User u group by u.user_code");
        List<Object[]> list = query.list();//返回的是Object数组
        for (Object[] objects : list) {
            System.out.println(Arrays.toString(objects));
        }
    }
    @Test
    public void test7(){
        //多表连接查询    内连接：只查询相同的部分，外键相同的部分
        Session session = HibernateUtils.openSession();
        //不需要再写外键相等的操作，在配置文件中当中已经添加了外键
        //得到的是两个对象的数组
        Query query = session.createQuery("from User u inner join u.roles");
        List<Object[]> list = query.list();
        for (Object[] objects : list) {
            System.out.println(Arrays.toString(objects));
        }

    }
    @Test
    public void test8(){
        //多表连接查询
        Session session = HibernateUtils.openSession();
        //fetch迫切内连接：通过hibernate将另一个对象的数据，封装到该对象当中去
        Query query = session.createQuery("from User u inner join fetch u.roles");
        List<User> list = query.list();
        System.out.println(list);
    }
}
