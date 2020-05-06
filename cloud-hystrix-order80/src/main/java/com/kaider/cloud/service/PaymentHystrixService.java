package com.kaider.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient("HYSTRIX-PAYMENT-SERVICE")
public interface PaymentHystrixService {

    @GetMapping("hystrix/payment/ok")
    public String ok();

    @GetMapping("hystrix/payment/no")
    public String no();

}
