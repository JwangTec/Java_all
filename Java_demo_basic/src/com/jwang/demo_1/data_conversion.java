package com.jwang.demo_1;

/**
 * @PROJECT_NAME: Java_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/1/27 下午1:37
 */
public class data_conversion {
    public static void main(String[] args) {
        // 隐式转换，小范围直接转化为大范围，然后再进行计算。
        int a = 10;
        double b = 12.3;
        double c = a + b;

        //byte sort char 做运算时直接进行转化为int,不然会报错. char是ascii
        byte d = 1;
        byte e = 2;
        int f = d + e;

        //强制转换 大转小 ,但会损失精度
        double g = 10.99;
        int h = (int)g;
        System.out.println(h);

        //常量优化机制 判断是否在范围内，在通过，不在失败
        double k = 3 + 3;
        System.out.println(k);
    }
}
