package com.kaider.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author kaider
 * @Date 2020-05-07 22:00
 * @Version 1.0
 * @Description TODO
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class NacosOrderMain84 {

    public static void main(String[] args) {
        SpringApplication.run(NacosOrderMain84.class, args);
    }

}
