package com.kaider.cloud.controller;

import cn.hutool.core.util.IdUtil;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.kaider.cloud.pojo.CommonResult;
import com.kaider.cloud.pojo.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author kaider
 * @Date 2020-05-07 23:13
 * @Version 1.0
 * @Description TODO
 **/
@RestController
@RequestMapping("nacos/sentinel")
@Slf4j
public class NacosSentinelController {

    @GetMapping("getA")
    public String getA() {
        return "testA";
    }

    @GetMapping("getB")
    public String getB() {
        return "testB";
    }

    /**
     * 处理热点规则
     *
     * @return
     */
    @GetMapping("getC")
    @SentinelResource(value = "getC", blockHandler = "getCBlock")
    public String getC(
            @RequestParam(value = "q1", required = false) String q1,
            @RequestParam(value = "q2", required = false) String q2
    ) {
        return "testC";
    }

    public String getCBlock(String q1, String q2, BlockException exception) {
        return "sorry hot key";
    }

    @GetMapping("getD")
    @SentinelResource(value = "getD", blockHandler = "handleException")
    public CommonResult getD() {
        return new CommonResult(200, "按资源名称限流很成功", new Payment(1L, IdUtil.simpleUUID()));
    }

    public CommonResult handleException(BlockException e) {
        return new CommonResult(444, e.getMessage());
    }


}
