package com.xiaogang.sm.controller;

import com.xiaogang.sm.entity.Log;
import com.xiaogang.sm.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller("logController")
public class LogController {

    @Autowired
    private LogService logService;

    public void operationLog(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Log> list =  logService.getOperationLog();
        req.setAttribute("LIST", list);
        req.setAttribute("TYPE","操作");
        req.getRequestDispatcher("../log_list.jsp").forward(req,resp);
    }

    public void loginLog(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        List<Log> list =  logService.getLoginLog();
        req.setAttribute("LIST", list);
        req.setAttribute("TYPE","登录");
        req.getRequestDispatcher("../log_list.jsp").forward(req,resp);
    }
    public void systemLog(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        List<Log> list =  logService.getSystemLog();
        req.setAttribute("LIST", list);
        req.setAttribute("TYPE","系统");
        req.getRequestDispatcher("../log_list.jsp").forward(req,resp);
    }
}
