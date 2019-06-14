package com.xiaogang.sm.dao;

import com.xiaogang.sm.entity.Staff;
import org.springframework.stereotype.Repository;


@Repository("selfDao")
public interface SelfDao {

    Staff selectByAccount(String account);
}
