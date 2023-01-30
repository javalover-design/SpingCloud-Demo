package com.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author binbin
 * @date 2023年01月30日  下午7:45
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/nacos/{id}")
    public String getServerPort(@PathVariable("id") Integer id){
        return "This Service is registered at Nacos,and its port is"+serverPort+"and its id is"+id;
    }
}
