package com.kaider.cloud.controller;

import com.kaider.cloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author kaider
 * @Date 2020-05-05 21:21
 * @Version 1.0
 * @Description TODO
 **/
@RestController
@RequestMapping("hystrix/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("ok")
    public String okk(){
      return paymentService.ok();
    }

    @GetMapping("no")
    public String noo(){
        return paymentService.no();
    }

}
