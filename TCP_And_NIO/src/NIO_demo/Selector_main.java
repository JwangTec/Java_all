package NIO_demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION: Selector选择器--多路复用
 * @USER: jwang
 * @DATE: 2021/2/2 下午9:07
 */
public class Selector_main {
    public static void main(String[] args) throws IOException {
        /**
         * 多路复用：服务器同时监听多个"端口"的情况，每个端口都要监听多个客户端的连接
         *      将多个Channel注册到一个Selector选择器上--一个Selector可以监听多个Channel发生的事件，减少系统负担，提高执行效率
         * Selector的获取和注册
         *      -获取：通过Selector调用open方法
         *      -注册channel：通过channel的register(Selector sel, int ops)方法注册
         *              -- 参数为选择器和注册监听事件（表示选择监听该channel的什么事件）
         *                  --- 连接就绪 selectionKey.OP_CONNECT
         *                  --- 接收就绪 ..ACCEPT(注册只能使用此项，否则抛异常，同时其channel需设置为非阻塞)
         *                  --- 读就绪
         *                  --- 写就绪
         * Selector的常用方法：
         *      -select：服务器等待客户端连接的方法
         *          阻塞问题：
         *              - 没有客户端连接，阻塞
         *              - 客户端连接成功，没处理请求，非阻塞
         *              - 客户端连接成功，处理请求，阻塞
         *      -selectedKeys：获取已经连接的通道
         *      -keys:获取所有注册的通道
         */

        //创建channel通道，并绑定端口号
        final ServerSocketChannel channel = ServerSocketChannel.open();
        final ServerSocketChannel channel1 = ServerSocketChannel.open();
        final ServerSocketChannel channel2 = ServerSocketChannel.open();

        //建立连接
        channel.bind(new InetSocketAddress(8888));
        channel1.bind(new InetSocketAddress(8887));
        channel2.bind(new InetSocketAddress(8886));

        //设置非阻塞
        channel.configureBlocking(false);
        channel1.configureBlocking(false);
        channel2.configureBlocking(false);
        //获取选择器
        final Selector selector = Selector.open();
        //注册
        channel.register(selector, SelectionKey.OP_ACCEPT);
        channel1.register(selector, SelectionKey.OP_ACCEPT);
        channel2.register(selector, SelectionKey.OP_ACCEPT);

        //循环接收客户端连接
        while (true){
            //等待连接
            selector.select();
            //获取所有被连接的通道
            final Set<SelectionKey> keySet = selector.selectedKeys();
            //遍历所有通道
            //无法删除
//            for (SelectionKey key : keySet) {
//                //获取对应的服务器通道
//               ServerSocketChannel ssc =  (ServerSocketChannel) key.channel();
//               //建立其连接
//                final SocketChannel sc = ssc.accept();
//                final ByteBuffer buffer = ByteBuffer.allocate(1024);
//                final int read = sc.read(buffer);
//                System.out.println(new String(buffer.array(),0,read));
//            }

            final Iterator<SelectionKey> it = keySet.iterator();
            while (it.hasNext()) {
                //获取当前通道名
                SelectionKey key = it.next();
                //使用该通道
                ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                //连接通道
                final SocketChannel sc = ssc.accept();
                //创建字节缓冲区
                final ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                //使用通道获取数据存入缓冲区
                final int len = sc.read(byteBuffer);
                System.out.println(new String(byteBuffer.array(), 0,len));
                sc.close();
                //从所有注册的已连接通道中删除
                it.remove();


            }
        }

    }
}
