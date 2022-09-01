package com.mqprovider.springcloud.service.impl;

import com.mqprovider.springcloud.service.StreamSendMessage;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author binbin
 * @date 2022年09月01日  下午8:52
 */

@EnableBinding(Source.class) /*此处注解表示将信道channel与exchange进行绑定，即定义消息的推送管道*/
public class StreamSendMessageImpl implements StreamSendMessage {

    /**定义消息发送管道*/
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial= UUID.randomUUID().toString();
        //此处发送消息的时候需要使用到消息绑定器
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("*********"+serial);
        return serial;
    }
}
