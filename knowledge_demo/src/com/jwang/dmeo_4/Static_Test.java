package com.jwang.dmeo_4;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/1/28 下午3:59
 */
public class Static_Test {
    /**
     * 静态成员会随着类加载而加载，其存放在方法区的静态区
     */

    // 成员变量：本类所有对象共享。对象.name/类.name
            //定义全局变量时，一般为public和final
    public static final String name = "aaa";

    // 成员方法：类名.方法名()/对象名.方法名()
    /*
    静态方法中不能出现this关键词
    静态方法中不能直接访问非静态成员（变量和方法），可访问静态成员和方法
    非静态可以访问一切成员
    子父类存在一样的静态方法不是方法重写
     */
    public static void show(){
        System.out.println("aaa");
    }

    //静态代码块：类中，方法外，随类加载而执行，只执行一次，先静态再构造，测试类中：先静态后main方法
    //使用场景：加载驱动，全局工具类
    static {
        System.out.println("bbb");
    }
}
