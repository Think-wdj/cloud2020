package com.eraser.springcloud.service.impl;

import com.eraser.springcloud.dao.PaymentDao;
import com.eraser.springcloud.entities.Payment;
import com.eraser.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wudongjun E-mail:wudongjun43@163.com
 * @create 2020/3/26 21:08
 */
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
