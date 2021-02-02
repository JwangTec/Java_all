package DesignModel_demo;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/2/2 下午2:38
 */
public class Model_main {
    /**
     * 装饰着模式：
     *      装饰类与被装饰类必须实现同一个接口
     *      在装饰类中必须传入被装饰类的引用 -- 增强类作为成员变量，并添加构造方法
     *      装饰类中对需要扩展的方法进行扩展 -- 增强方法里编写
     *      装饰类中对不需要扩展的方法调用被装饰类中的同名方法 --相同名方法中调用原对象方法
     */
    public static void main(String[] args) {
        /*
        创建装饰类，实现增强方法
         */

        APerson ap = new APerson();
        APersonPlus app = new APersonPlus(ap);
        app.dance();
        app.sing();
    }

}
