package com.xiaogang.sm.dao;

import com.xiaogang.sm.entity.Staff;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("staffDao")
public interface StaffDao {
    void insert(Staff staff);
    void delete(Integer id);
    void update(Staff staff);
    Staff selectById(Integer id);
    List<Staff> selectAll();
}
