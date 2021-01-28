package com.jwang.demo_6;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/1/28 下午6:16
 */

abstract class Animal{
    public abstract void eat();
}

class Dog extends Animal{
    @Override
    public void eat() {
        System.out.println("www");
    }
}

public class Binner_demo1 {
    public static void main(String[] args) {

        //右边为子类对象，需要创建一个dog子类
        Animal dog1 = new Dog();
        dog1.eat();

        //匿名内部类， 右边是animal类的匿名内部类（为其子类对象）不需要dog子类
        Animal anl = new Animal() {
            @Override
            public void eat() {
                System.out.println("vvv");
            }
        };
        anl.eat();
    }
}
