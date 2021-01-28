package com.jwang.demo_3;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION: 抽象类继承
 * @USER: jwang
 * @DATE: 2021/1/28 下午3:13
 */
public class OOP_Impl_Student extends OOP_abstract_Student{
    private String sex;

    //子类为普通类必须重写父类所有抽象方法，子类为抽象类则不用
    @Override
    public void show1() {

    }

    public OOP_Impl_Student(String name, int age) {
        super(name, age);
    }

    public OOP_Impl_Student(String name, int age, String sex) {
        super(name, age);
        this.sex = sex;
    }
}
