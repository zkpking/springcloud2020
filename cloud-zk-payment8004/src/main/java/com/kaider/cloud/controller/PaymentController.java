package com.kaider.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Author kaider
 * @Date 2020-05-05 11:10
 * @Version 1.0
 * @Description TODO
 **/
@RestController
@RequestMapping("zkPayment")
@Slf4j
public class PaymentController {


    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("zk")
    public String zk(){
        return "springcloud with zookeeper:"+serverPort+"\t--->" + UUID.randomUUID().toString();
    }


}
