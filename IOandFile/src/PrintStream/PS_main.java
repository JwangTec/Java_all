package PrintStream;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/2/2 下午2:26
 */
public class PS_main {
    /**
     * 打印流：PrintStream  extend OutputStream:字节输出流
     *      --方便打印各种数据类型的值，便捷的输出方法
     *      --方法：
     *          --- print(任意类型)：不换行打印
     *          --- println:换行打印
     *      --构造方法：
     *          PrintStream(String fileName):使用指定文件名创建新的打印流
     *          System.out也是一个PrintStream对象
     */

    public static void main(String[] args) throws FileNotFoundException {
        final PrintStream ps = new PrintStream("IOandFile/aaa/d.txt");

        ps.println(92);
        ps.println(100);

        ps.close();
    }

}
