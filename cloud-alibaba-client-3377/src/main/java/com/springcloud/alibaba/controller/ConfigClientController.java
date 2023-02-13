package com.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author binbin
 * @date 2023年02月13日  下午8:56
 */
@RestController
@RefreshScope //表示支持nacos的动态刷新
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @RequestMapping("/config/info")
    public String getConfigInfo(){
            return configInfo;
    }
}
