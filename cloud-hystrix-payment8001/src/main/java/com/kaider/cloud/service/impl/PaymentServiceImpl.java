package com.kaider.cloud.service.impl;

import com.kaider.cloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

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

}
