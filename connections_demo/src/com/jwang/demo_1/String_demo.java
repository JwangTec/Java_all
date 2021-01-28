package com.jwang.demo_1;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION: String类
 * @USER: jwang
 * @DATE: 2021/1/28 下午6:55
 */
public class String_demo {
    public static void main(String[] args) {
        /**
         * String类特点：
         *      String类不可变
         *      String类字符串常量对象可以共享
         *      String类底层靠字符数组实现，9底层为字节数组
         * String比较：
         *        equals():比较值
         *        ==：地址值
         */

        String str1 = "ab";
        str1 += "c";
        System.out.println(str1);
        //上面创建了三个字符串对象："ab", "c", "abc"

        System.out.println(".............");

        String s2 = "adf";
        String s3 = "adf";
        System.out.println(s2 == s3);

        System.out.println("............");

        char[] arr = {'a', 'b', 'c'};
        byte[] arr1 = {23,45,67};
        String s4 = new String(arr);
    }
}
