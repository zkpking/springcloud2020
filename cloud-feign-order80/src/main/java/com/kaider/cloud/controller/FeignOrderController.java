package com.kaider.cloud.controller;

import com.kaider.cloud.pojo.CommonResult;
import com.kaider.cloud.pojo.Payment;
import com.kaider.cloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author kaider
 * @Date 2020-05-05 17:58
 * @Version 1.0
 * @Description TODO
 **/
@RestController
@RequestMapping("feign/order")
@Slf4j
public class FeignOrderController {

    @Resource
    private PaymentFeignService feignService;

    @GetMapping("getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
       return feignService.getPaymentById(id);
    }

    @GetMapping("waiteTime")
    public String waiteTime(){
        return feignService.waiteTime();
    }

}
