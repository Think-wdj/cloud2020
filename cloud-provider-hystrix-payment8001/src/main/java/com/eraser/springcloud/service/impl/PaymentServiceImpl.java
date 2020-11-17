package com.eraser.springcloud.service.impl;

import com.eraser.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author Eraser E-mail:wudongjun43@163.com
 * @create 2020/11/17 20:54
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "线程池：  "+Thread.currentThread().getName()+"   paymentInfo_OK,id:  "+id+"\t"+"O(∩_∩)O哈哈~";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {

        Integer timeNumber=3;
        try{
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "线程池：  "+Thread.currentThread().getName()+"   paymentInfo_Timeout,id:  "+id+"\t"+"o(╥﹏╥)o"+"  耗时(秒):"+timeNumber;
    }
}
