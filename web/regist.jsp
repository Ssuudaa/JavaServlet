<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/11/1
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body>
<form action="/regist" method="post">
    账号：<input type="text" name="userid" placeholder="请输入学号..." required>
    <br>
    密码：<input type="password" name="userpwd" placeholder="请输入密码..." required>
    <br>
    <input type="submit" value="注 册">
    <input type="reset" value="重 置">
</form>
</body>
</html>
