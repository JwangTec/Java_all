package com.jwang.demo_3;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION: 抽象类
 * @USER: jwang
 * @DATE: 2021/1/28 下午3:04
 */
public abstract class OOP_abstract_Student {

    /*
    抽象类不能创建对象，做父类
    存在抽象方法和普通类的相关元素
     */

    private String name;
    private int age;

    //供子类进行对象初始化使用,super(实参);继承其相关父类的属性
    public OOP_abstract_Student() {
    }

    public OOP_abstract_Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

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

    public void show(){
        System.out.println(age+"+"+name);
    }

    /*
    抽象方法:无返回体，abstract修饰，有返回值和参数
            供子类重写
     */
    public abstract void show1();
}
