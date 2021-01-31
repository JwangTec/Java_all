package atomic_demo;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/1/31 下午4:08
 */
public class Atomic_demo {

    /**
     * atomic包：解决三个安全性问题
     *      AtomicInteger类：
     *          --构造方法：
     *          --成员方法：
     *              ---getAndIncrement():自增
     *          --工作原理：CAS机制：比较并交换
     *              --- 拷贝的值与主内存的值比较，相等则继续操作，不相等则交换
     *       AtomicIntegerArray类：
     *
     *
     */
    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            new Th_Atomic().start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < Th_Atomic.num2.length(); i++) {
            System.out.println(Th_Atomic.num2.get(i)+" ");
        }
    }
}
