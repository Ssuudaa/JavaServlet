<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/11/22
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/updateuser" method="post">
    <tr>
        <td>序号：</td>
        <td><input type="text" name="id" value="${user.id}" readonly></td>
    </tr>
    <br>
    <tr>
        <td>账号：</td>
        <td><input type="text" name="userid" value="${user.sid}"></td>
    </tr>
    <br>
    <tr>
        <td>密码：</td>
        <td><input type="text" name="password" value="${user.password}"></td>
    </tr>
    <br>
    <tr>
        <td>注册日期：</td>
        <td><input type="text" value="${user.ctime}"></td>
    </tr>
    <br>
    <input type="submit" value="修改">
</form>
</body>
</html>
