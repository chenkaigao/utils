package com.kico.test;

import com.kico.jdbcutil.JDBCUtils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Blob {
    public static void main(String[] args) {
        //把数据库的图片复制到指定电脑中去
        Connection conn = JDBCUtils.getCoonection();
        PreparedStatement ps = null;
        try {
            String sql = "select * from user1 where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,2);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                //获取图片
                java.sql.Blob blob = rs.getBlob("img");
                //转成JAVA识别的二进制流文件
                InputStream in = blob.getBinaryStream();
                //复制到指定路径
                Files.copy(in, Paths.get("d:/gxg.png"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, ps, null);
        }
    }
    //把图片保存到数据库的方法
    public void write(){
        Connection conn = JDBCUtils.getCoonection();
        PreparedStatement ps = null;
        try {
            String sql = "insert into user1 (img) values(?)";
            ps = conn.prepareStatement(sql);
            //读取文件 计算机能识别的二进制流文件
            //InputStream输入流
            //把电脑当中的文件放到程序中（以二进制流）（输入流）
            FileInputStream f = new FileInputStream("C:/Users/Administrator/Desktop/临时文件/GXG02.png");
            ps.setBlob(1,f);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, ps, null);
        }
    }
}
