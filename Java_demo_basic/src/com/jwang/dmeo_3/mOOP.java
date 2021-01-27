package com.jwang.dmeo_3;

/**
 * @PROJECT_NAME: Java_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/1/27 下午5:37
 */
public class mOOP {
    private String name;
    //private修饰成员，本类使用（成员变量，成员方法）
    private int age;

    //成员方法：去掉static，堆内存中存放其成员方法地址和对象的成员变量
    public void study(){
        System.out.println("学习");
    }

    //this：代表本类的对象引用，s1调用则为s1对象

    public void setAge(int age) {
        this.age = age;
    }

    //有参构造方法存在，则无参构造不再默认
    public mOOP(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public mOOP() {
    }
}
