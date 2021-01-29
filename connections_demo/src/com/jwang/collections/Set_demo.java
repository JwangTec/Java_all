package com.jwang.collections;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION: set集合--接口
 * @USER: jwang
 * @DATE: 2021/1/29 下午5:41
 */
public class Set_demo {
    public static void main(String[] args) {
        /**
         * set接口：实现该接口的都是set集合
         *  - 实现类：HashSet:无索引，不能重复，无序
         *          LinkedHashSet:无索引，不能重复，有序
         *          TreeSet:无索引，不能重复，可排序（构造方法中可实现比较器进行重写排序规则方法）
         *  - set集合无特殊功能，都是使用Collection集合的功能
         *  - 遍历：增强for，迭代器
         *  - 保证元素唯一：存储结构为：哈希表结构（8：数组+链表 之后：超过8哥元素：数组+链表+红黑树）
         *                原理：hashcode()和equals()--解决hash冲突方法，
         *  - 有序：链表
         *  Hashset:
         *     -- 存储自定义对象时，需要重写hashCode()和equals()方法
         */
    }
}
