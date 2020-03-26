package com.eraser.springcloud.dao;

import com.eraser.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author wudongjun E-mail:wudongjun43@163.com
 * @create 2020/3/22 22:24
 */
@Mapper
public interface PaymentDao {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
