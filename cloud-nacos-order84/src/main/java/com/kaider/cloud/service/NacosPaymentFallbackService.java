package com.kaider.cloud.service;

import com.kaider.cloud.pojo.CommonResult;
import com.kaider.cloud.pojo.Payment;
import org.springframework.stereotype.Component;

/**
 * @Author kaider
 * @Date 2020-05-08 22:35
 * @Version 1.0
 * @Description TODO
 **/
@Component
public class NacosPaymentFallbackService implements NacosPaymentService {

    @Override
    public CommonResult<Payment> getInfo(Long id) {
        return new CommonResult(446,"lalalla",null);
    }
}
