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

public class ForgotSerlvet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("finding password");

        String userCode = req.getParameter("userCode");

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Object[] params = null;

        Connection connection = BaseDao.getConnection();

        if(connection!=null){
            if(userCodeExist(params,userCode,resultSet,connection,preparedStatement)){
                String sql = "select * from secret_protection where id=?";
                params = new Object[]{userCode};
                try {
                    resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                    if(resultSet.next()) {
                        req.setAttribute("question1", resultSet.getString("question_one"));
                        req.setAttribute("question2", resultSet.getString("question_two"));
                        req.setAttribute("question3", resultSet.getString("question_three"));
                        System.out.println( resultSet.getString("question_one"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                req.setAttribute("userCode",userCode);
                req.getRequestDispatcher("forgot-answer.jsp").forward(req,resp);
            }
            else {
                req.setAttribute("NotUserCode","抱歉，该用户未设置密保问题");
                req.getRequestDispatcher("forgot-pws.jsp").forward(req,resp);
            }
        }
        BaseDao.closeResource(connection, preparedStatement, resultSet);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    private boolean userCodeExist(Object[] params,String userCode, ResultSet resultPsw,Connection connection,PreparedStatement preparedStatement){
        String sql = "select * from secret_protection where id=?";
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
