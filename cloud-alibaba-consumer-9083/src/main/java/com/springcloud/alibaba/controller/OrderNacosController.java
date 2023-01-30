package com.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author binbin
 * @date 2023年01月30日  下午8:22
 */
@RestController
public class OrderNacosController {

    @Resource
    private RestTemplate restTemplate;

    /**此处表示要访问的微服务的名称*/
    @Value("${service-url.nacos-user-service}")
    private String serviceUrl;

    @RequestMapping("/consumer/payment/nacos/{id}")
    public String getInfo( @PathVariable("id") Integer id){
            return restTemplate.getForObject(serviceUrl+"/payment/nacos/"+id,String.class);
    }

}
