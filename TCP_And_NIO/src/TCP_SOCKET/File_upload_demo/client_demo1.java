package TCP_SOCKET.File_upload_demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/2/2 下午5:00
 */
public class client_demo1 {
    public static void main(String[] args) throws IOException {

        //创建socket对象，指定服务器地址
        final Socket socket = new Socket("127.0.0.1", 6666);
        //通过socket获取输出流
        final OutputStream sos = socket.getOutputStream();
        //创建本地输入流
        final FileInputStream fis = new FileInputStream("IOandFile/aaa/ccopy.txt");
        //存储数据数组
        final byte[] bytes = new byte[8192];
        //每次上传大小
        int len;
        //发送
        while ((len = fis.read(bytes)) != -1){
            //依次发送数据
            sos.write(bytes, 0,len);
        }

        //告知服务器不再写数据
        socket.shutdownOutput();


        System.out.println("==========");
        //socket获取输入流
        final InputStream sis = socket.getInputStream();
        final byte[] bytes1 = new byte[1024];
        final int read = sis.read(bytes1);
        System.out.println(new java.lang.String(bytes1,0,read));
        fis.close();
        socket.close();

    }
}
