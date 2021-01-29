package com.jwang.demo_7_Permissions;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/1/29 下午12:28
 */
public class P_Person {

    /**
     * 类：public
     * 成员方法/构造方法：public
     * 成员变量：private
     */
    //都可
    public void method(){}
    //不能访问：不同包无关类
    protected void method2(){}
    //不能访问：不同包子类（不同包有继承关系），不同包无关类（无继承关系）
    void method3(){}
    //不能访问：同包，不同包子类，不同包无关类
    private void method4(){}
}
