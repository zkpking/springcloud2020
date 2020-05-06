package com.kaider.cloud.service;

import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.HystrixCommands;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author kaider
 * @Date 2020-05-05 21:22
 * @Version 1.0
 * @Description TODO
 **/
@Service
public class PaymentService {


    public String ok() {
        return "okk" + Thread.currentThread().getName();
    }

    public String no()  {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "no,sleep:3";
    }

}
