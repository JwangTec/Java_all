package com.jwang.demo_2;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION: 继承 重写 super
 * @USER: jwang
 * @DATE: 2021/1/28 下午2:14
 */
public class OOP_Student extends OOP_Person{

    /*
    继承需要注意逻辑意义
    继承为单继承，只能继承一个

    访问规则：
        1。 构造方法不能被继承
        2。父类私有成员和方法可以继承但不能被访问（权限）
        3。非私有成员和方法都可以继承和访问（public）
        4。优先访问子类的相关方法，再向上级查找
     */


    /*
    1.重写为父子间关系
    2。返回值，方法名，参数一样
    3。权限修饰符可以不一样，但权限要大于父类的权限
    4。重写用注解标示
     */

    public OOP_Student(){
        //需要放在第一行
        super();
        /*
        注意：
            1。super访问成员变量和成员方法直接在父类查找，一直向上
            2。子类构造方法默认调用父类空参构造方法即super()，若父类无空参构造，则报错
                   可以自己写一个构造方法带调用父类存在的构造方法
         */
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("子类进行方法加强");
    }
}
