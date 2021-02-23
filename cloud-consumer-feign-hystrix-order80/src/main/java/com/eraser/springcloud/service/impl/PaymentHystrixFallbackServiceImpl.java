package com.eraser.springcloud.service.impl;

import com.eraser.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @author wudongjun E-mail:wudongjun43@163.com
 * @create 2020/12/8 14:38
 */
@Component
public class PaymentHystrixFallbackServiceImpl implements PaymentHystrixService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "---PaymentHystrixFallbackService中paymentInfo_OK方法的fallback,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "---PaymentHystrixFallbackService中paymentInfo_Timeout方法的fallback,o(╥﹏╥)o";
    }
}
