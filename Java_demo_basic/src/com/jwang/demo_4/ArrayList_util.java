package com.jwang.demo_4;

import java.util.ArrayList;

/**
 * @PROJECT_NAME: Java_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/1/27 下午6:52
 */
public class ArrayList_util {
    public static void main(String[] args) {
        final ArrayList list1 = new ArrayList();
        list1.add(1);
        list1.add("as");
        System.out.println(list1);
        list1.add(1,34);
        //删除
        final boolean as = list1.remove("as");
        final Object o = list1.remove(1);

        //修改
        final Object s1 = list1.set(1, 45);
        final Object o1 = list1.get(1);
        final int size = list1.size();

        final ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        System.out.println(list);

    }
}
