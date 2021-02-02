package TCP_SOCKET.Socket_demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/2/2 下午4:40
 */
public class Server_ServerSocket {
    public static void main(String[] args) throws IOException {
        ServerSocket ss =new ServerSocket(6666);

        //等待客户端连接，如果没有客户端链接，该方法就一直处于运行，有连接成功，则返回socket对象
        final Socket accept = ss.accept();
        System.out.println("server: "+ accept);

        final InputStream inputStream = accept.getInputStream();
        final byte[] bytes = new byte[1024];
        final int read = inputStream.read(bytes);
        System.out.println(new String(bytes,0,read));

        final OutputStream outputStream = accept.getOutputStream();
        outputStream.write("aaa".getBytes());

        accept.close();;
        ss.close();
    }
}
