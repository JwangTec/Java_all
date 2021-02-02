package NIO_demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/2/2 下午8:55
 */
public class server_demo {
    public static void main(String[] args) throws IOException {
        final ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress(8888));

        //获取连接通道
        final SocketChannel channel = ssc.accept();

        //堆创建缓冲区
        final ByteBuffer buffer = ByteBuffer.allocate(1024);

        //读取数据
        int len = channel.read(buffer);

        System.out.println(new String(buffer.array(), 0,len));

        ssc.close();

    }
}
