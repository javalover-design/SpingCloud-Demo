package com.binbin.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author binbin
 * @date 2022年09月03日  下午11:43
 */
@Component
@EnableBinding(Sink.class) //指将消费者的信道与交换机进行绑定，消费者对应Sink.class，生产者对应Source.class
public class ReceiveMessageController {

    /**表示从配置文件中读取端口号*/
    @Value("${server.port}")
    private String serverPort;


    /**
     * @author binbin
     * @date 2022/9/3 下午11:49
     * @param message 表示接收到的信息实例
     * 注解表示监听Sink类中监听到的消息
     */
    @StreamListener(Sink.INPUT)
    public void inputMessage(Message<String> message){
        System.out.println("消费者1号---->接收到的信息："+message.getPayload()+"\t"+"，端口号为"+serverPort);
    }

}
