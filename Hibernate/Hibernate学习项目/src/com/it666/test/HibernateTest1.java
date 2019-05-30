package com.it666.test;

import com.it666.domain.Customer;
import com.it666.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import java.io.Serializable;
import java.util.List;

public class HibernateTest1 {

    //保存
    @Test
    public void test1(){
        /**
        //1.加载Hibernate核心配置文件
        Configuration configure = new Configuration().configure();
        //2.创建sessionFactory ---JDBC连接池
        SessionFactory sessionFactory = configure.buildSessionFactory();
        //3.获取session对象 ---连接对象
        Session session = sessionFactory.openSession();
         */
        //使用getCurrentSession()就不需要session.close();但需要去配置文件把session绑定线程
        //1.获取session
        Session session = HibernateUtils.getCurrentSession();
        //2.开启事务
        Transaction transaction = session.beginTransaction();
        Customer customer = new Customer();
        customer.setCust_name("kico");
        customer.setCust_level("3");
        //3.保存  保存后会返回对象自增的ID
        Serializable id = session.save(customer);
        //4.提交事务
        transaction.commit();
        //5.资源会自动释放
    }
    //删除
    @Test
    public void test2(){
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = session.get(Customer.class, 9L);
        session.delete(customer);
        transaction.commit();
        session.close();
    }
    //修改
    @Test
    public void test3(){
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = session.get(Customer.class, 6L);
        customer.setCust_name("it666");
        session.update(customer);
        transaction.commit();
        session.close();
    }
    //保存或更新
    @Test
    public void test4(){
        //设置了ID就是更新操作，没有设置ID就是保存操作
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = new Customer();
        customer.setCust_id(6L);
        customer.setCust_name("it666");
        session.saveOrUpdate(customer);
        customer.setCust_name("it888");
        transaction.commit();
        session.close();
    }
    //查询一条
    @Test
    public void test5(){
        //使用getCurrentSession()就不需要session.close();
        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = session.get(Customer.class, 1L);
        /*Linkman linkman = session.get(Linkman.class, 1L);
        System.out.println(linkman);*/
        transaction.commit();
        System.out.println(customer);
    }
    //查询所有
    @Test
    public void test6(){
        Session session = HibernateUtils.openSession();
        //HQL查询 是Hibernate内部面向对象的查询方式
        Query query = session.createQuery("from Customer");
        List<Customer> list = query.list();
        System.out.println(list);
        session.close();
    }

}
