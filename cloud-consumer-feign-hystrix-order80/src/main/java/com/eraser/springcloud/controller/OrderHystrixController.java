package com.eraser.springcloud.controller;

import com.eraser.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
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
//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })
    @HystrixCommand
    public  String paymentInfo_Timeout(@PathVariable Integer id){
        //int a =10/0;
        final String result = this.paymentHystrixService.paymentInfo_Timeout(id);
        log.info(result);
        return result;
    }
    public String paymentTimeOutFallbackMethod(@PathVariable Integer id){
        return "我是消费者80，对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,o(╥﹏╥)o";
    }


    //下面是全局fallback方法
    public String payment_Global_FallbackMethod(){
        return "Global异常处理信息，请稍后再试，o(╥﹏╥)o~~~";
    }
}
