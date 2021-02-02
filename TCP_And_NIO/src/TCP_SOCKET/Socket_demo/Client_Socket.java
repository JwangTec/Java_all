package TCP_SOCKET.Socket_demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/2/2 下午4:40
 */
public class Client_Socket {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",6666);

        final OutputStream outputStream = socket.getOutputStream();

        outputStream.write("sdasdas ".getBytes());

        final InputStream inputStream = socket.getInputStream();
        final byte[] bytes = new byte[1024];
        final int read = inputStream.read(bytes);
        System.out.println(new String(bytes,0,read));

        socket.close();
    }
}
