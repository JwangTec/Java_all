package ThreadTool_demo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/1/31 下午6:01
 */
public class Tool_main {
    /**
     * -线程池使用
     *      -创建线程池，初始化指定数量的线程
     *      -提交任务，并执行任务
     * Executor:Java线程池的顶级接口，并不是一个线程池，而是执行线程的一个工具
     * ExecutorService:线程池接口--实现进行配置比较复杂
     *      -- 方法：
     *         Future<?> submit(Runnable/Callable<T> task):获取线程池中的某一个线程对象，并执行任务
     *                  Future<?>: 用于记录线程执行完成后的结果
     *                          --get():获取结果
     * Executors:线程工厂提供了一些静态工厂（方法）--生成一些常用线程池方法
     *      -- 方法：
     *          --- ExecutorService newFixedThreadPool(int nThreads):返回线程池对象--创建的是有界线程池--个数可指定最大数量
     *
     */

    public static void main(String[] args) {
        final ExecutorService executorService = Executors.newFixedThreadPool(3);

        final Callable_Runnable runnable = new Callable_Runnable();

        final Future<String> future = executorService.submit(runnable);
        executorService.submit(runnable);
        executorService.submit(runnable);
        executorService.submit(runnable);

        try {
            final String s = future.get();
            System.out.println(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
