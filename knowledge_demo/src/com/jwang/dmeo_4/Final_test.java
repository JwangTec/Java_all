package com.jwang.dmeo_4;

import com.jwang.demo_2.OOP_Person;


/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION: final
 * @USER: jwang
 * @DATE: 2021/1/28 下午3:43
 */
public final class Final_test {
    /**
     * 该类不能被继承
     */

    //final修饰的方法不能被重写
    public final void show(){}

    //变量：会变成一个常量，只能赋值一次,通常大写,可以通过构造方法和直接赋值，空参构造也需要对其赋值
    final int NUM = 10;



}
