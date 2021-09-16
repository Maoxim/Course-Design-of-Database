<%--
  Created by IntelliJ IDEA.
  User: tangmaoxin
  Date: 2021/9/11
  Time: 01:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>华南农业大学教务选课系统</title>

    <style>
        .menu_list {
            width: 275px;
            margin: 0;
        }

        .menu_head {
            height: 47px;
            line-height: 47px;
            padding-left: 38px;
            font-size: 14px;
            color: #525252;
            cursor: pointer;
            border: 1px solid #f1f1f1;
            position: relative;
            margin: 0px;
            font-weight: bold;
            background: #47A0F6;
        }

        .menu_list .current {
            background: #47A0F6;
        }

        .menu_nva {
            line-height: 38px;
            border-left: 1px solid #47A0F6;
            backguound: #fff;
            border-right: 1px solid#47A0F6;
        }

        .menu_nva a {
            display: block;
            height: 38px;
            line-height: 38px;
            padding-left: 38px;
            color: #777777;
            background: #fff;
            text-decoration: none;
            border-bottom: 1px solid #47A0F6;
        }

        .menu_nva a:hover {
            text-decoration: none;
        }
    </style>

</head>
<body>
<div style="width: 100%; height: 110px;background-color: #47A0F6; display: flex;align-items: center; ">
    <img  style="width: 20%;height: 63%;" src="static/picture/SCAU_TAG_Blue.png" alt="">
    <text style="font-size: 30px;color: white">教务选课系统</text>
    <div>
        <text style="padding-left: 650px; font-size: 20px;color: white" >下午好！</text>
        <text style="padding-left: 2px; font-size: 20px;color:#ed4b71">${userName}</text>
        <text  style=" font-size: 20px;color:white">，欢迎您！</text>
        <button style="background-color: #00C5CD">退出</button>
    </div>
</div>
<!-- html  start-->

<div id="firstpaneDiv" class="menu_list">
    <h3 class="menu_head current">系统管理</h3>
    <div style="display:block" class="menu_nva">
        <a href="#">菜单管理</a>
        <a href="#">账户管理</a>
        <a href="#">日志管理</a>
        <a href="#">角色管理</a>
        <a href="#">编码管理</a>
        <a href="#">操作日志</a>
        <a href="#">流程管理</a>
    </div>
    <h3 class="menu_head">xxx菜单1</h3>
    <div style="display:none" class="menu_nva">
        <a href="#">用例1xx</a>
        <a href="#">用例2xx</a>
        <a href="#">用例3xx</a>
        <a href="#">用例4xx</a>
        <a href="#">用例5xx</a>
        <a href="#">用例6xx</a>
        <a href="#">用例7xx</a>
        <a href="#">用例8xx</a>
    </div>
    <h3 class="menu_head">xxx菜单2</h3>
    <div style="display:none" class="menu_nva">
        <a href="#">用例1xx</a>
        <a href="#">用例2xx</a>
        <a href="#">用例3xx</a>
        <a href="#">用例4xx</a>
        <a href="#">用例5xx</a>
        <a href="#">用例6xx</a>
        <a href="#">用例7xx</a>
        <a href="#">用例8xx</a>
    </div><h3 class="menu_head">xxx菜单3</h3>
    <div style="display:none" class="menu_nva">
        <a href="#">用例1xx</a>
        <a href="#">用例2xx</a>
        <a href="#">用例3xx</a>
        <a href="#">用例4xx</a>
        <a href="#">用例5xx</a>
        <a href="#">用例6xx</a>
        <a href="#">用例7xx</a>
        <a href="#">用例8xx</a>
    </div><h3 class="menu_head">xxx菜单4</h3>
    <div style="display:none" class="menu_nva">
        <a href="#">用例1xx</a>
        <a href="#">用例2xx</a>
        <a href="#">用例3xx</a>
        <a href="#">用例4xx</a>
        <a href="#">用例5xx</a>
        <a href="#">用例6xx</a>
        <a href="#">用例7xx</a>
        <a href="#">用例8xx</a>
    </div>
    <h3 class="menu_head">xxx菜单5</h3>
    <div style="display:none" class="menu_nva">
        <a href="#">用例1xx</a>
        <a href="#">用例2xx</a>
        <a href="#">用例3xx</a>
        <a href="#">用例4xx</a>
        <a href="#">用例5xx</a>
        <a href="#">用例6xx</a>
        <a href="#">用例7xx</a>
        <a href="#">用例8xx</a>


    </div>
</div>

<!-- html  end-->

<!-- script  代码-->

<script src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script>
    $(document).ready(function(){
        $("#firstpaneDiv .menu_nva:eq(0)").show();
        $("#firstpaneDiv h3.menu_head").click(function(){
            $(this).addClass("current").next("div.menu_nva").slideToggle(200).siblings("div.menu_nva").slideUp("slow");
            $(this).siblings().removeClass("current");
        });
        $("#secondpane .menu_nva:eq(0)").show();
        $("#secondpane h3.menu_head").mouseover(function(){
            $(this).addClass("current").next("div.menu_nva").slideDown(400).siblings("div.menu_nva").slideUp("slow");
            $(this).siblings().removeClass("current");
        });
    });
</script>
</body>
</html>