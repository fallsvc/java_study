package com.fallsvc.trans.service;

import com.fallsvc.trans.mapper.LogInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LogService {
@Autowired
private LogInfoMapper logInfoMapper;
public void insertLog(String name,String op){
//记录⽤⼾操作
logInfoMapper.insertLog(name,"⽤⼾注册");
}
}