<%@ page import="com.maoxin.util.Constants" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.maoxin.pojo.Course" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.maoxin.pojo.StuCourse" %>
<%@ page import="com.maoxin.dao.BaseDao" %>
<%@ page import="java.sql.Connection" %><%--
  Created by IntelliJ IDEA.
  User: tangmaoxin
  Date: 2021/9/23
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成绩查看</title>
</head>
<body>
<body>
<div style="width: 100%; height: 110px;background-color: #fff; display: flex;align-items: center; ">
    <img  style="width: 20%;height: 63%;" src="static/picture/SCAU_TAG_Blue.png" alt="">
    <text style="font-size: 30px;color: black">教务选课系统</text>
    <div>
        <text style="padding-left: 520px; font-size: 20px;color: black" >下午好！</text>
        <text style="padding-left: 2px; font-size: 20px;color:#ed4b71"><%=Constants.USER_NAME%></text>
        <text  style=" font-size: 20px;color:black">，欢迎您！</text>
        <text style="color: #00C5CD">退出</text>
    </div>
</div>
<div style="width: 100%;height: 50px;background-color: #22233C;display: flex;align-items: center;">
    <a style="color: white; padding-left:220px;" href="${pageContext.request.contextPath}/course-select.jsp">选课</a>
    <a style="color: white; padding-left:220px;" href="${pageContext.request.contextPath}/personal-timetable.jsp">个人课表</a>
    <a style="color: brown; padding-left:220px;" >成绩查看</a>
    <a style="color: white; padding-left:220px;" href="${pageContext.request.contextPath}/password-change.jsp">修改密码</a>
</div>

<table border="1">
    <tr>
        <th style="width: 90px;">课程名称</th>
        <th style="width: 90px;">授课老师</th>
        <th>成绩</th>
    </tr>
    <%
        System.out.println("select course");

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Object[] params = null;
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<StuCourse> stuCourses = new ArrayList<>();
        Connection connection = BaseDao.getConnection();

        if(connection!=null){
            String sql = "SELECT * FROM stucourse where student_num = ?";
            params = new Object[]{Constants.USER_ID};
            try {
                resultSet = BaseDao.execute(connection,preparedStatement,resultSet,sql,params);
                while(resultSet.next()){
                    StuCourse stuCourse = new StuCourse();
                    stuCourse.setId(resultSet.getInt("id"));
                    stuCourse.setCourse_num(resultSet.getString("course_num"));
                    stuCourse.setStudent_num(resultSet.getString("student_num"));
                    stuCourse.setGrade(resultSet.getInt("grade"));
                    stuCourses.add(stuCourse);

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        preparedStatement = null;
        resultSet = null;
        params = null;

        if(connection!=null){
            String sql = "SELECT * FROM course";
            params = new Object[]{};
            try {
                resultSet = BaseDao.execute(connection,preparedStatement,resultSet,sql,params);
                while(resultSet.next()){
                    Course course = new Course();
                    course.setCourseNum(resultSet.getString("course_num"));
                    course.setCourseDesc(resultSet.getString("course_desc"));
                    course.setCourseName(resultSet.getString("course_name"));
                    course.setCourseTea(resultSet.getString("course_tea"));
                    courses.add(course);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        int j;
        for (Course cours : courses) {
            for (j = 0; j < stuCourses.size(); j++) {

                if (cours.getCourseNum().equals(stuCourses.get(j).getCourse_num())) {
                    out.write("    <tr id=\"" + cours.getCourseNum() + "\">\n" +
                            "      <td >" + cours.getCourseName() + "</td>\n" +
                            "      <td >" + cours.getCourseTea() + "</td>\n" +
                            "      <td >" + stuCourses.get(j).getGrade() + "</td>\n" +
                            "    </tr>");
                    break;
                }

            }
        }

        BaseDao.closeResource(connection, preparedStatement, resultSet);

    %>

</table>

</body>
</body>
</html>
