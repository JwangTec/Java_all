package IO_demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/2/1 下午5:32
 */
public class IO_main {
    /**
     * IO:
     *  I:Input --从其他设备读取数据到内存中就是输入
     *  O:Output -- 从内存中写数据到其他存储设备
     * IO分类：
     *      输入流：
     *          字节输入流：以字节为基本单位，进行读
     *          字符输入流
     *      输出流：
     *          字节输出流
     *          字节输入流
     *
     *      字节流
     *      字符流
     *
     * IO顶层父类：
     *      字节输入流：InputStream（抽象类）--子类：FileInputStream
     *      字节输出流：OutputStream       --FileOutputStream
     *      字符输入流：Reader             --FileReader
     *      字符输出流：Writer             --FileWriter
     *          -- idea默认编码utf_8，Windows系统默认编码：ANSI
     *          -- 在简体中文Windows OS中，ANSI代表GBK编码
     *          -- 一个中文在utf-8中占3字节，在GBK编码下占2个字节
     *          -- 读写编码需要一致,不然会乱码
     *
     * 字节流：
     *      字节输出流：OutputStream--抽象类，输出字节输出流的父类，写出数据(字节为基本单位)
     *          常用方法：
     *              -- close:关闭输出流释放资源
     *              -- flush:对于字节流，该方法没影响，close会自动刷新
     *              -- write(byte[] b, int off, int len)
     *          实现子类：FileOutputStream
     *              -- 构造方法：
     *                  --- FileOutputStream(File file，Boolean append)：创建字节输出流，通过File关联目标文件路径
     *                  --- FileOutputStream(String name)
     *                      ----关联目标文件不存在，系统创建一个空文件，存在，append=false系统清空该文件原数据 true则末尾续写
     *                          默认为false
     *              --写出数据 ：使用OutputStream里的方法
     *                  --- 创建字节输出流对象，关联路径
     *                  --- 写数据,可以连续写，不会被覆盖,但是同一个字节输出流
     *                  --- 关 不然会一直关联目标文件
     *              --换行：Windows：/r/n mac:/n unix:/n
     *      字节输入流：InputStream--抽象类，字节输入流的超类，读取数据到内存（字节）
     *          常用方法：
     *              -- read(byte[] b, int off, int len):返回字节或者字节数组，若是字节，返回的是下一个数据字节，达到末尾返回-1
     *              -- close
     *          子类：FileInputStream
     *              --构造方法
     *                  --- FileInputStream(String name)
     *                  --- FileInputStream(File file)
     *                   ----必须传一个文件路径，该路径下没有该文件，会抛异常
     *
     *  字符流：只能操作文本文件，但不会出现中文乱码，字节流可以操作所有文件，但中文会乱码
     *      字符输入流：Reader:字符输入流的超类--抽象类
     *          常用方法：
     *              -- read:读取单个字符或者字符数组，返回字符（ASCIIL码）或者读取的字符个数，末尾返回-1
     *              -- close
     *          子类：
     *              FileReader
     *                  --构造方法，传入的仍是FIle 或者String路径，若该路径下没有该文件则报错
     *                  --读数据
     *      字符输出流：Writer:父类
     *           常用方法：
     *              --write:参数：int c /char[] cbuf /char[] b , int off, int len / String str /String str, int off, int len
     *              --close
     *              --flush
     *           子类：
     *              FileWriter
     *                  -- 构造方法参数：File file / String name / File file, Boolean append(默认false，不同字符输出流对象会进行覆盖)
     *
     *  刷新和关闭：
     *      内置缓存区，如果不关闭输出流或者不刷新缓存区，无法写入文件
     *      close()：该流就关闭了，不能再使用该流对象
     *      flush()：还可以使用该流对象的缓存区
     *
     *
     *
     */

    public static void main(String[] args) throws IOException {
//        OUT_demo();

//        Input_byte(); --

//        Input_arr();

//        Input_readAll(); --
    }

    private static void Input_readAll() throws IOException {
        final FileInputStream f1 = new FileInputStream("IOandFile/aaa/bb.txt");
        byte[] b1 = new byte[2];
        int len;
        while ((len = f1.read(b1)) != -1){
            System.out.println(new String(b1,0,len));
        }

        f1.close();
    }

    private static void Input_arr() throws IOException {
        final FileInputStream f1 = new FileInputStream("IOandFile/aaa/bb.txt");
        byte[] b1 = new byte[2]; //规范：一般文件指定大小8192
        final int read = f1.read(b1); //返回字节数组个数
        System.out.println(read); //2
        System.out.println(Arrays.toString(b1));//  ab
        // 注意读取时，根据字节定义的大小依次读取文件中数据，若读取的小于字节长度，就会替换上一次读取字节数组前面的保留超出的其他字节

        final int read2 = f1.read(b1);
        System.out.println(read2);//1
        System.out.println(Arrays.toString(b1));//  cb--字节数组中只有第一个数据发生改变，第二个仍然是上次读取的数据，转化为字符串为cb

        final int read3 = f1.read(b1);
        System.out.println(read3);//-1
        System.out.println(Arrays.toString(b1));

        f1.close();
    }

    private static void Input_byte() throws IOException {
        final FileInputStream f1 = new FileInputStream("IOandFile/aaa/bb.txt");
//        final int read = f1.read(); //read 用同一个字节输入流会依次读取 相当于一个迭代器，读到末尾返回-1

        int d;
        while ((d = f1.read()) != -1) //先算括号里的，相当于取一个
            {System.out.println(d);}
    }

    private static void OUT_demo() throws IOException {
        final FileOutputStream fileOutputStream = new FileOutputStream("IOandFile/aaa/bb.txt");
        fileOutputStream.write(97); //97》存储的是1的二进制数》打开文件解析（文本为字符）》a

        byte[] by = {97,98,99,100};
        fileOutputStream.write(by);

        fileOutputStream.write(by, 1,2);
        fileOutputStream.close();
    }
}
