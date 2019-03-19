package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.SystemLog;

/**
 * @Description:
 * @Author: vesus
 * @CreateDate: 2018/5/20 上午11:31
 * @Version: 1.0
 */
public interface SystemLogRepository extends CrudRepository<SystemLog,Long> {
}