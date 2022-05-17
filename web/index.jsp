<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/11/1
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <body>
  <%
    String zh = (String) session.getAttribute("id");
    if(zh == "" || zh == null){
      response.sendRedirect("login.jsp");
      return;
    }
  %>
  <script>
    function del(){
      var flag = confirm("确定删除吗？");
      return flag;
    }
  </script>
  <table border="1" cellpadding="0" cellspacing="0" align="center" width="400px" height="400px" bgcolor="#ff1493">
    <tr>
      <th>序号</th>
      <th>账号</th>
      <th>密码</th>
      <th>注册日期</th>
      <th>操作</th>
    </tr>
    <c:forEach items="${list}" var="user">
      <tr>
        <td>${user.id}</td>
        <td>${user.sid}</td>
        <td>${user.password}</td>
        <td>${user.ctime}</td>
        <td><a href="/selectuser?id=${user.id}">修改</a> / <a href="/deluser?id=${user.id}" onclick="return del();">删除</a></td>
      </tr>
    </c:forEach>
  </table>
  <p align="center"><a href="/loginout">退出登录</a></p>
  </body>
</html>
