package com.falls.demos;

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
    private List<Message> list=new ArrayList<>();
    /**
     * @RequestBody 接受json
     * produces = "application/json" 返回json  return "\"ok\  ":0";
     * @param message
     * @return
     */
    @RequestMapping(value = "/publish",produces = "application/json")
    public String publish(@RequestBody Message message){
        if(!StringUtils.hasLength(message.getFrom())||!StringUtils.hasLength(message.getTo())||
                !StringUtils.hasLength(message.getMessage())){
            return "{\"ok\":0}";
        }
        list.add(message);
        return "{\"ok\":1}";
    }
    @RequestMapping("/getList")
    public List<Message> getList(){
        return list;
    }
}
