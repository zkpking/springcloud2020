package com.kaider.cloud.controller;

import cn.hutool.core.util.IdUtil;
import com.kaider.cloud.pojo.CommonResult;
import com.kaider.cloud.pojo.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author kaider
 * @Date 2020-05-07 21:32
 * @Version 1.0
 * @Description TODO
 **/
@RestController
@RequestMapping("nacos/payment")
@Slf4j
public class NacosPaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("getPayment/{id}")
    public String getPayment(@PathVariable("id") Long id) {
        return "nacos payment id:" + id + " this port:" + serverPort;
    }

    @GetMapping("getInfo/{id}")
    public CommonResult<Payment> getInfo(@PathVariable("id") Long id) {
        if (id == 3L) {
            return new CommonResult<Payment>(444, "获得端口：" + serverPort + "数据失败");
        } else if (id == 4L) {
            return new CommonResult<>(444, "error", null);
        }
        return new CommonResult<Payment>(200, "获得端口：" + serverPort, new Payment(1L, IdUtil.simpleUUID()));
    }

}
