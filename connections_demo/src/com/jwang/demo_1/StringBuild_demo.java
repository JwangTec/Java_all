package com.jwang.demo_1;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/1/28 下午7:08
 */
public class StringBuild_demo {
    public static void main(String[] args) {
        /**
         * StringBuild类方法：
         *  拼接：append, 返回对象本身
         *  反转：reverse，返回对象本身
         *  插入：insert
         *
         * StringBuild与String相互转换
         *  String-B：StringBuilder(String str)
         *  B-String: toString()
         */

        String str = "aaaa";
        final StringBuilder sb = new StringBuilder(str);

        String s = sb.toString();
        System.out.println(s);

    }
}
