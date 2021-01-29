package com.jwang.demo_Big_;

import java.math.BigInteger;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/1/29 下午2:10
 */
public class demo_BigInteger {
    /*
    BigInteger
        超大的整数
    构造方法：BigInteger(String val):字符串整数转为BigInteger对象
    成员方法：
        add +
        subtract -
        multiply *
        divide /
     */
    public static void main(String[] args) {
        final BigInteger big1 = new BigInteger("12344556");
        final BigInteger big2 = new BigInteger("12444556");

        final BigInteger ad_big = big1.add(big2);
    }
}
