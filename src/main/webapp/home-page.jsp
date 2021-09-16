<%@ page import="com.maoxin.util.Constants" %><%--
  Created by IntelliJ IDEA.
  User: tangmaoxin
  Date: 2021/9/23
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>华南农业大学教务选课系统</title>
</head>
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
    <a style="color: white; padding-left:220px;"  href="${pageContext.request.contextPath}/course-select.jsp" >选课</a>
    <a style="color: white; padding-left:220px;" href="${pageContext.request.contextPath}/personal-timetable.jsp">个人课表</a>
    <a style="color: white; padding-left:220px;" href="${pageContext.request.contextPath}/score-view.jsp">成绩查看</a>
    <a style="color: white; padding-left:220px;" href="${pageContext.request.contextPath}/password-change.jsp">修改密码</a>
</div>
<a style="color:#22233C; ">${changeSuccess}</a>

</body>
</html>
