package com.jwang.demo_5;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION: ACC接口实现
 * @USER: jwang
 * @DATE: 2021/1/28 下午4:33
 */
public class Interface_Impl_ACC implements Interface_ACC{
    /**
     * 多个接口实现用，隔开，且若有父类则先继承再实现
     *
     * 接口 extend 多个父接口 impl 实现多个接口
     * 多个父接口存在相同常量：子接口和实现类不会继承，不能访问
     * 多个父接口中存在相同抽象方法：子接口只会继承一个，实现类需要重写一次
     * 多个父接口存在相同默认方法：子接口需要重写该方法，并需要default关键字。实现类优先使用父类的默认方法
     * 接口不会继承静态方法，实现类只会使用父类静态方法
     */
    @Override
    public void method() {

    }

    @Override
    public void method2() {

    }

    @Override
    public void show() {
        System.out.println("实现类重写默认方法");
    }
}
