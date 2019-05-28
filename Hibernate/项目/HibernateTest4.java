package com.it666.test;

import com.it666.domain.User;
import com.it666.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class HibernateTest4 {
    @Test
    public void test(){
        /**
         * 当get()方法被调用的时候就会立即发出SQL语句
         * 并且返回的对象也是实际的对象：
         * 使用get()和普通的单条查询并没有多大的区别。
         * 当查询不到的时候get()返回的是null
         */
        Session currentSession = HibernateUtils.getCurrentSession();
        Transaction transaction = currentSession.beginTransaction();
        User user = currentSession.get(User.class, 1L);
        System.out.println(user);
        transaction.commit();
    }
    @Test
    public void  test2(){

        /**
         * 当调用load()方法的时候会返回一个目标对象的代理对象
         * 在这个代理对象中只存储了目标对象的ID值
         * 只有当调用除ID值以外的属性值的时候才会发出SQL查询的
         * 当使用到除ID以外的属性的时候，会发出SQL查询语句
         * 当查询不到的时候load()报错  ObjectNotFoundException
         */

        Session currentSession = HibernateUtils.getCurrentSession();
        Transaction transaction = currentSession.beginTransaction();

        User user = currentSession.load(User.class, 1L);
        System.out.println(user.getUser_id());
        System.out.println(user.getUser_name());


        transaction.commit();
    }
}
