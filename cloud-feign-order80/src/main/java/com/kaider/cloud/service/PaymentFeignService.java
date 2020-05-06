package com.kaider.cloud.service;

import com.kaider.cloud.pojo.CommonResult;
import com.kaider.cloud.pojo.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient("PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping("payment/getPaymentById/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping("payment/waiteTime")
    String waiteTime();

}
