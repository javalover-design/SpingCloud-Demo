package com.consumer.myrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lambda
 */
@Configuration
public class MyRule {

    @Bean
    public IRule getRule(){
        return new MyRandomRule();
    }

}
