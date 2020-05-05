package com.kaider.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author kaider
 * @Date 2020-05-05 11:09
 * @Version 1.0
 * @Description TODO
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class ZkPaymentMain8004 {

    public static void main(String[] args) {
        SpringApplication.run(ZkPaymentMain8004.class, args);
    }
}
