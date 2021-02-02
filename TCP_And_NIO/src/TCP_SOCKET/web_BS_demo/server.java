package TCP_SOCKET.web_BS_demo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/2/2 下午5:50
 */
public class server {
    public static void main(String[] args) throws IOException {
//        method_BS();
        final ServerSocket ss = new ServerSocket(9999);

        while (true){
            final Socket socket = ss.accept();
            //图片需要开启线程
            new Thread(new Runnable() {
                @Override
                public void run() {
                    InputStream sis = null;
                    try {
                        sis = socket.getInputStream();
                        //读取一行，只有缓冲字符流有返回一行的方法
                        final BufferedReader br = new BufferedReader(new InputStreamReader(sis));
                        final String s = br.readLine();
                        final String substring = s.split(" ")[1].substring(1);
                        System.out.println(substring);
                        System.out.println(s);

                        final FileInputStream path = new FileInputStream(substring);
                        final OutputStream os = socket.getOutputStream();
                        final byte[] bytes = new byte[8192];
                        int len;

                        os.write("HTTP/1.1 200 OK\r\n".getBytes());
                        os.write("Content-Type:text/txt\r\n".getBytes());
                        os.write("\r\n".getBytes());
                        while ((len = path.read(bytes)) != -1) {
                            os.write(bytes, 0, len);
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        try {
                            assert sis != null;
                            sis.close();
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

    private static void method_BS() throws IOException {
        final ServerSocket ss = new ServerSocket(9999);
        final Socket socket = ss.accept();
        final InputStream sis = socket.getInputStream();

//
//        int len;
//        final byte[] bytes = new byte[9182];
//        while ((len = sis.read(bytes)) != -1){
//            System.out.println(new String(bytes, 0,len));
//        }

        //读取一行，只有缓冲字符流有返回一行的方法
        final BufferedReader br = new BufferedReader(new InputStreamReader(sis));

        final String s = br.readLine();
        final String substring = s.split(" ")[1].substring(1);
        System.out.println(substring);
        System.out.println(s);

        final FileInputStream path = new FileInputStream(substring);
        final OutputStream os = socket.getOutputStream();
        final byte[] bytes = new byte[8192];
        int len;

        os.write("HTTP/1.1 200 OK\r\n".getBytes());
        os.write("Content-Type:text/txt\r\n".getBytes());
        os.write("\r\n".getBytes());
        while ((len = path.read(bytes)) != -1){
            os.write(bytes, 0, len);
        }


        sis.close();
        ss.close();
    }
}
