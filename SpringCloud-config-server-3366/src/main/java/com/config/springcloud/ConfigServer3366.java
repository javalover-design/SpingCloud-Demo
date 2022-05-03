package com.config.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author lambda
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServer3366 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServer3366.class,args);
    }
}
