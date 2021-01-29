package com.jwang.demo_object;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION: object类
 * @USER: jwang
 * @DATE: 2021/1/29 下午12:47
 */
public class demo1 {
    public static void main(String[] args) {
        /*
        object为超类：其他都是直接继承或者间接继承
        object类方法：
            1。toString: 对象的字符串表示（默认返回类全路径+@+地址值）
            2。equals：比较两个对象是否相等
         */

        //1
        Person per = new Person("aa");
        System.out.println(per.toString());
        //打印对象默认调用toString--通常重写toString方法
        System.out.println(per);

        //2
        Person per1 = new Person("aa");
        System.out.println(per==per1);
        //equals:默认==比较两个对象的地址值--通常重写equals方法，比较其内容是否相等
        System.out.println(per.equals(per1));


    }
}
