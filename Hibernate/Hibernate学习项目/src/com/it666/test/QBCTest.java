package com.it666.test;

import com.it666.domain.User;
import com.it666.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import java.util.List;

public class QBCTest {
    //Query By Criteria，条件查询。是一种更加面向对象化的查询的方式。
    @Test
    public void test1(){
        //简单查询
        Session session = HibernateUtils.openSession();
        Criteria criteria = session.createCriteria(User.class);
        List<User> list = criteria.list();
        System.out.println(list);
    }
    @Test
    public void test2(){
        //排序查询
        Session session = HibernateUtils.openSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.addOrder(Order.desc("user_id"));
        List<User> list = criteria.list();
        System.out.println(list);
    }
    @Test
    public void test3(){
        //分页查询
        Session session = HibernateUtils.openSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.setFirstResult(2);//从第2个角标开始查询，角标是从0开始的
        criteria.setMaxResults(2);//一共查2条
        List<User> list = criteria.list();
        System.out.println(list);
    }
    @Test
    public void test4(){
        //条件查询
         /**    =   eq
                >   gt
                >=  ge
                <   lt
                <=  le
                <>  ne
                like
                in
                and
                or
         */
        Session session = HibernateUtils.openSession();
        //QBC查询
        Criteria criteria = session.createCriteria(User.class);
        //单条件查询
        criteria.add(Restrictions.eq("user_code","user1"));
        //多条件查询
        criteria.add(Restrictions.like("user_name","李%"));
        //查询
        List<User> list = criteria.list();
        System.out.println(list);
    }
    @Test
    public void test5(){
        //统计查询
        Session session = HibernateUtils.openSession();
        Criteria criteria = session.createCriteria(User.class);
        /**
         聚合函数，group by,having
         setProjection  设置一些聚合函数
         */
        criteria.setProjection(Projections.rowCount());
        //执行查询
        Object o = criteria.uniqueResult();
        System.out.println(o);
    }
    @Test
    public void test6(){
        //离线条件查询
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
        //设置条件
        detachedCriteria.add(Restrictions.like("user_name","张%"));
        //以上为离线条件查询对象，可以由web层传入dao层

        Session session = HibernateUtils.openSession();
        //查询
        Criteria executableCriteria = detachedCriteria.getExecutableCriteria(session);
        List list = executableCriteria.list();
        System.out.println(list);
    }
}
