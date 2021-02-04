package factory_demo;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/2/4 下午4:25
 */
public class test_main {
    public static void main(String[] args) {
        final Car falali = CarFactory.createCar("falali");
        final Car benci = CarFactory.createCar("benci");

        //线程池，动态代理都是工厂模式
    }
}
