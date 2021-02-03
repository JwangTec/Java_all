package proxy_demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/2/3 下午5:44
 */
public class proxy_main {
    public static void main(String[] args) {
        /**
         * 静态代理模式：代理类实际存在
         * 动态代理模式：动态生成一个代理对象，其代理类不存在
         *      -获取Proxy类(反射包下的)直接生成
         *      -API:newProxyInstance -- static --生成代理对象
         *          参数：被代理类的类加载器，实现的所有接口字节码对象-帮助生成对应代理对象
         *                  InvocationHandler：执行处理接口-监听对象调用方法，需要实现invoke(代理对象调用的方法和传入的实际参数)方法
         */

        Student1 stu1 = new Student1();
        Happy h1 = (Happy) Proxy.newProxyInstance(stu1.getClass().getClassLoader(), stu1.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //代理对象调用方法就会执行invoke方法
                final Object o = method.invoke(stu1);//对传入的method进行增强，参数为被代理对象和方法参数,不增强直接返回该代码即可
                System.out.println("aaa");//进行增强
                return o; //返回为method的返回结果
            }
        });

        h1.happy();
    }
}
