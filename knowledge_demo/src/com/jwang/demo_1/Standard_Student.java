package com.jwang.demo_1;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION: 标准类
 * @USER: jwang
 * @DATE: 2021/1/28 下午1:43
 */
public class Standard_Student {

    // 成员变量
    private String username;
    private int age;


    //s/g方法
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //空参构造
    public Standard_Student() {
    }

    //全参构造
    public Standard_Student(String username, int age) {
        this.username = username;
        this.age = age;
    }

    //私有方法
    private void show1(){
        System.out.println("Standard_Student{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}');
    }

    //  公共方法
    public void show(){
        show1();
    }

    //成员方法
    @Override
    public String toString() {
        return "Standard_Student{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
