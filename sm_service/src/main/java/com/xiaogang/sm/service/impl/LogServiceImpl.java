package com.xiaogang.sm.service.impl;

import com.xiaogang.sm.dao.LogDao;
import com.xiaogang.sm.entity.Log;
import com.xiaogang.sm.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("logService")
public class LogServiceImpl implements LogService{

    @Autowired
    private LogDao logDao;

    @Override
    public void addSystemLog(Log log) {
        log.setType("system");
        log.setOprTime(new Date());
        logDao.insert(log);
    }

    @Override
    public void addLoginLog(Log log) {
        log.setType("login");
        log.setOprTime(new Date());
        logDao.insert(log);
    }

    @Override
    public void addOperationLog(Log log) {
        log.setType("operation");
        log.setOprTime(new Date());
        logDao.insert(log);
    }

    @Override
    public List<Log> getSystemLog() {
        return logDao.selectByType("system");
    }

    @Override
    public List<Log> getLoginLog() {
        return logDao.selectByType("login");
    }

    @Override
    public List<Log> getOperationLog() {
        return logDao.selectByType("operation");
    }
}
