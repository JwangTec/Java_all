package com.jwang.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/1/29 下午4:11
 */
public class Iterator_demo {
    public static void main(String[] args) {
        /**
         * -迭代：Collection集合获取元素的通用方式，首先判断是否有元素可以获取，有就把该元素取出来，一直取完为止
         * -获取迭代器对象：
         *      - 迭代器对象：Iterator对象
         *      - 集合对应的迭代器对象：使用Collection集合中的iterator()方法
         *              -- Iterator<E> iterator();
         *      - Iterator接口常用方法：
         *              -- hashNext()：判断集合是否有元素可迭代
         *              -- next(): 获取元素对象
         * -迭代器原理：指针
         * -增强for循环：底层就是迭代器原理
         *
         * - Collection循环：迭代器，增强for
         * - list集合： 迭代器，增强for， 普通for
         */

        Collection<String> str = new ArrayList<>();
        str.add("11");
        str.add("22");

        // 获取集合对应的迭代器对象, 获取完元素后再获取元素则会报异常,需要重新创建迭代器
        Iterator<String> itr = str.iterator();

        while (itr.hasNext()){
            //在遍历元素期间再往集合中添加或删除元素则并发异常，可以用迭代器对象删除remove方法
            String st = itr.next();
            if(st.equals("11")){
                itr.remove();
            }
            System.out.println(itr.next());
        }

        //增强for  快捷：集合名.for  数组也可以使用
        for (String name : str) {
            //仍然不可添加和删除
            System.out.println(name);
        }
    }
}
