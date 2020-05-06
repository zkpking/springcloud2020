package com.kaider.cloud.controller;

import com.kaider.cloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
@RequestMapping("hystrix/order")
@Slf4j
@DefaultProperties(defaultFallback = "globalFallBackMethod")
public class OrderController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("ok")
    public String okk() {
        return paymentHystrixService.ok();
    }

    @GetMapping("no")
    /*@HystrixCommand(fallbackMethod = "noHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })*/
    @HystrixCommand(fallbackMethod = "noHandler")
    public String noo() {
        return paymentHystrixService.no();
    }

    /**
     * 容错机制处理方案
     *
     * @return
     */
    public String noHandler() {
        return "数据连接有点长，请稍后";
    }


    @GetMapping("no2")
    @HystrixCommand
    public String no2() {
        return paymentHystrixService.no();
    }

    /**
     * 全局降级服务
     *
     * @return
     */
    public String globalFallBackMethod() {
        return "全局服务降级处理";
    }


}
