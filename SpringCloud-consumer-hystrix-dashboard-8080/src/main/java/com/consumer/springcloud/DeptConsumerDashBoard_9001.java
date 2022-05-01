package com.consumer.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author lambda
 */
@SpringBootApplication
@EnableHystrixDashboard //开启hystrix监控注解
public class DeptConsumerDashBoard_9001 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerDashBoard_9001.class,args);
    }
}
