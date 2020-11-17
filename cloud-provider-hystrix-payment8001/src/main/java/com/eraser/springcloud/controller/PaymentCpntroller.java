package com.eraser.springcloud.controller;

import com.eraser.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Eraser E-mail:wudongjun43@163.com
 * @create 2020/11/17 21:02
 */
@RestController
@Slf4j
@RequestMapping("/payment/hystrix")
public class PaymentCpntroller {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/ok/{id}")
    public String paymentInfo_ok(@PathVariable Integer id){
        String result=this.paymentService.paymentInfo_OK(id);
        log.info("**********result: "+result);
        return result;
    }

    @GetMapping("/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable Integer id){
        String result=this.paymentService.paymentInfo_Timeout(id);
        log.info("**********result: "+result);
        return result;
    }
}
