package Buffered_demo;

import java.io.*;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/2/2 下午12:59
 */
public class Buffered_main {
    public static void main(String[] args) throws IOException {
        /**
         * 字节缓冲流创建：
         *      BufferedInputStream(InputStream in):创建新的缓冲输入流
         *      方法与普通字节输入输出流一样，只是一个增强，具有更高效的读写数据
         * 字符缓冲流：
         *      -构造方法：
         *          BufferedReader/BufferedWriter
         *      -特有方法：
         *          BufferedReader: readLine()：读一行数据,读取文件末尾就返回null
         *          BufferedWriter: newLine():写一行分隔符，由系统属性绝定符号
         *
         */

//        creat_buffered();
//        copyFile_byte();
//        readAll();




    }

    private static void readAll() throws IOException {
        final BufferedReader brd = new BufferedReader(new FileReader("IOandFile/aaa/a.properties"));
//        final String s1 = brd.readLine();
//        System.out.println(s1);
//        brd.close();

        String s;
        while ((s = brd.readLine()) != null){
            System.out.println(s);
        }
        brd.close();
    }

    private static void copyFile_byte() throws IOException {
        final BufferedInputStream bis = new BufferedInputStream(new FileInputStream("IOandFile/aaa/a.txt"));
        final BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("IOandFile/aaa/a.copy.txt"));
        //可以定义一个字节数组，速度更快
        int len;
        while (
                (len = bis.read()) != -1
        ){
            bos.write(len);
        }
        bos.close();
        bis.close();
    }

    private static void creat_buffered() throws FileNotFoundException {
        final BufferedInputStream bis = new BufferedInputStream(new FileInputStream("IOandFile/aaa/a.txt"));
        final BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("IOandFile/aaa/x.txt"));
    }
}
