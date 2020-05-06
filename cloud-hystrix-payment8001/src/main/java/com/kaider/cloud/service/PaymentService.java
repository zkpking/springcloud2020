package com.kaider.cloud.service;

import org.springframework.web.bind.annotation.PathVariable;

public interface PaymentService {

    String ok();

    String no();

    String nookBreaker(@PathVariable("id") int id);
}
