package com.consumer.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author lambda
 */
@SpringBootApplication
@EnableEurekaClient
public class DeptConsumer {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer.class,args);
    }
}
