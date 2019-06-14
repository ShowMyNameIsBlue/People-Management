package com.xiaogang.sm.controller;

import com.xiaogang.sm.entity.Department;
import com.xiaogang.sm.entity.Staff;
import com.xiaogang.sm.service.DepartmentService;
import com.xiaogang.sm.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller("staffController")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @Autowired
    private DepartmentService departmentService;

    public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Staff> list = staffService.getAll();

        req.setAttribute("LIST", list);

        req.getRequestDispatcher("../staff_list.jsp").forward(req, resp);
    }

    public void toAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         List<Department> list = departmentService.getAll();
        req.setAttribute("DLIST",list);
        req.getRequestDispatcher("../staff_add.jsp").forward(req, resp);
    }

    public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String account = req.getParameter("account");
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String info = req.getParameter("info");
        String idNumber = req.getParameter("idNumber");
        Date bornDate = null;
        try {
            bornDate = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("bornDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Integer did = Integer.parseInt(req.getParameter("did"));

        Staff staff = new Staff();
        staff.setInfo(info);
        staff.setBornDate(bornDate);
        staff.setIdNumber(idNumber);
        staff.setDid(did);
        staff.setAccount(account);
        staff.setName(name);
        staff.setSex(sex);
        staff.setPassword("123456");
        staff.setStatus("正常");
        staffService.add(staff);
        resp.sendRedirect("list.do");
    }

    public void toEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        Staff staff = staffService.get(id);
        req.setAttribute("STA",staff);
        List<Department> list = departmentService.getAll();
        req.setAttribute("DLIST",list);
        req.getRequestDispatcher("../staff_edit.jsp").forward(req, resp);
    }

    public void edit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        String account = req.getParameter("account");
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String info = req.getParameter("info");
        String idNumber = req.getParameter("idNumber");
        Date bornDate = null;
        try {
            bornDate = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("bornDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Integer did = Integer.parseInt(req.getParameter("did"));

        Staff staff = staffService.get(Integer.parseInt(id));
        staff.setInfo(info);
        staff.setBornDate(bornDate);
        staff.setIdNumber(idNumber);
        staff.setDid(did);
        staff.setAccount(account);
        staff.setName(name);
        staff.setSex(sex);

        staffService.edit(staff);
        resp.sendRedirect("list.do");
    }

    public void remove(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");

        staffService.remove(Integer.parseInt(id));

        resp.sendRedirect("list.do");
    }


    public void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        Staff staff = staffService.get(Integer.parseInt(id));

        req.setAttribute("STA", staff);

        req.getRequestDispatcher("../staff_detail.jsp").forward(req, resp);
    }
}













