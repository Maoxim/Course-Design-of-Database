package com.maoxin.servlet;

import com.maoxin.dao.BaseDao;
import com.maoxin.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ChangePasswordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("change");

        String password = req.getParameter("userPassword");
        String password1 = req.getParameter("userPasswordAgain");
        String userCode = Constants.USER_ID;

        if(password.equals(password1)){
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
                        req.setAttribute("changeSuccess","密码修改成功！");
                        req.getRequestDispatcher("home-page.jsp").forward(req,resp);;
                    }
                    else {
                        System.out.println("update error");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                BaseDao.closeResource(connection, preparedStatement, null);
            }

        }
        else {
            req.setAttribute("different","两次输入的密码不一致，请重新输入密码");
            req.getRequestDispatcher("password-change.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
