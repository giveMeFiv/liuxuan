package com.example.demo.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SystemLogRepository;
import com.example.demo.entity.SystemLog;
import com.example.demo.service.SystemLogService;

import java.util.List;

/**
 * @Description:
 * @Author: vesus
 * @CreateDate: 2018/5/20 上午11:45
 * @Version: 1.0
 */
@Service
public class SystemLogServiceImpl implements SystemLogService {

    @Autowired
    SystemLogRepository systemLogRepository ;
    @Override
    public List<SystemLog> findAll() {
        return null;
    }

    @Override
    public void saveUser(SystemLog log) {
        systemLogRepository.save(log);
    }

    @Override
    public SystemLog findOne(long id) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

	
}