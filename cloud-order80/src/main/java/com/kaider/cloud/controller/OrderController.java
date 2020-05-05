package com.kaider.cloud.controller;

import com.kaider.cloud.config.MyLoadBalancer;
import com.kaider.cloud.pojo.CommonResult;
import com.kaider.cloud.pojo.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

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

    public static final String PAYMENT_URL = "http://PAYMENT-SERVICE/payment/";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private MyLoadBalancer myLoadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;


    @PostMapping("makeOrder")
    public CommonResult<Payment> makeOrder(@RequestBody Payment payment) {
        String url = PAYMENT_URL + "create";
        return restTemplate.postForObject(url, payment, CommonResult.class);
    }


    @GetMapping("getOrder1/{id}")
    public CommonResult<Payment> getOrderForObject(@PathVariable("id") Long id) {
        String url = PAYMENT_URL + "getPaymentById/" + id;
        return restTemplate.getForObject(url, CommonResult.class);
    }

    @GetMapping("getOrder2/{id}")
    public CommonResult<Payment> getOrderForEntity(@PathVariable("id") Long id) {
        String url = PAYMENT_URL + "getPaymentById/" + id;
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(url, CommonResult.class);
        log.info("---->" + entity);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return new CommonResult<>(444, "操作失败");
        }
    }

    @GetMapping("getBlPort")
    public String getBlPort() {
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("PAYMENT-SERVICE");
        if (serviceInstances == null && serviceInstances.size() <= 0) {
            return null;
        }
        ServiceInstance serviceInstance = myLoadBalancer.instances(serviceInstances);
        URI uri = serviceInstance.getUri();
        String url = uri + "/payment/getBlPort";
        return restTemplate.getForObject(url, String.class);
    }

}
