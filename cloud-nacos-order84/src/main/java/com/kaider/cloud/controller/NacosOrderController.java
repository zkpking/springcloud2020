package com.kaider.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.kaider.cloud.pojo.CommonResult;
import com.kaider.cloud.pojo.Payment;
import com.kaider.cloud.service.NacosPaymentService;
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

    @GetMapping("getInfo/{id}")
//    @SentinelResource(value = "fallback")
//    @SentinelResource(value = "fallback", fallback = "handlerFallback")
//    @SentinelResource(value = "fallback", blockHandler = "blockHandler")
    @SentinelResource(value = "fallback",fallback = "handlerFallback", blockHandler = "blockHandler")
    public CommonResult<Payment> getInfo(@PathVariable("id") Long id) {
        CommonResult<Payment> result = restTemplate.getForObject(serverUrl + "/nacos/payment/getInfo/" + id, CommonResult.class);
        if (id == 4) {
            throw new IllegalArgumentException("非法参数");
        } else if (result.getData() == null) {
            throw new NullPointerException("空指针");
        }
        return result;
    }

    public CommonResult<Payment> handlerFallback(@PathVariable("id") Long id, Throwable e) {
        return new CommonResult<>(444, "底线:" + e.getMessage(), null);
    }

    public CommonResult<Payment> blockHandler(@PathVariable("id") Long id, BlockException e) {
        return new CommonResult<>(445, "底线:" + e.getMessage(), null);
    }

    @Resource
    private NacosPaymentService paymentService;

    @GetMapping("getInfo2/{id}")
    public CommonResult<Payment> getInfo2(@PathVariable("id") Long id) {
        return paymentService.getInfo(id);
    }
}
