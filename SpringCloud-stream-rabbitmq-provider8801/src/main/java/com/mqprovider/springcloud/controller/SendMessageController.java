package com.mqprovider.springcloud.controller;

import com.mqprovider.springcloud.service.StreamSendMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author binbin
 * @date 2022年09月01日  下午9:05
 */
@RestController
public class SendMessageController {
    /**引入service业务层对象*/
    @Resource
    private StreamSendMessage message;


    @GetMapping("/sendMessage")
    public String getMessage(){
        return message.send();
    }
}
