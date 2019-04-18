package com.kico.test;

import com.kico.jdbcutil.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Commit {
    public static void main(String[] args) {
        //创建连接
        Connection conn = JDBCUtils.getCoonection();
        PreparedStatement ps = null;
        try{
            //设置关闭事务自动提交	MySQL默认是一条语句一个事务
            conn.setAutoCommit(false);
            String sql = "update account set money = money - ? where name = ?";
            ps = conn.prepareStatement(sql);
            ps.setDouble(1,1000);
            ps.setString(2,"zs");
            ps.executeUpdate();

//            int i = 1/0;

            sql = "update account set money = money + ? where name = ?";
            ps = conn.prepareStatement(sql);
            ps.setDouble(1,1000);
            ps.setString(2,"lisi");
            ps.executeUpdate();
            //手动提交事务
            conn.commit();
        }catch(Exception e){
            e.printStackTrace();
            try {
                //回滚
                conn.rollback();
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }finally {
            //释放资源
            JDBCUtils.close(conn,ps,null);
        }

    }
}
