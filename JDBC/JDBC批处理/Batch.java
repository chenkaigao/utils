package com.kico.test;

import com.kico.jdbcutil.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Batch {
    public static void main(String[] args){
        Connection conn = JDBCUtils.getCoonection();
        PreparedStatement ps = null;
        try {
            String sql = "insert into user1 (name,password) values(?,?)";
            ps = conn.prepareStatement(sql);
            long begin = System.currentTimeMillis();
            for (int i = 0; i < 1000; i++) {
                ps.setString(1, "赵111");
                ps.setString(2, "111");
                //添加批处理
                ps.addBatch();
            }
//            执行批处理
            ps.executeBatch();
            long end = System.currentTimeMillis();
            long time = end - begin;
            System.out.println(time);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, ps, null);
        }

    }
}
