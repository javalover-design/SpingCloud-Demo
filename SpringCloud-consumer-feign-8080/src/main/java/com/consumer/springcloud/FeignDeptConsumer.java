package com.consumer.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author lambda
 */
@SpringBootApplication(scanBasePackages = {"com.example.springcloud.service","com.consumer.springcloud.controller"})
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.example.springcloud"})
public class FeignDeptConsumer {
    public static void main(String[] args) {
        SpringApplication.run(FeignDeptConsumer.class,args);
    }
}
