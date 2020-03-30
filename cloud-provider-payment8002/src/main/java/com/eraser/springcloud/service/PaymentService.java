package com.eraser.springcloud.service;

import com.eraser.springcloud.entities.Payment;

/**
 * @author wudongjun E-mail:wudongjun43@163.com
 * @create 2020/3/26 21:03
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}
