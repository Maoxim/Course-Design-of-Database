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

public class ResetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("password");
        String passwordAgain = req.getParameter("password-again");
        String userCode = req.getParameter("userCode");
        System.out.println(userCode);

        if(password.equals(passwordAgain)){
            PreparedStatement preparedStatement = null;
            int resultSet = 0 ;
            Object[] params = null;

            Connection connection = BaseDao.getConnection();

            if(connection!=null){
                String sql= "update student set password =? where id=?";
                params = new Object[]{password,userCode};
                try {
                    resultSet = BaseDao.execute(connection,preparedStatement,sql,params);
                    if(resultSet!=0){
                        resp.sendRedirect("index.jsp");
                    }
                    else {
                        System.out.println("update error");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
        else {
            req.setAttribute("different","两次输入的密码不一致，请重新输入密码");
            req.getRequestDispatcher("reset-pws.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
