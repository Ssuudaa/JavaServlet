package com.gk.servlet;

import com.gk.entity.User;
import sun.awt.geom.AreaOp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/index")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;character=utf-8");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String path = "jdbc:mysql://localhost:3306/xsgl";
            String userid = "root";
            String password = "123456";
            Connection connection = DriverManager.getConnection(path,userid,password);
            String sql = "select * from user";
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            List<User> list = new ArrayList<>();
            User user = null;
            while (rs.next()){
                user =new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4));
                list.add(user);
            }
            HttpSession session = req.getSession();
            session.setAttribute("list",list);
            resp.sendRedirect("index.jsp");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
