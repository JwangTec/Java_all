import proxy_demo.Student1;

import java.util.ArrayList;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/2/3 下午6:09
 */
public class function_lambda {
    public static void method(){
        System.out.println("aa");
        System.out.println("aa");
    }

    public static void main(String[] args) {
        /**
         * 引用构造方法： 类型::new
         *    静态方法： 类名::方法名
         *    成员方法： 对象名::成员方法名 --该方法一定是带有参数的
         *    类成员方法： 类名::成员方法名 --成员方法不带参数的
         */
//        refence_pu();

        ArrayList<String> stu1 = new ArrayList<>();
        stu1.add("aa");

        stu1.stream().map((String name)->{return new Student1(name);}).forEach((p)->{
            System.out.println(p);
        });

        stu1.stream().map(Student1::new).forEach(System.out::println);

        stu1.stream().map((String name)->{return Integer.parseInt(name);}).forEach((p)->{
            System.out.println(p);
        });

        stu1.stream().map(Integer::parseInt).forEach(System.out::println); //printStream的成员方法println

        stu1.stream().map(String::length).forEach(System.out::println);


    }

    private static void refence_pu() {
        new Thread(()->{
            System.out.println("aa");
            System.out.println("aa");
        }).start();

        new Thread(()->{
            function_lambda.method();
        }).start();

        new Thread(function_lambda::method).start(); //其执行内容与方法中的一样或者为调用方法，可替换
    }
}
