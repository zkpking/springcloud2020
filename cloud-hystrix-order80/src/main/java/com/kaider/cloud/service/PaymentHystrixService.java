package com.kaider.cloud.service;

import com.kaider.cloud.service.fallback.PaymentHystrixServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(value = "HYSTRIX-PAYMENT-SERVICE", fallback = PaymentHystrixServiceFallback.class)
public interface PaymentHystrixService {

    @GetMapping("hystrix/payment/ok")
    public String ok();

    @GetMapping("hystrix/payment/no")
    public String no();

}
