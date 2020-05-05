package com.kaider.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author kaider
 * @Date 2020-05-04 19:11
 * @Version 1.0
 * @Description TODO
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerMain7002 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerMain7002.class, args);
    }
}
