package com.kaider.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author kaider
 * @Date 2020-05-07 21:19
 * @Version 1.0
 * @Description TODO
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class NacosPaymentMain9001 {

    public static void main(String[] args) {
        SpringApplication.run(NacosPaymentMain9001.class, args);
    }

}
