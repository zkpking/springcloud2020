package com.kaider.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author kaider
 * @Date 2020-05-05 12:01
 * @Version 1.0
 * @Description TODO
 **/
@RestController
@RequestMapping("zkOrder")
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    public static final String PAYMENT_URL = "http://zk-payment-service/zkPayment/";

    @GetMapping("getOrder")
    public String getOrder() {
        String url = PAYMENT_URL + "zk";
        return restTemplate.getForObject(url, String.class);
    }


}
