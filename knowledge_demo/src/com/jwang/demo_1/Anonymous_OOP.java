package com.jwang.demo_1;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION: 匿名对象
 * @USER: jwang
 * @DATE: 2021/1/28 下午2:01
 */
public class Anonymous_OOP {
    public static void main(String[] args) {

        //普通创建对象
        final Standard_Student student = new Standard_Student();
        //调用方法
        student.show();

        //匿名对象，只能使用一次,没有名字
        new Standard_Student();
        //新的匿名对象调用方法
        new Standard_Student().show();

        method1(student);
        method1(new Standard_Student());
    }

    public static void method1(Standard_Student student){
        //调用方法时，需要传入某个类的对象时，可以传入该类的匿名对象
    }
}
