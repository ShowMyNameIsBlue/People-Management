package com.xiaogang.sm.service.impl;

import com.xiaogang.sm.dao.StaffDao;
import com.xiaogang.sm.entity.Staff;
import com.xiaogang.sm.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("staffService")
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffDao staffDao;

    @Override
    public void remove(Integer id) {
        staffDao.delete(id);
    }

    @Override
    public void add(Staff staff) {
        staffDao.insert(staff);
    }

    @Override
    public void edit(Staff staff) {
        staffDao.update(staff);
    }

    @Override
    public Staff get(Integer id) {
        return staffDao.selectById(id);
    }

    @Override
    public List<Staff> getAll() {
        return staffDao.selectAll();
    }
}
