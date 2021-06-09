package com.eraser.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.eraser.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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
        return "线程池：  "+Thread.currentThread().getName()+"  8001 系统繁忙，请稍后再试,id:  "+id+"\t"+"(#^.^#)";
    }

    //===服务熔断
    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            //是否开启断路器
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),
            //请求次数
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),
            //时间窗口期
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            //失败率达到多少后降级
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60"),
    })
    public String paymentCircuitBreaker(Integer id){
        if(id<0){
            log.info("============================*****=============================");
            throw new RuntimeException("*****************id 不能为负数");
        }
        String serialNumber= IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功，流水号"+serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能为负数，请稍后再试，o(╥﹏╥)o  id:"+id;
    }
}
