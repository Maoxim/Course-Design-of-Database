<%@ page import="com.maoxin.util.Constants" %><%--
  Created by IntelliJ IDEA.
  User: tangmaoxin
  Date: 2021/9/23
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <meta name="description" content="">
  <meta name="keywords" content="">
  <meta name="author" content="">
  <meta name="MobileOptimized" content="320">
  <!--Start Style -->
  <link rel="stylesheet" type="text/css" href="static/css/fonts.css">
  <link rel="stylesheet" type="text/css" href="static/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="static/css/auth.css">
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
  <a style="color: white; padding-left:220px;" href="${pageContext.request.contextPath}/score-view.jsp">成绩查看</a>
  <a style="color: brown; padding-left:220px;" >修改密码</a>
</div>

<div style="width: 100%; height: 300px;padding-top: 30px;"  >
<div style="width:50%;margin: 0 auto;">
<form action="${pageContext.request.contextPath}/changePassword.do" name="actionForm" id="actionForm" method="post">
  <a style="color:brown;">${different}</a>
  <div class="ad-auth-feilds">
    <input type="password" placeholder="输入新的密码" class="ad-input" name="userPassword" required/>
    <div class="ad-auth-icon">
      <svg xmlns="http://www.w3.org/2000/svg" viewbox="0 0 482.8 482.8"><path d="M395.95,210.4h-7.1v-62.9c0-81.3-66.1-147.5-147.5-147.5c-81.3,0-147.5,66.1-147.5,147.5c0,7.5,6,13.5,13.5,13.5    s13.5-6,13.5-13.5c0-66.4,54-120.5,120.5-120.5c66.4,0,120.5,54,120.5,120.5v62.9h-275c-14.4,0-26.1,11.7-26.1,26.1v168.1    c0,43.1,35.1,78.2,78.2,78.2h204.9c43.1,0,78.2-35.1,78.2-78.2V236.5C422.05,222.1,410.35,210.4,395.95,210.4z M395.05,404.6    c0,28.2-22.9,51.2-51.2,51.2h-204.8c-28.2,0-51.2-22.9-51.2-51.2V237.4h307.2L395.05,404.6L395.05,404.6z" data-original="#000000" class="active-path" data-old_color="#000000" fill="#9abeed"></path><path d="M241.45,399.1c27.9,0,50.5-22.7,50.5-50.5c0-27.9-22.7-50.5-50.5-50.5c-27.9,0-50.5,22.7-50.5,50.5    S213.55,399.1,241.45,399.1z M241.45,325c13,0,23.5,10.6,23.5,23.5s-10.5,23.6-23.5,23.6s-23.5-10.6-23.5-23.5    S228.45,325,241.45,325z" data-original="#000000" class="active-path" data-old_color="#000000" fill="#9abeed"></path></svg>
    </div>
  </div>

  <div class="ad-auth-feilds">
    <input type="password" placeholder="请再次输入密码" class="ad-input" name="userPasswordAgain" required/>
    <div class="ad-auth-icon">
      <svg xmlns="http://www.w3.org/2000/svg" viewbox="0 0 482.8 482.8"><path d="M395.95,210.4h-7.1v-62.9c0-81.3-66.1-147.5-147.5-147.5c-81.3,0-147.5,66.1-147.5,147.5c0,7.5,6,13.5,13.5,13.5    s13.5-6,13.5-13.5c0-66.4,54-120.5,120.5-120.5c66.4,0,120.5,54,120.5,120.5v62.9h-275c-14.4,0-26.1,11.7-26.1,26.1v168.1    c0,43.1,35.1,78.2,78.2,78.2h204.9c43.1,0,78.2-35.1,78.2-78.2V236.5C422.05,222.1,410.35,210.4,395.95,210.4z M395.05,404.6    c0,28.2-22.9,51.2-51.2,51.2h-204.8c-28.2,0-51.2-22.9-51.2-51.2V237.4h307.2L395.05,404.6L395.05,404.6z" data-original="#000000" class="active-path" data-old_color="#000000" fill="#9abeed"></path><path d="M241.45,399.1c27.9,0,50.5-22.7,50.5-50.5c0-27.9-22.7-50.5-50.5-50.5c-27.9,0-50.5,22.7-50.5,50.5    S213.55,399.1,241.45,399.1z M241.45,325c13,0,23.5,10.6,23.5,23.5s-10.5,23.6-23.5,23.6s-23.5-10.6-23.5-23.5    S228.45,325,241.45,325z" data-original="#000000" class="active-path" data-old_color="#000000" fill="#9abeed"></path></svg>
    </div>
  </div>

  <div class="ad-auth-btn" style="padding-left: 250px">
    <a  onclick="document.getElementById('actionForm').submit();return false;" style="color: white" class="ad-btn ad-login-member">提 交</a>
  </div>

</form>
</div>
</div>

</body>
</body>
</html>
