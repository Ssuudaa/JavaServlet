package com.gk.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
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
        String Yzm1 = req.getParameter("yzm1");
        String Yzm2 = req.getParameter("yzm2");
        if (!Yzm1.equals(Yzm2)) {
            resp.getWriter().write("<script>alert('验证码不一致...');location='login.jsp'</script>");
            return;
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String user = "root";
            String password = "123456";
            String url = "jdbc:mysql://localhost:3306/xsgl";
            Connection connection = DriverManager.getConnection(url, user, password);
            String sql = "select * from user where sid ='"+userId+"' and password = '"+userPwd+"'";
            Statement stm =connection.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()){
                HttpSession session = req.getSession();
                session.setAttribute("id",userId);
                resp.getWriter().write("<script>alert('欢迎回来...');location='/index'</script>");
            }else {
                resp.getWriter().write("<script>alert('账号或者密码错误...');location='login.jsp'</script>");
                return;
            }
            rs.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
