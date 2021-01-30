package com.jwang.Maps;

import java.util.*;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION: Map<K, V>
 * @USER: jwang
 * @DATE: 2021/1/29 下午6:00
 */
public class Map_demo {
    public static void main(String[] args) {
        /**
         * Map 集合：双列集合顶级父接口，键不可重复，值可重复
         *      -实现类
         *            HashMap:键唯一，无序
         *                    -- hash表保证键唯一
         *                    -- 键为自定义类型，则需要在自定义类中重写hashCode（Object的hashCode计算的地址值）和equals方法
         *            LinkedHashMap：键唯一，键值对有序
         *                     -- hash表，链表
         *            TreeMap：可排序
         *                     --构造方法
         *                          TreeMap:集合的键元素所属的类需要实现Comparable接口并重写compareTo接口
         *                          TreeMap(Comparator<? super K> comparator)
         *      -常用方法
         *             put():指定键值添加，返回被替换的值，无则返回null
         *             remove(Object key)：删除
         *             get(key):获取指定值
         *             containKey(key)
         *             Set<k> keySet():获取所有的键添加到set集合
         *             Collection values()
         *             Set<Map.Entry<K, v>> entrySet():键值对 对象的集合
         *                      Entry<K, v>：Map的内部类接口
         *                              --方法：getKey
         *                                     getValue
         *        -遍历
         *              键找值 keySet() -- 遍历 --get()
         *              键值对对象 entrySet() -- 遍历 --getKey/getValue
         *        -字符串按照字典排序：compareTo()方法
         *
         */

        Map<String, String> map = new HashMap<>();

        map.put("aa", "dd");
        map.put("bb", "ss");

        System.out.println(map.get("aa"));

        System.out.println(map.remove("bb"));

        System.out.println(map.containsKey("aa"));

        map.put("cc", "aa");

        final Set<String> set = map.keySet();
        System.out.println(set);

        final Set<Map.Entry<String, String>> entrySet = map.entrySet();
        System.out.println(entrySet.size());

        for (Map.Entry<String, String> entry : entrySet) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        TreeMap<Integer,String> tr = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        ArrayList<String> str1 = new ArrayList<>();
        str1.add("aa");
        str1.add("ab");
        str1.add("ba");

        Collections.sort(str1, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

    }
}
