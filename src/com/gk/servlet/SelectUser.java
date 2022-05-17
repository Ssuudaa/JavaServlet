package com.gk.servlet;

import com.gk.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
@WebServlet("/selectuser")
public class SelectUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           String Id = req.getParameter("id");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/xsgl";
            String user = "root";
            String password = "123456";
            Connection connection = DriverManager.getConnection(url,user,password);
            Statement stm = connection.createStatement();
            String sql = "select * from user where id = '"+Id+"'";
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()){
                User user1 = new User(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getDate(4) );
                HttpSession session =req.getSession();
                session.setAttribute("user",user1);
                resp.sendRedirect("updateuser.jsp");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
