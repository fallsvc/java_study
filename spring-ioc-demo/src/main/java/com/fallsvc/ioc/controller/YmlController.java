package com.fallsvc.ioc.controller;

import com.fallsvc.ioc.model.Person;
import com.fallsvc.ioc.model.dbtypes;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/9  17:57
 */
@RequestMapping("/yml")
@RestController
public class YmlController {
    @Autowired
    private Person person;
    @Autowired
    private com.fallsvc.ioc.model.dbtypes dbtypes;

    @PostConstruct
    public void print(){
        System.out.println(person);
        System.out.println(dbtypes);
    }
}
