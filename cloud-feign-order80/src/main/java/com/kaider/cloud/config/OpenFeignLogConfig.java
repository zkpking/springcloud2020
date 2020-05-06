package com.kaider.cloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author kaider
 * @Date 2020-05-05 18:48
 * @Version 1.0
 * @Description TODO
 **/
@Configuration
public class OpenFeignLogConfig {

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

}
