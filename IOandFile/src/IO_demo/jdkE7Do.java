package IO_demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION: jdk7之后处理异常
 * @USER: jwang
 * @DATE: 2021/2/2 下午12:28
 */
public class jdkE7Do {

    public static void main(String[] args) {
        /*
            tyr-with-resource,保证每个资源在语句结束时自动关闭
            格式：
                try(创建流对象，多个;隔开){}catch(){}
         */
        try (FileInputStream fis = new FileInputStream("IOandFile/aaa/bb.txt");
             FileOutputStream fos = new FileOutputStream("IOandFile/aaa/bbcopy.txt")){

            byte[] bu = new byte[8192]; //使用的数组，返回的为个数。使用int，返回读取的字节
            int len;

            while ((len = fis.read(bu)) != -1){
                fos.write(bu, 0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
