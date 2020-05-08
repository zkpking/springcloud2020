package com.kaider.cloud.service;

import com.kaider.cloud.pojo.CommonResult;
import com.kaider.cloud.pojo.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "nacos-payment-service",fallback = NacosPaymentFallbackService.class)
public interface NacosPaymentService {

    @GetMapping("nacos/payment/getInfo/{id}")
    public CommonResult<Payment> getInfo(@PathVariable("id") Long id);

}
