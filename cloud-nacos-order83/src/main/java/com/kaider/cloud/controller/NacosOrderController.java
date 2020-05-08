package com.kaider.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author kaider
 * @Date 2020-05-07 22:02
 * @Version 1.0
 * @Description TODO
 **/
@RestController
@RequestMapping("nacos/order")
@Slf4j
public class NacosOrderController {

    @Value("${service-url.nacos-user-service}")
    private String serverUrl;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("getOrderById/{id}")
    public String getOrderById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(serverUrl + "/nacos/payment/getPayment/" + id, String.class);
    }

}
