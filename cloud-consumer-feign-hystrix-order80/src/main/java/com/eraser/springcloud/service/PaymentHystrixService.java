package com.eraser.springcloud.service;

import com.eraser.springcloud.service.impl.PaymentHystrixFallbackServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Eraser E-mail:wudongjun43@163.com
 * @create 2020/11/17 20:53
 */
@Component
//这个会导致无法情动（原因：重复URL注册）@RequestMapping("/payment/hystrix")
@FeignClient(value = "cloud-provider-hystrix-payment",fallback = PaymentHystrixFallbackServiceImpl.class)
public interface PaymentHystrixService {

    @GetMapping("/payment/hystrix/ok/{id}")
    public  String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    public  String paymentInfo_Timeout(@PathVariable("id") Integer id);


}
