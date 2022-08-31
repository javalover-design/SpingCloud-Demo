package com.config.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author binbin
 * @date 2022年08月31日  下午9:34
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClient3377 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClient3377.class,args);
    }
}
