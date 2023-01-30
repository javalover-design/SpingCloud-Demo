package com.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author binbin
 * @date 2023年01月30日  下午8:00
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerMain9083 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerMain9083.class,args);
    }
}
