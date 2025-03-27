package com.falls.demos.service;

import com.falls.demos.mapper.MessageMapper;
import com.falls.demos.model.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/16  11:33
 */
@Service
public class MessageService {
    @Autowired
    private MessageMapper messageMapper;

    public Integer addMessage(MessageInfo messageInfo){
        return messageMapper.insertMessage(messageInfo);
    }
    public List<MessageInfo> getAllMessageInfo(){
        return messageMapper.queryAll();
    }
}
