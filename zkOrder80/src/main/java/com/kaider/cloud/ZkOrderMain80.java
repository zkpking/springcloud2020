package com.kaider.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author kaider
 * @Date 2020-05-05 12:00
 * @Version 1.0
 * @Description TODO
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class ZkOrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(ZkOrderMain80.class, args);
    }
}
