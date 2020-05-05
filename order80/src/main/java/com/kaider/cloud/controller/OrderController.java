package com.kaider.cloud.controller;

import com.kaider.cloud.pojo.CommonResult;
import com.kaider.cloud.pojo.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author kaider
 * @Date 2020-05-04 17:14
 * @Version 1.0
 * @Description TODO
 **/
@RestController
@RequestMapping("order")
@Slf4j
public class OrderController {

//    public static final String PAYMENT_URL = "http://localhost:8001/payment/";
    public static final String PAYMENT_URL = "http://PAYMENT-SERVICE/payment/";

    @Resource
    private RestTemplate restTemplate;


    @PostMapping("makeOrder")
    public CommonResult<Payment> makeOrder(@RequestBody Payment payment){
        String url = PAYMENT_URL+ "create";
        return restTemplate.postForObject(url,payment,CommonResult.class);
    }


    @GetMapping("getOrder/{id}")
    public CommonResult<Payment> getOrder(@PathVariable("id") Long id){
        String url = PAYMENT_URL+ "getPaymentById/"+id;
        return restTemplate.getForObject(url,CommonResult.class);
    }

}
