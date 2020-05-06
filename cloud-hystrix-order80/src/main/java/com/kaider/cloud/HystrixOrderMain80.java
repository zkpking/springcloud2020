package com.kaider.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author kaider
 * @Date 2020-05-06 10:04
 * @Version 1.0
 * @Description TODO
 **/
@SpringBootApplication
@EnableFeignClients
public class HystrixOrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixOrderMain80.class,args);
    }

}
