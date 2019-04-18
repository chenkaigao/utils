package com.kico.daoiml;

import com.kico.dao.IStudentDao;
import com.kico.domain.Student;
import com.kico.jdbcutil.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class StudentDaoImp implements IStudentDao {
    //保存
    @Override
    public void save(Student stu) {
        String sql = "insert into student (s_name,s_age) values(?,?)";
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        try {
            qr.update(sql,stu.getS_name(),stu.getS_age());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //删除
    @Override
    public void delete(Integer id) {
        String sql = "delete from student where s_id = ?";
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        try {
            qr.update(sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //修改
    @Override
    public void update(Integer id, Student stu) {
        String sql = "update student set s_name=?,s_age=? where s_id = ?";
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        try {
            qr.update(sql,stu.getS_name(),stu.getS_age(),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //查询一个
    @Override
    public Student getByid(Integer id) {
        String sql = "select * from student where s_id = ?";
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        try {
            return qr.query(sql, new BeanHandler<Student>(Student.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //查询所有
    @Override
    public List<Student> getAll(){
        String sql = "select * from student";
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        try {
            return qr.query(sql, new BeanListHandler<Student>(Student.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test
    public void test(){
        String sql = "select * from student";
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        try {
            List<Map<String, Object>> res = qr.query(sql, new MapListHandler());
            System.out.println(res);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test1(){
        String sql = "select * from student where s_id = ?";
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        try {
            Map<String, Object> res = qr.query(sql, new MapHandler(),5);
            System.out.println(res);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //获取学生总数
    @Override
    public Integer getCount() {
        String sql = "select count(*) from student";
        return null;
    }
}

