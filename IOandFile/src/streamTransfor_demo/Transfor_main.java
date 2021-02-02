package streamTransfor_demo;

import java.io.*;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/2/2 下午1:29
 */
public class Transfor_main {
    /**
     * InputStreamReader类：io包extend Reader,为字符输入流，也可以使用Reader的方法，是字节转换为字符流的桥梁
     *      其可以指定编码读数据，也可以使用系统默认编码
     *      字节输入流转为字符输入流
     *      构造方法：
     *          InputStreamReader:参数：InputStream in, String charsetName(字符编码)
     *  OutputStreamWriter类：指定编码写 extend Writer
     *      其可以指定编码写数据，也可以使用系统默认编码
     *
     */

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("IOandFile/aaa/aa"),"gbk");

        int len;

        while (
                (len = isr.read()) != -1
        ){
            System.out.println((char)len);
        }

        isr.close();

        final OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("IOandFile/aaa/bb.txt"),"gbk");

        osw.write("中国");
        osw.close();
    }
}
