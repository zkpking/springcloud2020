package com.kaider.cloud.controller;

import com.kaider.cloud.pojo.CommonResult;
import com.kaider.cloud.pojo.Payment;
import com.kaider.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author kaider
 * @Date 2020-05-04 16:29
 * @Version 1.0
 * @Description TODO
 **/
@RestController
@RequestMapping("payment")
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("create")
    public CommonResult create(Payment payment) {
        int result = paymentService.create(payment);
        log.info("-----插入成功：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入成功", result);
        }
        return new CommonResult(444, "插入失败", result);
    }

    @GetMapping("getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return new CommonResult(200, "查询成功:" + serverPort, payment);
        }
        return new CommonResult(444, "查询失败", "查询id为：" + id);
    }

    @GetMapping("getDiscoveryClient")
    public Object getDiscoveryClient() {
        List<String> services = discoveryClient.getServices();
        for (String serviceName : services) {
            log.info("serviceName:" + serviceName);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("instance:" + instance.getServiceId() + "--" + instance.getHost() + "--" + instance.getPort() + "--" + instance.getUri());
        }
        return discoveryClient;
    }

    @GetMapping("getBlPort")
    public String getBlPort() {
        return serverPort;
    }

}
