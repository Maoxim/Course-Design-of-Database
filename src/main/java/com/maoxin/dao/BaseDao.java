package com.maoxin.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class BaseDao {

    static{//静态代码块,在类加载的时候执行
        init();
    }

    private  final static String driver = "com.mysql.cj.jdbc.Driver";
    private final static String url = "jdbc:mysql://localhost:3306/scau?useUnicode=true&characterEncoding=utf8&useSSL=true";
    private final static String user = "root";
    private final static String password = "123456";

    //初始化连接参数,从配置文件里获得
    public static void init(){
    }


    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return connection;
    }
    /**
     * 查询操作
     */
    public static ResultSet execute(Connection connection,PreparedStatement pstm,ResultSet rs,
                                    String sql,Object[] params) throws Exception{
        pstm = connection.prepareStatement(sql);
        for(int i = 0; i < params.length; i++){
            pstm.setObject(i+1, params[i]);
        }
        rs = pstm.executeQuery();
        return rs;
    }
    /**
     * 更新操作
     */
    public static int execute(Connection connection,PreparedStatement pstm,
                              String sql,Object[] params) throws Exception{
        int updateRows = 0;
        pstm = connection.prepareStatement(sql);
        for(int i = 0; i < params.length; i++){
            pstm.setObject(i+1, params[i]);
        }
        updateRows = pstm.executeUpdate();
        return updateRows;
    }

    /**
     * 释放资源
     */
    public static boolean closeResource(Connection connection,PreparedStatement pstm,ResultSet rs){
        boolean flag = true;
        if(rs != null){
            try {
                rs.close();
                rs = null;//GC回收
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                flag = false;
            }
        }
        if(pstm != null){
            try {
                pstm.close();
                pstm = null;//GC回收
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                flag = false;
            }
        }
        if(connection != null){
            try {
                connection.close();
                connection = null;//GC回收
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                flag = false;
            }
        }

        return flag;
    }

}

