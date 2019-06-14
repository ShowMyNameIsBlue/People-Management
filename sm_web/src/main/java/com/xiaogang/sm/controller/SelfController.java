package com.xiaogang.sm.controller;

import com.xiaogang.sm.entity.Staff;
import com.xiaogang.sm.service.SelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller("selfController")
public class SelfController {

    @Autowired
    private SelfService selfService;

    public void toLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("account");

        String password = req.getParameter("password");

        Staff staff = selfService.login(account, password);

        if (staff == null) {

            resp.sendRedirect("toLogin.do");
        } else {
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("STA", staff);
            req.getRequestDispatcher("main.do").forward(req, resp);
        }

    }

    public void logOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession httpSession = req.getSession();

        httpSession.setAttribute("STA", null);

        resp.sendRedirect("toLogin.do");
    }

    public void main(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    public void info(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("../info.jsp").forward(req, resp);
    }

    public void toChangePassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("../change_password.jsp").forward(req, resp);
    }

    public void changePassword(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String password = req.getParameter("password");
        String password1 = req.getParameter("password1");
        HttpSession session = req.getSession();
        Staff staff = (Staff) session.getAttribute("USER");
        if (!staff.getPassword().equals(password)) {
            resp.sendRedirect("toChangePassword.do");
        } else {
            selfService.changePassword(staff.getId(), password1);
            //response.sendRedirect("../logout.do");
            resp.getWriter().print("<script type=\"text/javascript\">parent.location.href=\"../logout.do\"</script>");
        }
    }
}

