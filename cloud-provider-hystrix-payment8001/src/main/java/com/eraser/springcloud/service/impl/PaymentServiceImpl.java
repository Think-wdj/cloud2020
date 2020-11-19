package com.eraser.springcloud.service.impl;

import com.eraser.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author Eraser E-mail:wudongjun43@163.com
 * @create 2020/11/17 20:54
 */
@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "线程池：  "+Thread.currentThread().getName()+"   paymentInfo_OK,id:  "+id+"\t"+"O(∩_∩)O哈哈~";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    @Override
    public String paymentInfo_Timeout(Integer id) {
        log.info("正常方法睡眠前");
        Integer timeNumber=3;
        try{
            TimeUnit.SECONDS.sleep(timeNumber);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        //int age = 10/0;
        log.info("正常方法睡眠后");
        return "线程池：  "+Thread.currentThread().getName()+"   paymentInfo_Timeout,id:  "+id+"\t"+"o(╥﹏╥)o"+"  耗时(秒):"+timeNumber;
        //return "线程池：  "+Thread.currentThread().getName()+"   paymentInfo_Timeout,id:  "+id+"\t"+"o(╥﹏╥)o";
    }

    public String paymentInfo_TimeoutHandler(Integer id) {
        return "线程池：  "+Thread.currentThread().getName()+"   系统繁忙，请稍后再试,id:  "+id+"\t"+"(#^.^#)";
    }
}
