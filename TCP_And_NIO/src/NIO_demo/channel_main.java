package NIO_demo;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/2/2 下午7:49
 */
public class channel_main {
    /**
     * channel:通道，通过该对象可以读取和写入数据，可以当作io中的流，但其是双向的，即可调用读取的方法，也可以调用写出的方法
     *      -类型：
     *          --FileChannel:从文件读写数据 --抽象类 输入输出流 --读写效率未提高
     *              -- 获取子类：FileInputStream或者FileOutputStream的getChannel()方法获取其子类FileChannel对象
     *          --DatagramChannel:读写UDP网络协议数据 DatagramPackage
     *          --SocketChannel:读写TCP数据 Socket
     *          --ServerSocketChannel：监听TCP连接 ServerSocket
     *
     * FileChannel结合MappedByteBuffer实现高效读写
     *      ByteBuffer：
     *          --其子类MappedByteBuffer
     *                  --将文件直接映射至内存，把硬盘中的读写变成内存中的读写（2GB以下）
     *          --获取子类：FileChannel调用map(MapMode mode,Long position,Long size)方法
     *                  --mode :读还是写模式 "r" "w"
     *      Channel:
     *          -- RandomAccessFile:获取指定映射模式的channel
     *                  --mode :读还是写模式 "r"-读 "rw"-读写
     *
     * SocketChannel和ServerSocketChannel创建连接
     *
     *      SocketChannel类：相当于socket
     *          -- 使用SocketChannel.open()打开通道
     *          -- 使用SocketChannel实例方法connect(SocketAddress add)
     *                  ---SocketAddress: new InetSocketAddress() ip地址对象
     *      ServerSocketChannel:相当于serverSocket
     *          -- .open()：得到channel对象
     *          -- 其实例方法.bind(SocketAddress add):绑定本机监听端口，准备接收连接，参数为端口号
     *          -- 调用实例方法：accept()接收请求，建立连接
     *
     */

    public static void main(String[] args) throws IOException {
//        fileChannelDemo();
//        channel_upload_map();

        //建立socketChannel对象
        final SocketChannel channel = SocketChannel.open();
        channel.connect(new InetSocketAddress("127.0.0.1", 8888));

        final ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(("aasaadd").getBytes());

        //重置position
        buffer.flip();
        channel.write(buffer);
        channel.close();


    }

    private static void channel_upload_map() throws IOException {
        //创建RandomAccessFile对象
        final RandomAccessFile r1 = new RandomAccessFile("TCP_And_NIO/output/aa.txt", "r");
        final RandomAccessFile rw = new RandomAccessFile("TCP_And_NIO/output/aacopy.txt", "rw");
        //获取指定模式的映射channel,
        final FileChannel c1 = r1.getChannel();
        final FileChannel c2 = rw.getChannel();


        //获取文件字节大小
        final long size = c1.size();

        //每次映射的大小
        long everySize = 1024*1024*500;

        //需要映射的次数
        long count = size % everySize == 0 ? size/everySize:size/everySize+1;

        for (long i = 0; i < count; i++) {
            //开始映射的位置position
            long start = i*everySize;
            //每次实际映射的大小size
            long trueSize = size - start >= everySize ? everySize : size - start;
            //把数据源文件中数组映射到映射缓冲数组中
            final MappedByteBuffer m1 = c1.map(FileChannel.MapMode.READ_ONLY, start, trueSize);
            //得到缓冲数组
            final MappedByteBuffer m2 = c2.map(FileChannel.MapMode.READ_WRITE, start, trueSize);
            for (long j = 0; j < trueSize; j++) {
                //获取m1映射缓冲数组中字节
                byte b = m1.get();
                //把获取的字节存入m2
                m2.put(b);
            }
        }

        c2.close();
        c1.close();
        rw.close();
        r1.close();

//        //获取文件字节大小
//        final long size = c1.size();
//        //把数据源文件中数组映射到映射缓冲数组中
//        final MappedByteBuffer m1 = c1.map(FileChannel.MapMode.READ_ONLY, 0, size);
//        //得到缓冲数组
//        final MappedByteBuffer m2 = c2.map(FileChannel.MapMode.READ_WRITE, 0, size);
//
//        for (long i = 0; i < size; i++) {
//            //获取m1映射缓冲数组中字节
//            byte b = m1.get();
//            //把获取的字节存入m2
//            m2.put(b);
//        }
    }

    private static void fileChannelDemo() throws IOException {
        final FileInputStream fis = new FileInputStream("TCP_And_NIO/output/aa.txt");
        final FileChannel fisChannel = fis.getChannel();

        final FileOutputStream fileOutputStream = new FileOutputStream("TCP_And_NIO/output/ab.txt");
        final FileChannel osc = fileOutputStream.getChannel();


        final ByteBuffer byteBuffer = ByteBuffer.allocate(8192);

        while (fisChannel.read(byteBuffer) != -1){
            byteBuffer.flip(); //position:0 limit:之前position 位置
            osc.write(byteBuffer); //写position-limit之间的数据
            byteBuffer.clear(); //position:0, limit=capacity=8192
        }

        fis.close();
        fileOutputStream.close();
        fisChannel.close();
        osc.close();
    }
}
