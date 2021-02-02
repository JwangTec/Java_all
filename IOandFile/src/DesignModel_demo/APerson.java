package DesignModel_demo;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION: 被装饰类
 * @USER: jwang
 * @DATE: 2021/2/2 下午2:41
 */
public class APerson implements Person{
    @Override
    public void sing() {
        System.out.println("A sing");
    }

    @Override
    public void dance() {

        System.out.println("A dance");
    }
}
