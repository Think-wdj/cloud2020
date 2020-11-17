package com.eraser.springcloud.service;

/**
 * @author Eraser E-mail:wudongjun43@163.com
 * @create 2020/11/17 20:53
 */
public interface PaymentService {

    /**
     * 正常访问，一切OK
     * @param id
     * @return
     */
    public  String paymentInfo_OK(Integer id);

    /**
     * 超时访问，一切超时
     * @param id
     * @return
     */
    public  String paymentInfo_Timeout(Integer id);


}
