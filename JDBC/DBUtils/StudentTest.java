package com.kico.test;

import com.kico.dao.IStudentDao;
import com.kico.daoiml.StudentDaoImp;
import com.kico.domain.Student;
import org.junit.Test;

import java.util.List;

public class StudentTest {

    //保存测试
    @Test
    public void test1(){
        IStudentDao studentDao = new StudentDaoImp();
        Student stu = new Student();
        stu.setS_name("武器大师");
        stu.setS_age(28);
        studentDao.save(stu);
    }

    //删除测试
    @Test
    public void test2(){
        IStudentDao studentDao = new StudentDaoImp();
        studentDao.delete(13);
    }

    //修改测试
    @Test
    public void test3(){
        IStudentDao studentDao = new StudentDaoImp();
        Student stu = new Student();
        stu.setS_name("寒冰");
        stu.setS_age(17);
        studentDao.update(9,stu);
    }

    //查询一个测试
    @Test
    public void test4(){
        IStudentDao studentDao = new StudentDaoImp();
        Student stu = studentDao.getByid(5);
        System.out.println(stu);
    }

    //查询所有测试
    @Test
    public void test5(){
        IStudentDao studentDao = new StudentDaoImp();
        List<Student> stuList = studentDao.getAll();
        System.out.println(stuList);
    }
    //获取学生总数
    @Test
    public void test6(){
        IStudentDao studentDao = new StudentDaoImp();
        Integer i = studentDao.getCount();
        System.out.println(i);
    }
}
