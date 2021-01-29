package com.jwang.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION: collection
 * @USER: jwang
 * @DATE: 2021/1/29 下午4:04
 */
public class Collection1 {
    public static void main(String[] args) {
        /*
        Collection:单列集合的顶级父接口，子类：list,set
            list:集合元素有序，并且可重复
                  实现类：arrayList/LinkList
            set：集合无序，不可重复
                   实现类：HashSet/LinkedHashset/HashTree
         */
    }

    public static void method(){
        /*
        Collection:
            add()
            clear()
            remove()
            isEmpty()
            size()
         */
        Collection<String> str = new ArrayList<>();
        str.add("qq");
        str.add("dd");

        str.clear();
    }

    public static void List_demo(){
        /**
         * -list接口：
         *      -- 继承Collection接口
         * -特点：
         *      -- 存储有序、可重复、有索引
         * -常用方法
         *      -- add()
         *      -- get()
         *      -- remove
         *      -- set()
         * -list子类：
         *      --ArrayList：存储结构-数组-查询快
         *      --LinkedList：存储结构-链表结构-增删快（双向链表）
         */

        List<String> list1 = new ArrayList<>();

        list1.add("aa");
        list1.add("bb");
        list1.add(1,"cc");
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }

        String removeE = list1.remove(1);

        String sBye = list1.set(1,"gg");
    }
}
