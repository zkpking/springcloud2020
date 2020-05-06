package com.kaider.cloud.controller;

import com.kaider.cloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author kaider
 * @Date 2020-05-06 10:17
 * @Version 1.0
 * @Description TODO
 **/
@RestController
@RequestMapping("hystrix/order2")
@Slf4j
public class OrderController2 {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("ok")
    public String okk() {
        return paymentHystrixService.ok();
    }

    @GetMapping("no")
    public String noo() {
        return paymentHystrixService.no();
    }


}
