package com.kico.jdbcutil;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
    //连接池
    public static DataSource ds = null;

    static {
        try {
            //读取配置文件
            Properties p = new Properties();
            FileInputStream in = new FileInputStream("resouce/db.properties");
            p.load(in);
            //创建连接池
            ds = DruidDataSourceFactory.createDataSource(p);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //获取连接
    public static Connection getCoonection() {
        try {
            //2.创建连接
            return ds.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //关闭资源
    public static void close(Connection conn,Statement st,ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (st != null) {
            try {
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
