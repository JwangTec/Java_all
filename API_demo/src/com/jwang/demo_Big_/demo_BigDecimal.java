package com.jwang.demo_Big_;

import java.math.BigDecimal;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/1/29 下午2:17
 */
public class demo_BigDecimal {
    /*
    可变的任意精度的超大小数，可解决计算精度问题
    构造方法：BigDecimal(String val):字符串小数转化为BigDecimal对象,无精度问题
            BigDecimal(Double val)：存在问题，运算仍然存在精度问题
    常用方法：
        add +
        subtract -
        multiply *
        divide / 除不尽会报异常（使用另一个重载方法）

     */
    public static void main(String[] args) {
        BigDecimal bd1 = new BigDecimal("123.34");
        BigDecimal bd2 = new BigDecimal("123.2222");
        final BigDecimal adbd1 = bd1.add(bd2);
    }





}
