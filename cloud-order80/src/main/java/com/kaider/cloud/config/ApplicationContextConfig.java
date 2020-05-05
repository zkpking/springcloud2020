package com.kaider.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author kaider
 * @Date 2020-05-04 17:19
 * @Version 1.0
 * @Description TODO
 **/
@Configuration
public class ApplicationContextConfig {

    @Bean
//    @LoadBalanced //使用自己的负载均衡则需要屏蔽掉
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
