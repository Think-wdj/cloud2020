package com.eraser.springcloud.controller;

import com.eraser.springcloud.entities.CommonResult;
import com.eraser.springcloud.entities.Payment;
import com.eraser.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Eraser E-mail:wudongjun43@163.com
 * @create 2020/11/3 22:02
 */
@Slf4j
@RestController
@RequestMapping("/consumer")
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout(){
        return this.paymentFeignService.paymentFeignTimeout();
    }
}
