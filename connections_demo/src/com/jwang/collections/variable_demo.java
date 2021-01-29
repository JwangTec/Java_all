package com.jwang.collections;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION: 可变参数
 * @USER: jwang
 * @DATE: 2021/1/29 下午5:31
 */
public class variable_demo {
    public static void main(String[] args) {
        /**
         * - 可变参数
         *      -- 定义一个方法可以接收多个参数，且参数类型一致，可用可变参数简化
         *      -- 修饰符 返回值类型 方法名（参数类型... 变量名）{}
         * - 一个方法只能有一个可变参数
         * - 方法有多个参数，可变参数需要放在最后
         */

        int[] arr = {1,2,3,4,5,6};
        method(arr);
        method(1,2,3,4);
    }

    public static void method(int... nums){
        /**
         * -- 相当于一个数组
         */
        System.out.println(nums[1]);

    }

    public static void method1(String name, int... nums){
        /**
         * -- 相当于一个数组
         */
        System.out.println(nums[1]);

    }
}
