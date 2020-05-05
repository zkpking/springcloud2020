package com.kaider.cloud.service.impl;

import com.kaider.cloud.dao.PaymentDao;
import com.kaider.cloud.pojo.Payment;
import com.kaider.cloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author kaider
 * @Date 2020-05-04 16:25
 * @Version 1.0
 * @Description TODO
 **/
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;


    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
