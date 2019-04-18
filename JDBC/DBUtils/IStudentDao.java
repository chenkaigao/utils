package com.kico.dao;

import com.kico.domain.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentDao {
    //保存
    public void save(Student stu);
    //删除
    public void delete(Integer id);
    //修改
    public void update(Integer id,Student stu);
    //查询一个
    public Student getByid(Integer id);
    //查询所有
    public List<Student> getAll();
    //获取学生的总数
    public Integer getCount();
}
