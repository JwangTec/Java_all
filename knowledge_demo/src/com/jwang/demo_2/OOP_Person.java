package com.jwang.demo_2;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION: 标准类 this
 * @USER: jwang
 * @DATE: 2021/1/28 下午2:12
 */
public class OOP_Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void eat(){
        System.out.println("eat...");
    }

    public void drink(){
        System.out.println("drink");
    }

    public void show(){

        /*
        this:
            访问本类成员变量：this.本类成员变量名
            本类成员方法：this.本类成员方法名（实参）；一般不用（省略this）
            本类构造方法：
                空参：this()
                有参：this(实参)
                注意：构造方法之间不能相互同时调用
                     调用本类的构造方法需要在第一行，且只能是本类的构造方法
                     本类普通方法不能使用

         */
        int age;
        System.out.println(this.age);
        drink(); //this.drink();
    }

    public OOP_Person() {
    }

    public OOP_Person(String name, int age) {
        this();
        this.name = name;
        this.age = age;
    }
}
