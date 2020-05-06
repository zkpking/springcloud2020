package com.kaider.cloud.service.fallback;

import com.kaider.cloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @Author kaider
 * @Date 2020-05-06 13:03
 * @Version 1.0
 * @Description TODO
 **/
@Component
public class PaymentHystrixServiceFallback implements PaymentHystrixService {

    @Override
    public String ok() {
        return "okk 被超时";
    }

    @Override
    public String no() {
        return "nono 被超时";
    }
}
