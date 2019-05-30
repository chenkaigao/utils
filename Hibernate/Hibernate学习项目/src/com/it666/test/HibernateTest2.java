package com.it666.test;

import com.it666.domain.Customer;
import com.it666.domain.Linkman;
import com.it666.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class HibernateTest2 {
    //设置关系
    @Test
    public void test1(){
        Session currentSession = HibernateUtils.getCurrentSession();
        Transaction transaction = currentSession.beginTransaction();

        Customer customer1 = new Customer();
        customer1.setCust_name("customer1");
        Customer customer2 = new Customer();
        customer2.setCust_name("customer2");
        Customer customer3 = new Customer();
        customer3.setCust_name("customer3");

        Linkman linkman1 = new Linkman();
        linkman1.setLink_name("linkman1");
        Linkman linkman2 = new Linkman();
        linkman2.setLink_name("linkman2");
        Linkman linkman3 = new Linkman();
        linkman3.setLink_name("linkman3");

        //配置关系      双向维护       单向维护，只要设置一遍，一般都使用双向维护
        customer1.getLinkmans().add(linkman1);
        customer1.getLinkmans().add(linkman2);
        customer2.getLinkmans().add(linkman3);

        /*linkman1.setCustomer(customer1);
        linkman2.setCustomer(customer1);
        linkman3.setCustomer(customer2);*/

        currentSession.save(customer1);
        currentSession.save(customer2);
        currentSession.save(customer3);

        /*
        只保存一边
        org.hibernate.TransientObjectException
        瞬时对象异常
        持久态对象关联一个瞬时对象
        */
        /*currentSession.save(linkman1);
        currentSession.save(linkman2);
        currentSession.save(linkman3);*/

        transaction.commit();
    }

    //级联删除
    @Test
    public void test2(){
        Session currentSession = HibernateUtils.getCurrentSession();
        Transaction transaction = currentSession.beginTransaction();
        //默认删除
        //先打断两表之间的关系     link_cust_id=null;
        //再去删除记录    并没有级联的做删除操作
        //想去做级联的删除操作    必须配置
        Customer customer = currentSession.get(Customer.class, 1L);
        currentSession.delete(customer);

        transaction.commit();
    }
    //更新
    @Test
    public void test3(){
        Session currentSession = HibernateUtils.getCurrentSession();
        Transaction transaction = currentSession.beginTransaction();

        Linkman linkman = currentSession.get(Linkman.class, 1L);
        Customer customer = currentSession.get(Customer.class, 2L);
        //双向维护
        //用双向维护，修改了两个持久态类，快照区对比时会发送两次SQL语句
        //同时更新了同一个外键
        //inverse="true"    让一方放弃外键维护权
        customer.getLinkmans().add(linkman);
        linkman.setCustomer(customer);
        currentSession.update(customer);

        transaction.commit();
    }
}
