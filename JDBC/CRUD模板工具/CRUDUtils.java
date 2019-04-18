package com.kico.jdbcutil;

import com.kico.dao.IResultSetHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CRUDUtils {

    //DML操作方法
    public static int executeUpdate(String sql, Object... params) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getCoonection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, ps, null);
        }
        return 0;
    }

    //DQL操作方法
    public static <T>T executeQuery(String sql,IResultSetHandler<T> rh, Object...params){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getCoonection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            rs = ps.executeQuery();
            return rh.handle(rs);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn,ps,rs);
        }
        return null;
    }
}
