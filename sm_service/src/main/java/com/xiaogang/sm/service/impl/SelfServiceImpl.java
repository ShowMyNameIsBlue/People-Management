package com.xiaogang.sm.service.impl;

import com.xiaogang.sm.dao.SelfDao;
import com.xiaogang.sm.dao.StaffDao;
import com.xiaogang.sm.entity.Staff;
import com.xiaogang.sm.service.SelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("selfService")
public class SelfServiceImpl implements SelfService {
    @Autowired
    private StaffDao staffDao;

    @Autowired
    private SelfDao selfDao;

    @Override
    public Staff login(String account, String password) {

        Staff staff = selfDao.selectByAccount(account);
        if (staff == null) return null;
        if (staff.getPassword().equals(password)) return staff;

        return null;
    }

    @Override
    public void changePassword(Integer id, String password) {
        Staff staff =  staffDao.selectById(id);

        staff.setPassword(password);

        staffDao.update(staff);
    }
}
