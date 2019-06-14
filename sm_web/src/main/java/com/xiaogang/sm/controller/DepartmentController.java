package com.xiaogang.sm.controller;


import com.xiaogang.sm.entity.Department;
import com.xiaogang.sm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller("departmentController")
public class DepartmentController{

    @Autowired
    private DepartmentService departmentService;
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Department> list = departmentService.getAll();
        request.setAttribute("LIST",list);
        request.getRequestDispatcher("../department_list.jsp").forward(request,response);
    }

    public void toAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("../department_add.jsp").forward(req,resp);
    }

    public void add(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        String name =  req.getParameter("name");
        String address = req.getParameter("address");

        Department  department = new Department();
        department.setName(name);
        department.setAddress(address);

        departmentService.add(department);
        resp.sendRedirect("list.do");
    }

    public void toEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        Department department = departmentService.get(Integer.parseInt(id));

        req.setAttribute("DEP",department);

        req.getRequestDispatcher("../department_edit.jsp").forward(req,resp);
    }

    public void edit(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        String  name =  req.getParameter("name");
        String address = req.getParameter("address");

        Department  department = new Department();
        department.setId(Integer.parseInt(id));
        department.setName(name);
        department.setAddress(address);

        departmentService.edit(department);

        resp.sendRedirect("list.do");
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");

        departmentService.remove(Integer.parseInt(id));

        resp.sendRedirect("list.do");
    }
}



















