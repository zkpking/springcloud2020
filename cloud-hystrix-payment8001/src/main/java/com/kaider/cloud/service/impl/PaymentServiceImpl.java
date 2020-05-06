package com.kaider.cloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.kaider.cloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Author kaider
 * @Date 2020-05-05 21:22
 * @Version 1.0
 * @Description TODO
 **/
@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String ok() {
        return "okk" + Thread.currentThread().getName();
    }

    @Override
    @HystrixCommand(fallbackMethod = "noHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })
    public String no() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "no,sleep:5";
    }

    /**
     * 容错机制处理方案
     *
     * @return
     */
    public String noHandler() {
        return "数据连接有点长，请稍后";
    }

    @HystrixCommand(fallbackMethod = "breakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")//失败率
    })
    @Override
    public String nookBreaker(@PathVariable("id") int id) {
        if(id<0){
            throw new RuntimeException("id值太小了");
        }
        return IdUtil.simpleUUID();
    }

    public String breakerFallback(@PathVariable("id") int id) {
        return "id 太小了不适合，"+IdUtil.simpleUUID() + "fallback";
    }


}
