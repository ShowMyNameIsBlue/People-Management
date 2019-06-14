package com.xiaogang.sm.service;

import com.xiaogang.sm.entity.Staff;

import java.util.List;

public interface StaffService {

    void remove(Integer id);
    void add(Staff staff);
    void edit(Staff staff);
    Staff get(Integer id);
    List<Staff> getAll();
}
