package com.gk.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginout")
public class LoginOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;character=utf-8");
        HttpSession session = req.getSession();
        if (session.getAttribute("id") != null);{
            session.removeAttribute("id");
            resp.getWriter().write("<script>alert('已退出登录');location='login.jsp'</script>");
        }
    }
}
