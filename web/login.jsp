<%@ page import="javax.swing.*" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/11/8
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生登陆</title>
</head>
<body>
<%
  String[] s ={"a","b","c","d","e","f","g","h","i","j","k","0","1","2","3","4"};
  String yzm = "";
  for (int i = 0; i < 4 ; i++){
    yzm = yzm +s[(int)(Math.random()*16)];
  }

%>
<form action="/login" method="post">
  账号：<input type="text" name="userid" placeholder="请输入学号..." required>
  <br>
  密码：<input type="password" name="userpwd" placeholder="请输入密码..." required>
  <br>
  验证码：<input type="text" name="yzm1" required style="width: 80px">
  <input type="text" name="yzm2" value="<%=yzm%>" readonly style="width: 80px;border: none;outline: none">
  <br>
  <br>
  <input type="submit" value="登 录">
  <input type="reset" value="重 置">
</form>
没有账号？点击<a href="regist.jsp">注册</a>
</body>
</html>
