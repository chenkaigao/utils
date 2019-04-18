package com.kico.test;

import com.kico.jdbcutil.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class GenerateKey {
    public static void main(String[] args) {
        Connection conn = JDBCUtils.getCoonection();
        PreparedStatement ps = null;
        try {
            String sql = "insert into user1 (name) values(?)";
            //设置可以获取主键
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,"zhangsan");
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                //由于不知道查出来的字段名称叫什么，所以写一个1来表示第一个字段
                int id = rs.getInt(1);
                System.out.println(id);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, ps, null);
        }
    }
}
