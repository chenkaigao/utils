package com.kico.jdbc;

import java.sql.*;

public class JDBC {
    public static void main(String[] args) {

        Connection conn = null;
        Statement st = null;
        try {
            //1.加载Msql驱动包 加载相对于Msql数据库的JDBC实现类
            Class.forName("com.mysql.jdbc.Driver");
            //2.创建实现类并输入参数连接数据库
            String url = "jdbc:mysql://localhost:3306/kico";
            String user = "root";
            String password = "1234";
            conn = DriverManager.getConnection(url, user, password);
            System.out.println(conn);

            //3.编写SQL语句
            String Sql = "insert into student (s_name,s_score) values('wc',60)";
            st = conn.createStatement();
            //4.执行SQL语句
            int row = st.executeUpdate(Sql);
            System.out.println(row);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.关闭资源
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
}
