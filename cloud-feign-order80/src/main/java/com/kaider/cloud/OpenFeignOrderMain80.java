package com.kaider.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author kaider
 * @Date 2020-05-05 17:47
 * @Version 1.0
 * @Description TODO
 **/
@SpringBootApplication
@EnableFeignClients
public class OpenFeignOrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OpenFeignOrderMain80.class, args);
    }

}
