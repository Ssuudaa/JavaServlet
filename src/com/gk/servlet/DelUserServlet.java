package com.gk.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/deluser")
public class DelUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;character=utf-8");
        String Id = req.getParameter("id");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/xsgl";
            String user = "root";
            String password = "123456";
            Connection connection=DriverManager.getConnection(url,user,password);
            Statement stm = connection.createStatement();
            String sql = "delete from user where id = '"+Id+"'";
            Integer num = stm.executeUpdate(sql);
            if (num >= 1){
                resp.getWriter().write("<script>alert('数据已修改...');location='/index'</script>");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}
