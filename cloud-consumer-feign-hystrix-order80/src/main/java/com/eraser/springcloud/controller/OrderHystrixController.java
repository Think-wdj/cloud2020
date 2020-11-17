package com.eraser.springcloud.controller;

import com.eraser.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Eraser E-mail:wudongjun43@163.com
 * @create 2020/11/17 22:02
 */
@RestController
@Slf4j
@RequestMapping("/consumer/payment/hystrix")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/ok/{id}")
    public  String paymentInfo_OK(@PathVariable Integer id){
        final String result = this.paymentHystrixService.paymentInfo_OK(id);
        log.info(result);
        return result;
    }

    @GetMapping("/timeout/{id}")
    public  String paymentInfo_Timeout(@PathVariable Integer id){
        final String result = this.paymentHystrixService.paymentInfo_Timeout(id);
        log.info(result);
        return result;
    }
}
