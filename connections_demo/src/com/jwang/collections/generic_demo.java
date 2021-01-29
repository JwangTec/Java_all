package com.jwang.collections;

import java.util.ArrayList;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION: 泛型通配符
 * @USER: jwang
 * @DATE: 2021/1/29 下午4:37
 */
public class generic_demo {
    public static void main(String[] args) {
        /**
         * - 泛型不存在多态
         * - 泛型通配符：？ 表示未知通配符
         * - 泛型通配符的受限
         *          -- 上限： <? extend XX>  只能接收XX类型及其子类类型
         *          -- 下限： <? super XXX>  只能接收XXX类型及其父类类型
         */

        ArrayList<String> str1 = new ArrayList<>();
        ArrayList<Integer> in = new ArrayList<>();
        ArrayList<Object> ob = new ArrayList<>();
        ArrayList<Number> nu = new ArrayList<>();

    }

    public static void method(ArrayList<?> list){
                /*
        接收集合对象的泛型为所有类型
         */
    }

    public static void method1(ArrayList<? extends Number> list){
        /*
        接收集合对象的泛型为Number或者其子类类型
         */
    }
    public static void method2(ArrayList<? super Integer> list){
                /*
        接收集合对象的泛型为Integer或者其父类类型
         */
    }

}
