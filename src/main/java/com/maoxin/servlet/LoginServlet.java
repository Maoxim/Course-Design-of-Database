package com.maoxin.servlet;

import com.maoxin.dao.BaseDao;
import com.maoxin.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Login");
        String userCode = req.getParameter("userCode");
        String  userPassword = req.getParameter("userPassword");

        String studentPassword = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        Connection connection = BaseDao.getConnection();

        if(connection!=null){
            String sql = "select * from student where id=?";
            Object[] params = {userCode};
            try {
                resultSet = BaseDao.execute(connection,preparedStatement,resultSet,sql,params);
                if(resultSet.next()){
                    studentPassword = resultSet.getString("password");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if(studentPassword!=null){
            if(studentPassword.equals(userPassword)){
                    System.out.println("登陆成功");
                    req.getSession().setAttribute(Constants.USER_SESSION,userCode);
                    req.setAttribute("userName",userCode);
                    req.getRequestDispatcher("blank.jsp").forward(req, resp);
                }
                else {
                    System.out.println("密码错误");
                    req.setAttribute("errorPassword","密码错误，请重新输入");
                    req.getRequestDispatcher("index.jsp").forward(req,resp);
                }
            }
            else {
                System.out.println("用户名错误");
            req.setAttribute("errorPassword","用户名错误，请重新输入");
            req.getRequestDispatcher("index.jsp").forward(req,resp);
            }

        BaseDao.closeResource(connection, preparedStatement, resultSet);

        }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            doGet(req,resp);
    }
}
