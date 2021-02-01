package Lambda_demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/2/1 下午1:53
 */
public class Lambda_main {
    /**
     * 创建线程执行任务代码的三种方法
     *      实现Runnable或者继承Thread
     *          创建实现类实现Runnable，重写run方法
     *          创建线程对象，传入任务对象调用start方法执行
     *      匿名内部类方法创建线程执行
     *          创建线程Thread类对象，Runnable接口以匿名内部类作为参数传入，再start
     *      函数式编程创建线程执行
     *          lambda表达式
     *
     * lambda表达式:(参数类型 参数名，。。。)->{代码} -- 只有接口中仅有一个抽象方法才能使用
     *      小括号里的内容要和接口中的抽象方法的参数列表一致
     *      大括号中的代码是当调用该接口的抽象方法才会执行
     *      使用场景：一个接口中只有一个抽象方法，就可以使用其来替换该接口的实现类对象
     *              Runnable接口--只有一个run抽象方法
     *              Comparator比较器接口--只有一个compareTo抽象类
     *
     *       省略格式：
     *              小括号中参数类型可以省略
     *              小括号中只有一个参数，参数类型和小括号可以一起省略
     *              大括号中只有一行代码，无论是否有返回值，大括号，return，；号都可省略
     *       函数式接口：@FunctionInterface
     *       lambda的表现形式：
     *          变量的形式
     *          形参
     *          返回值
     */

    public static void main(String[] args) {
        final Thread p1 = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("自线程："+ i);
            }
        });

        p1.start();

        Runnable rn = ()->{
            System.out.println("变量");
        };

        Comparator<Integer> nu1 = (a,b)->a-b;
        final int compare = nu1.compare(100, 200);//现在才执行

        Comparator<String> nu2 = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        };

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(3);
        Collections.sort(arr, (a, b)->a-b);

        new Thread(()->{
            System.out.println("形参");
        });


    }

    public static Runnable method(){
        return ()->{
            System.out.println("返回值");
        };
    }
}
