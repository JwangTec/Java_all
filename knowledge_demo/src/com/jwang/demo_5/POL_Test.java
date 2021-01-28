package com.jwang.demo_5;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION: 多态
 * @USER: jwang
 * @DATE: 2021/1/28 下午5:22
 */

abstract class Animal{
    public abstract void eat();
}

class Dog extends Animal{

    @Override
    public void eat() {
        System.out.println("dog eat ...");
    }

    public void home(){
        System.out.println("hone..");
    }
}

class Cat extends Animal{

    @Override
    public void eat() {
        System.out.println("cat eat ...");
    }

    public void home(){
        System.out.println("home..");
    }
}

public class POL_Test {
    /**
     * 行为（方法）的不同表现形式（实现：继承/接口实现）  方法重写 父类引用指向子类的对象：Fu fu = new Zi();
     *     > 多态成员变量：编译和运行都找父类
     *     > 成员方法：非静态方法：编译找父类，运行找子类   静态方法：编译运行找父类
     *     > 父类类型的变量可以接收该父类的所有子类对象，应用：方法的形参
     * 变量多态：无意义
     * 形参：
     * @param args
     */
    public static void main(String[] args) {
        /*
        引用类型转换：
            向上转型：子类类型 向父类转换：自动  父类类型 变量名 = 子类对象
            向下转型：父-子：强制 ： 子类类型 变量名 = （子类类型）父类类型的变量
         */


        //向上
        Animal anl = new Cat();
        anl.eat();

        //向下：解决多态弊端：无法使用子类独有的方法
        //向下转型可能出现类型转换异常，需要使用instancesOf判断,if(变量 instancesOf 数据类型)
        anl = new Dog();
        if(anl instanceof Dog){
            Dog dog = (Dog)anl;
            dog.eat();
            dog.home();
        }

        //传入相关子类对象 形参多态
        Dog dog = new Dog();
        method(dog);
        Animal anl1 = method1(dog);
        Cat cat = new Cat();
        method(cat);
        Animal animal = method1(cat);
    }

    public static void method(Animal anl){
        //形参
        anl.eat();
        if(anl instanceof Dog){
            ((Dog) anl).home();
        }

        if(anl instanceof Cat){
            ((Cat) anl).home();
        }
    }

    public static Animal method1(Animal anl){
        //返回值多态:方法的返回值类型为父类，参数为多态
        return anl;
    }
}
