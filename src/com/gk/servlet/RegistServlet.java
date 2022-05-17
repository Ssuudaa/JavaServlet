package com.gk.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/regist")
public class RegistServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.setCharacterEncoding("utf-8");
       resp.setCharacterEncoding("utf-8");
       resp.setContentType("text/html;character=utf-8");
       String userId = req.getParameter("userid");
       String userPwd = req.getParameter("userpwd");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String user = "root";
            String password = "123456";
            String url = "jdbc:mysql://localhost:3306/xsgl";
            Connection connection = DriverManager.getConnection(url,user,password);
            String sql = "insert into user(sid,password) values('"+userId+"','"+userPwd+"')";
            Statement stm = connection.createStatement();
            Integer num = stm.executeUpdate(sql);
            if (num > 0){
                resp.getWriter().write("<script>alert('注册成功，请登录...');location='login.jsp'</script>");

            }else {
                resp.getWriter().write("<script>alert('注册失败，请重试...');location='regist.jsp'</script>");

            }
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
