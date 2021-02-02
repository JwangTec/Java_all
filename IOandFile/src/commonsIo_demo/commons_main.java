package commonsIo_demo;

import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/2/2 下午3:05
 */
public class commons_main {
    /**
     * IOUtils:封装大量IO读写操作的代码
     *      -主要方法
     *          -- copy(InputStream in, OutputStream out)：拷贝2GB以下的文件
     *          -- copyLarge():2GB以上
     * FileUtils:文件操作的方法
     *      -主要方法：
     *          --copyDirectoryToDirectory(file1, file2):拷贝文件夹
     *          --copyFileToDirectory(File srcFile, File destFile)：拷贝文件到另一个文件夹
     */

    public static void main(String[] args) throws IOException {
        IOUtils.copy(new FileInputStream("IOandFile/aaa/c.txt"), new FileOutputStream("IOandFile/aaa/ccopy.txt"));
    }


}
