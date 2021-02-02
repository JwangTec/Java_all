package TCP_SOCKET.File_upload_demo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/2/2 下午5:02
 */
public class Server_demo {
    public static void main(String[] args) throws IOException {

        //创建ServerSocket服务器对象
        final ServerSocket ss = new ServerSocket(6666);

        while (true) {
            //调用accept方法接收socket对象
            final Socket socket = ss.accept();
            //通过socket对象获取输入输出流

            new Thread(new Runnable() {
                FileOutputStream fos = null;
                @Override
                public void run() {
                    try {
                        final InputStream sis = socket.getInputStream();
                        //
                        fos = new FileOutputStream("TCP_And_NIO/output/"+ System.currentTimeMillis()+".txt");
                        final byte[] bytes = new byte[8192];
                        int len;
                        while ((len = sis.read(bytes)) != -1){
                            fos.write(bytes, 0, len);
                        }

                        System.out.println("========回写");

                        //通过socket获取输出流
                        final OutputStream sos = socket.getOutputStream();
                        //发送
                        sos.write("文件上传成功".getBytes());

                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        try {
                            if (fos != null) {
                                fos.close();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            ss.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

        }
    }
}
