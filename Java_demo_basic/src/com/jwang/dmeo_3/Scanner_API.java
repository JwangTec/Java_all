package com.jwang.dmeo_3;
import java.util.Scanner;

/**
 * @PROJECT_NAME: Java_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/1/27 下午6:09
 */
public class Scanner_API {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(":");
        final String s = scanner.nextLine();
        System.out.println(s);

        String aa = "asd";
        final String ss = new String("asd");
        //+:变量：底层自动创建一个StringBuilder对象进行拼接append并调用toString转为String类型
        //+：常量：常量优化机制，自动转化为字符串
        System.out.println(ss+",asd");
        //字符串获取字符
        char c1 = ss.charAt(1);
        //截取字符串
        final String s1 = ss.substring(1, 2);
        //替换
        final String s2 = ss.replace("a", "b");
        //切割
        final String[] split = ss.split(",");
        System.out.println(aa == ss);

        //长度可变字符串
        final StringBuilder sb = new StringBuilder();
        //append 返回对象本身
        sb.append(123);
        //链式编程：一个方法返回的是对象类型，对象就可以向下继续调用方法
        sb.append("asd").append(456);
        //反转
        final StringBuilder rsb = sb.reverse();



    }
}