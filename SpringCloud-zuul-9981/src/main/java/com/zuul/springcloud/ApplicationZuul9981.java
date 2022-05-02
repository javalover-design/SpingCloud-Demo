package com.zuul.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author lambda
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class ApplicationZuul9981 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationZuul9981.class,args);

    }
}
