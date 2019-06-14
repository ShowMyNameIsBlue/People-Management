package com.xiaogang.sm.service;


import com.xiaogang.sm.entity.Staff;

public interface SelfService
{
    Staff login(String account, String password);
    void changePassword(Integer id, String password);
}
