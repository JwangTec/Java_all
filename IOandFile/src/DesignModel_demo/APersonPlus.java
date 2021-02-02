package DesignModel_demo;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION: 装饰类
 * @USER: jwang
 * @DATE: 2021/2/2 下午2:42
 */
public class APersonPlus implements Person{

    private final APerson aPerson;

    public APersonPlus(APerson aPerson) {
        this.aPerson = aPerson;
    }

    @Override
    public void sing() {
        //增强该方法
        System.out.println("A sing plus");
    }

    @Override
    public void dance() {
        aPerson.dance();
    }
}
