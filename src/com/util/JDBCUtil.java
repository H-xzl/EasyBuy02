package com.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
* 数据库连接工具类
* 使用连接池技术抽取公共操作数据库的方法
* */
public class JDBCUtil {
    //定义一个静态成员变量，声明创建连接池对象
    private static DataSource ds=new ComboPooledDataSource();
    //定义一个成员变量，表示连接对象
    private static Connection conn=null;
    //定义一个成员变量，表示执行sql对象
    private  static PreparedStatement stat=null;
    //定义一个成员变量，标识resultSet对象
    private  static ResultSet rs=null;

    //1.获取连接对象
    public static void getConnection(){
        try {
             conn = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //2.关闭资源
    public static  void close(){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stat!=null){
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //3.公共的增删改
    public static int adu(String sql,Object...obj){
        //1.获取连接
        getConnection();

        try {
            //2.获取执行sql对象
            stat=conn.prepareStatement(sql);
            //3.设置占位符值
            if(obj!=null){
                for (int i = 0; i < obj.length; i++) {
                    stat.setObject(i+1,obj[i]);
                }
            }
            //4.执行sql
            int i = stat.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return 0;
    }

    //4.公共的查询
    public static ResultSet select(String sql,Object...obj){
        //1.获取连接
        getConnection();

        try {
            //2.获取执行sql对象
             stat = conn.prepareStatement(sql);
             //3.设置参数
            if(obj!=null){
                for (int i = 0; i < obj.length; i++) {
                    stat.setObject(i+1, obj[i]);
                }

            }
            //4.执行sql
            rs = stat.executeQuery();
            return  rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
