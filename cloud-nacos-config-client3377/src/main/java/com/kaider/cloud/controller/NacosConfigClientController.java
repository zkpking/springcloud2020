package com.kaider.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author kaider
 * @Date 2020-05-07 23:13
 * @Version 1.0
 * @Description TODO
 **/
@RestController
@RequestMapping("nacos/config")
@RefreshScope//动态刷新
@Slf4j
public class NacosConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("getConfigInfo")
    public String getConfigInfo(){
        return configInfo;
    }

}
