package com.eraser.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wudongjun E-mail:wudongjun43@163.com
 * @create 2020/3/22 22:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public  CommonResult(Integer code , String message){
        this(code,message,null);
    }
}
