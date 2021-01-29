package com.jwang.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION: Collections
 * @USER: jwang
 * @DATE: 2021/1/29 下午5:08
 */
public class Collections_demo {
    public static void main(String[] args) {
        /**
         * -Collections:工具类，对单列集合进行操作
         *   -常用方法：
         *      -- shuffle(List<?> list):打乱集合顺序
         *      -- sort(List<T> list):按照默认顺序排序
         *      -- sort(List<T> list, Comparator<? super T> com) :按照指定顺序排序
         *              --- Comparator:比较器接口，指定排序规则
         */

        ArrayList<Integer> in = new ArrayList<>();
        in.add(1);
        in.add(13);

        System.out.println(in);
        Collections.shuffle(in);
        System.out.println(in);

        //默认升序--集合元素所属的类（例如：Integer）中实现的Comparable接口，重写compareTo()方法
        Collections.sort(in);
        //指定降序, 实现接口--匿名内部类
        Collections.sort(in, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        //自定义排序：只需要在Person类实现其接口并重写compareTo()方法
        final Person p1 = new Person("aa");
        final Person p2 = new Person("bb");
        final Person p3 = new Person("cc");

        ArrayList<Person> list2= new ArrayList<>();
        list2.add(p1);
        list2.add(p2);
        list2.add(p3);

        Collections.sort(list2);

        //指定排序
        Collections.sort(list2, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().length() - o2.getName().length();
            }
        });

        System.out.println(list2);

        ArrayList<String> num = new ArrayList<>();
        Collections.addAll(num, "1", "2", "2");
        System.out.println(num);



    }
}
