package com.consumer.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author lambda
 */
@Configuration
public class BeanConfig {
    /**添加负载均衡实现
     * */

    @Bean
    /**此处表示实现默认的负载均衡算法*/
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
