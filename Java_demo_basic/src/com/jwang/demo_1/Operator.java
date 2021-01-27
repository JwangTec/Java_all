package com.jwang.demo_1;

/**
 * @PROJECT_NAME: Java_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/1/27 下午1:55
 */
public class Operator {
    public static void main(String[] args) {
        // 算术运算符 + - * / % 整数/只能得到整数部分
        System.out.println(10 / 3);
        System.out.println(10.0 / 3);

        // 字符串+操作为字符串拼接操作
        System.out.println("121ada" + 1323);
        System.out.println("animal" + 1 + 99);
        System.out.println(1 + 100 + "asd");
        System.out.println("animal" + (5 + 5));

        //自增自减,单独使用无变化，作为操作对象，有变化,在前先运算再操作，在后，先操作再运算
        int a = 1;
        a++;
        System.out.println(a); //2

        int b = 2;
        --b;
        System.out.println(b); //1

        int aa = 10;
        int bb = aa++;
        System.out.println(aa); //11
        System.out.println(bb); //10

        int aaa = 10;
        int bbb = --aaa;
        System.out.println(aaa); //9
        System.out.println(bbb); //9

        int xx = 10;
        System.out.println(xx++); // 10
        System.out.println(xx);  //11

        //赋值运算符 = += -=
        short q = 1;
        q += 1; //等效为：q = (int)(q + 1);

        //关系运算符 == > < !

        //逻辑运算符 &:两边都会进行执行 | ! ^  &&:只要左边执行为假，右边不会继续执行

        //三元运算符

        int m =10;
        int n = 12;
        int max = m > n ? m : n;
        System.out.println(max);






    }
}
