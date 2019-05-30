package com.it666.test;

import com.it666.domain.Role;
import com.it666.domain.User;
import com.it666.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class HibernateTest3 {

    @Test
    public void test1(){
        Session currentSession = HibernateUtils.getCurrentSession();
        Transaction transaction = currentSession.beginTransaction();

        //创建用户
        User user1 = new User();
        user1.setUser_name("user1");
        User user2 = new User();
        user2.setUser_name("user2");
        //创建角色
        Role role1 = new Role();
        role1.setRole_name("role1");
        Role role2 = new Role();
        role2.setRole_name("role2");
        Role role3 = new Role();
        role3.setRole_name("role3");

        //配置关系  单向维护    双向维护
        user1.getRoles().add(role1);
        user1.getRoles().add(role2);
        user2.getRoles().add(role2);
        user2.getRoles().add(role3);
        //多对多中的双向维护必须有一方放弃维护权
        //否则报错Duplicate entry '1-1' for key 'PRIMARY'   主键重复异常
        //被选择的一方放弃维护权
        role1.getUsers().add(user1);
        role2.getUsers().add(user1);
        role2.getUsers().add(user2);
        role3.getUsers().add(user2);

        currentSession.save(user1);
        currentSession.save(user2);
        /*currentSession.save(role1);
        currentSession.save(role2);
        currentSession.save(role3);*/

        transaction.commit();
    }

    //关系操作  操作内部集合
    @Test
    public void test2(){
        Session currentSession = HibernateUtils.getCurrentSession();
        Transaction transaction = currentSession.beginTransaction();

        //给user2添加一个新角色role3
        User user2 = currentSession.get(User.class, 2L);
        Role role3 = currentSession.get(Role.class, 3L);
        user2.getRoles().add(role3);
        role3.getUsers().add(user2);

        transaction.commit();
    }

    @Test
    public void test3(){
        Session currentSession = HibernateUtils.getCurrentSession();
        Transaction transaction = currentSession.beginTransaction();

        //把用户user2的角色role3改成角色role1
        User user2 = currentSession.get(User.class, 2L);
        Role role3 = currentSession.get(Role.class, 3L);
        Role role1 = currentSession.get(Role.class, 1L);
        user2.getRoles().remove(role3);
        user2.getRoles().add(role1);

        transaction.commit();
    }
}
