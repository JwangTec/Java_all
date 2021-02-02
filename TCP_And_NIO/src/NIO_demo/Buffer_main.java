package NIO_demo;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/2/2 下午6:38
 */
public class Buffer_main {
    /**
     * nio.Buffer：是一个对象，对基本类型的数组进行封装：ByteBuffer,CharBuffer
     * NIO中通过Buffer读取数据，所有数据通过Buffer来处理，为NIO读写数据的中转池
     *
     *      -ByteBuffer类内部封装了一个byte[]数组，通过一些方法对这个数组进行操作--字节缓冲数组
     *      -创建ByteBuffer对象：
     *          -- 在堆中创建缓冲区：allocate(int capacity - 初始容量) -- 间接缓冲区
     *          -- 系统内存创建：allocateDirect(int capacity) -- 直接缓冲区
     *          -- 数组创建缓冲区：wrap(byte[] arr) --也是在间接缓冲区
     *              --- 都是static方法，返回的为ByteBuffer对象
     *              --- 间接缓冲区创建和销毁高，直接缓冲区工作效率高
     * -- 方法
     *   --- put:可以添加一个字节/一个字节数组/一个指定范围的数组
     *   --- capacity:容量，指Buffer包含的元素最大数量，其定义后不可变
     *   --- limit: 能够读写的最大元素数量，超过的不能使用，其不能为负且不能大于capacity
     *        --- 参数：无参：获取其limit值
     *        --- int NewLimit:设置limit，返回为Buffer对象
     *   --- position：当前可以写入的索引，位置不能小鱼0，并且不能大于capacity --可获取（无参数-当前没有写入数据的第一个索引）和设置（有参数int p）
     *          --- 在指定位置写入字节数据，存在数据覆盖 ，其写的数据在position到limit之间w位置
     *   ---mark：设置此缓冲区的标记为当前的position位置
     *   ---reset：将此缓冲区的位置重置为以前标记的位置
     *   ---clear()：还原缓冲区状态
     *          --position：0
     *          --limit=capacity
     *          --丢弃mark
     *   ---flip（）：缩小limit的范围
     *          --limit=当前position
     *          --当前position=0
     *          --丢弃标记
     */

    public static void main(String[] args) {
        ByteBuffer b1 = ByteBuffer.allocate(15);
        final ByteBuffer b2 = ByteBuffer.allocateDirect(10);

        final byte[] bytes = new byte[12];
        final ByteBuffer wrap = ByteBuffer.wrap(bytes);

        b1.put((byte)10);

//        b1.limit(6);

        byte[] bs = {1,2,3,4,5}; //会报异常，超过limit
        b1.put(bs);
        b1.put(bs,1,1);
        System.out.println(Arrays.toString(b1.array()));
        System.out.println(b1.capacity());

        System.out.println(b1.limit());

        b1.position(5);
        b1.put((byte)100);
        System.out.println(b1.position());
        System.out.println(Arrays.toString(b1.array()));
        b1.clear();

    }
}
