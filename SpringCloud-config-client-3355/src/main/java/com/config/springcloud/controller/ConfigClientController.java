package com.config.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lambda
 */
@RestController
public class ConfigClientController {

    /**
     * 此处需要在控制层中远程获取配置客户端的信息，即Config-client的内容
     * 属性值的注入由于没有本地的配置文件，所以需要使用@Value远程获取，${....}
     * 完成资源的注入
     */

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServer;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/config")
    public String getConfig(){
        return "applicationName:"+applicationName
                +",eurekaServer:"+eurekaServer
                +",port:"+port;
    }
}
