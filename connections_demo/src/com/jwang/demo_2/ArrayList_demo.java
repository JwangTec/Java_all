package com.jwang.demo_2;

import java.util.ArrayList;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION: 集合
 * @USER: jwang
 * @DATE: 2021/1/28 下午7:14
 */
public class ArrayList_demo {
    /**
     * ArrayList:
     *      容器，大小可变，引用数据类型（数组存储相同基本或引用数据类型的固定个数元素）
     *  添加元素：
     *      add()
     *   删除元素：若为整形，优先索引
     */

    public static void main(String[] args) {
        ArrayList<String> str1 = new ArrayList<>();

        //创建任意引用数据类型的集合
        ArrayList list1 = new ArrayList();

        //基本数据类型需要转换为对应的包装类型
        ArrayList<Integer> list2 = new ArrayList<>();

        str1.add("asd");
        str1.add(0 , "vvv");
    }




}
