package com.eraser.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Eraser E-mail:wudongjun43@163.com
 * @create 2020/11/17 20:53
 */
@FeignClient("cloud-provider-hystrix-payment")
@RequestMapping("/payment/hystrix")
public interface PaymentHystrixService {

    @GetMapping("/ok/{id}")
    public  String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("/timeout/{id}")
    public  String paymentInfo_Timeout(@PathVariable("id") Integer id);


}
