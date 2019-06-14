package com.xiaogang.sm.dao;

import com.xiaogang.sm.entity.Log;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("logDao")
public interface LogDao {
    List<Log > selectByType(String type);
    void insert(Log log);
}
