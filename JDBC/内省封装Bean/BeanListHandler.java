package com.kico.test;

import com.kico.dao.IResultSetHandler;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BeanListHandler<T> implements IResultSetHandler<List<T>> {
    private Class<T> classType;
    public BeanListHandler(Class<T> classType){
        this.classType = classType;
    }
    @Override
    public List<T> handle(ResultSet rs) throws Exception {
        List<T> list = new ArrayList<>();
        while(rs.next()){
            //创建一个对象
            T obj = this.classType.newInstance();
            //通过内省机制获取属性信息
            //通过Introspector(自省者)获取字节码信息
            BeanInfo bf = Introspector.getBeanInfo(this.classType, Object.class);
            //获取属性扫描器
            PropertyDescriptor[] pds = bf.getPropertyDescriptors();
            for (PropertyDescriptor pd : pds) {
                //因为规定表里边的字段与对象的属性名称一致
                Object val = rs.getObject(pd.getName());
                //给对象属性设置值
                pd.getWriteMethod().invoke(obj,val);
            }
            //把对象存放到集合当中
            list.add(obj);
        }
        return list;
    }
}
