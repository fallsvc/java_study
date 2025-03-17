package com.falls.demos.controller;

import com.falls.demos.model.MessageInfo;
import com.falls.demos.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/6  10:56
 */
@RequestMapping("/message")
@RestController
public class MessageController {
    @Autowired
    private MessageService messageService;
    /**
     * @RequestBody 接受json
     * produces = "application/json" 返回json  return "\"ok\  ":0";
     * @param message
     * @return
     */
    @RequestMapping(value = "/publish",produces = "application/json")
    public String publish(@RequestBody MessageInfo message){
        if(!StringUtils.hasLength(message.getFrom())||!StringUtils.hasLength(message.getTo())||
                !StringUtils.hasLength(message.getMessage())){
            return "{\"ok\":0}";
        }
        messageService.addMessage(message);
        return "{\"ok\":1}";
    }
    @RequestMapping("/getList")
    public List<MessageInfo> getList(){
        return messageService.getAllMessageInfo();
    }
}
