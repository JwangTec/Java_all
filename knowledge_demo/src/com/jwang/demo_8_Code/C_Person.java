package com.jwang.demo_8_Code;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION: 构造代码块
 * @USER: jwang
 * @DATE: 2021/1/29 下午12:39
 */
public class C_Person {
    //构造代码块：每一次调用构造方法都会被执行一次，用于统计创建对象的个数
    {
        System.out.println("构造代码块 其次执行");
    }

    // 只执行一次
    static {
        System.out.println("静态代码块 先执行");
    }

    public C_Person() {
        System.out.println("空参构造方法 最后执行");
    }

    public void method(){

        //局部代码块：节省空间
        {
            System.out.println("局部代码块");
        }

        System.out.println("方法");
    }
}
