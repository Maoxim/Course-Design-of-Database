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

public class CheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("check password!");

        String answer1 = req.getParameter("answer1");
        String answer2 = req.getParameter("answer2");
        String answer3 = req.getParameter("answer3");
        String userCode = req.getParameter("userCode");
        String question1;
        String question2;
        String question3;


        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Object[] params = null;

        Connection connection = BaseDao.getConnection();

        if(connection!=null){
            String sql = "select * from secret_protection where id=?";
            params = new Object[]{userCode};

            try {
                resultSet = BaseDao.execute(connection,preparedStatement,resultSet,sql,params);
                if(resultSet.next()){
                    String answerData1 = resultSet.getString("answer_one");
                    String answerData2 = resultSet.getString("answer_two");
                    String answerData3 = resultSet.getString("answer_three");
                    question1 = resultSet.getString("question_one");
                    question2 = resultSet.getString("question_two");
                    question3 = resultSet.getString("question_three");

                    if(answer1.equals(answerData1)&&answer2.equals(answerData2)&&answer3.equals(answerData3)){
                        System.out.println("right");
                        req.setAttribute("userCode",userCode);
                        req.getRequestDispatcher("reset-pws.jsp").forward(req,resp);
                    }

                    else {
                        System.out.println("error");
                        req.setAttribute("error","输入的答案有误，请重新输入");
                        req.setAttribute("question1",question1);
                        req.setAttribute("question2",question2);
                        req.setAttribute("question3",question3);
                        req.getRequestDispatcher("forgot-answer.jsp").forward(req,resp);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
        BaseDao.closeResource(connection, preparedStatement, resultSet);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
