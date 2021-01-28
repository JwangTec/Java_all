package com.jwang.demo_5;

public interface Interface_ACC {

    //常量 默认修饰符  public static final
    //访问：接口直接访问，实现类也可以访问
        //多个父接口中有相同常量：实现类对象不能访问（不能继承）
    public static final int num = 10;
    int num1 = 20;

    //抽象方法 默认修饰符：public abstract
    //供实现类重写
    //多个相同抽象方法：重写一次即可
    public abstract void method();
    void method2();

    //默认方法 默认修饰符 public
    //实现类对象调用接口中的默认方法
    //多个默认方法：实现类对象需要重写一次该方法
    public default void show(){
        System.out.println("aaa");
    }

    //静态方法 默认修饰符：public
    //接口名直接访问接口中的静态方法，实现类对象不能调用
        //  多个静态方法无影响，其属于接口的
    public static void show2(){
        System.out.println("bbb");
    }

    //私有方法:private 9以上
    //只能在接口中调用
}
