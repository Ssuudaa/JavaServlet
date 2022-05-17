package com.gk.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/updateuser")
public class UpdateUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;character=utf-8");
        String Id = req.getParameter("id");
        String userId = req.getParameter("userid");
        String userPwd = req.getParameter("password");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/xsgl";
            String user = "root";
            String password = "123456";
            Connection connection = DriverManager.getConnection(url,user,password);
            Statement stm = connection.createStatement();
            String sql = "update user set sid ='"+userId+"',password ='"+userPwd+"' where id ='"+Id+"'";
            Integer num =stm.executeUpdate(sql);
            if (num >= 1){
                HttpSession session = req.getSession();
                session.removeAttribute("id");
                resp.getWriter().write("<script>alert('数据已修改...');location='login.jsp'</script>");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
