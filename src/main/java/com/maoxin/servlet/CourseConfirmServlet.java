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
import java.sql.ResultSet;
import java.util.UUID;

public class CourseConfirmServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String courseNum = req.getParameter("courseNum");
        String btn = req.getParameter("btn");

        PreparedStatement preparedStatement = null;
        int resultSet;
        Object[] params = null;

        Connection connection = BaseDao.getConnection();

        if(connection!=null){
            if(btn.equals("select")){
                String sql = "INSERT INTO stucourse (student_num,course_num) VALUES ( ?,?)";
                params = new Object[]{Constants.USER_ID, courseNum};
                try {
                    resultSet = BaseDao.execute(connection,preparedStatement,sql,params);
                    //Connection connection,PreparedStatement pstm,
                    //                              String sql,Object[] params
                    if(resultSet!= 0){
                        System.out.println("success!");
                        resp.sendRedirect("course-select.jsp");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            else if(btn.equals("drop")){
                String sql = "DELETE FROM stucourse WHERE course_num = ? and student_num = ?";
                params = new Object[]{  courseNum, Constants.USER_ID};
                try {
                    resultSet = BaseDao.execute(connection,preparedStatement,sql,params);
                    //Connection connection,PreparedStatement pstm,
                    //                              String sql,Object[] params
                    if(resultSet!= 0){
                        System.out.println("success!");
                        resp.sendRedirect("course-select.jsp");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
        BaseDao.closeResource(connection, preparedStatement, null);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
