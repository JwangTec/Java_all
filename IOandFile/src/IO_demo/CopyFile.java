package IO_demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/2/2 下午12:16
 */
public class CopyFile {
    public static void main(String[] args){
        /**
         * 拷贝文件,jdk7之前IO处理
         */
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("IOandFile/aaa/bb.txt");
            fos = new FileOutputStream("IOandFile/aaa/bbcopy.txt");
            byte[] bu = new byte[8192];
            int len;

            while ((len = fis.read(bu)) != -1){
                fos.write(bu, 0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert fos != null;
                fos.close();

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    assert fis != null;
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
