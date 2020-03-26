package com.eraser.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author wudongjun E-mail:wudongjun43@163.com
 * @create 2020/3/22 22:08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment  implements Serializable {

    private  Long id;
    private  String serial;
}
