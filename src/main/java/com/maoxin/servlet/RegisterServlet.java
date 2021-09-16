package com.maoxin.servlet;

import com.maoxin.dao.BaseDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Register");
        String userName = req.getParameter("userName");
        String userCode = req.getParameter("userCode");
        String userPassword = req.getParameter("userPassword");

        String studentPassword = null;
        PreparedStatement preparedStatement = null;
        int resultSet = 0;
        ResultSet resultPsw = null;
        Object[] params = null;
        String sql = null;

        Connection connection = BaseDao.getConnection();



        if(userName!=null&&userCode!=null&&userPassword!=null){
            if(connection!=null){
                if(userCodeExist(params,userCode,resultPsw,connection,preparedStatement)){
                    req.setAttribute("userCodeExist","输入的学号已经存在");
                    req.getRequestDispatcher("register.jsp").forward(req,resp);
                }
                else {
                    sql = "INSERT INTO student VALUES (?, ?, ?,null,null,null,null)";
                    params = new Object[]{userCode, userPassword, userName};
                    try {
                        resultSet = BaseDao.execute(connection,preparedStatement,sql,params);
                        //Connection connection,PreparedStatement pstm,
                        //                              String sql,Object[] params
                        if(resultSet!= 0){
                            System.out.println("success!");
                            resp.sendRedirect("register-success.jsp");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }

        }
        BaseDao.closeResource(connection, preparedStatement, resultPsw);
     }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    private boolean userCodeExist(Object[] params,String userCode, ResultSet resultPsw,Connection connection,PreparedStatement preparedStatement){
        String sql = "select * from student where id=?";
        params = new Object[]{userCode};
        try {
            resultPsw = BaseDao.execute(connection,preparedStatement,resultPsw,sql,params);
            if(resultPsw.next()){
                System.out.println("已存在该用户");
                return true;
            }
            else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
