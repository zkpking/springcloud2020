package com.kaider.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @Author kaider
 * @Date 2020-05-05 21:07
 * @Version 1.0
 * @Description TODO
 **/
@SpringBootApplication
@EnableEurekaClient
public class HystrixPaymentMain8001 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixPaymentMain8001.class, args);
    }

}
