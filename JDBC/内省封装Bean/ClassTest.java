package com.kico.test;

import com.kico.domain.Student;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

public class ClassTest {
    public Class c;
    public ClassTest(Class c){
        this.c = c;
    }
    public static void main(String[] args) throws Exception{
        /*可以通过Class字节码类创建对象
        ClassTest classTest = new ClassTest(Student.class);
        Student stu = (Student)classTest.c.newInstance();*/

        Student stu = Student.class.newInstance();
        //获取指定字节码属性信息
        BeanInfo beanInfo = Introspector.getBeanInfo(Student.class,Object.class);
        //获取属性描述器
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor pd : pds) {
            //获取所有属性名称
            //System.out.println(pd.getName());
            //获取所有get方法
            //System.out.println(pd.getReadMethod());
            //获取所有set方法
            //System.out.println(pd.getWriteMethod());
            //调用set方法
            pd.getWriteMethod().invoke(stu,"111");
        }
        System.out.println(stu.getS_id());
        System.out.println(stu.getS_name());
        System.out.println(stu.getS_age());
    }
}
