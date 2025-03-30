package com.fallsvc.trans.controller;


import com.fallsvc.trans.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@Slf4j
@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;
    @Autowired
    private TransactionDefinition transactionDefinition;

    @RequestMapping("/registry")
    public String registry(String name, String password) {
        TransactionStatus transactionStatus=dataSourceTransactionManager.getTransaction(transactionDefinition);
        //⽤⼾注册
        userService.registryUser(name, password);
        log.info("用户注册成功。。。");

        // 事务提交
//        dataSourceTransactionManager.commit(transactionStatus);
        // 事务回滚
        dataSourceTransactionManager.rollback(transactionStatus);

        return "注册成功";
    }
}