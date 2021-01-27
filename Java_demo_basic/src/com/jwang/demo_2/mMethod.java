package com.jwang.demo_2;

/**
 * @PROJECT_NAME: Java_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/1/27 下午4:34
 */
public class mMethod {

    public static void main(String[] args) {
        //调用即进入栈内存，压栈执行
        //return可结束该方法，出栈
        pr(10,24);
        boolean bb = pr(10);
        System.out.println(bb);
    }

    public static void pr(int aa, int bb){
        if(aa < bb){
            System.out.println("false");
            return;

        }
        //未调用时在方法区
        System.out.println("输出");
    }

    public static boolean pr(int num){
        System.out.println(num);
        return num % 2 == 0;
    }

    public static int[] pr(int aa, int bb, int cc){
        int num1 = aa << 2; //aa向左移动两位 aa乘以2的2次幂 >>> 无符号右移，补0
        int num2 = aa ^ bb ^ aa; //结果还是bb，异或两次不变 --两次数据交换
        int[] arr = new int[]{aa, bb, cc};
        return arr;
    }
}
