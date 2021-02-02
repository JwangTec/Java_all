package Properties_demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/2/2 下午12:35
 */
public class Properties_main {
    /**
     * Properties类:extend HashTable
     *  -- 可以做map集合使用以及可以结合流加载配置文件（读取配置文件中的数据到内存中）
     *  -- 存储数据是键值队存储，其键和值都为String类型
     *  -- 文本存储数据一般都是键值对
     *
     *  - 构造方法：空参
     *  - 独有方法：
     *      -- setProperty - put
     *      -- getProperty - get
     *      -- stringPropertyNames -keySet
     *  - 操作配置文件
     *      -- 加载配置文件中的数据
     *          - load: 参数：InputStream inStream /Reader reader
     *          - 若配置文件中存在中文用Reader参数
     *      -- 在配置文件中写入数据
     *          - store：把Properties对象中所有键值对写入配置文件中，参数OutputStream Writer
     */

    public static void main(String[] args) throws IOException {
//        method();
        Properties pro  = new Properties();
        final FileInputStream fis = new FileInputStream("IOandFile/aaa/a.txt");
        pro.load(fis);

        fis.close();
        final String root = pro.getProperty("username");
        System.out.println(root);

        final Properties properties = new Properties();
        properties.put("username", "12344");
        final FileOutputStream stream = new FileOutputStream("IOandFile/aaa/a.properties");
        properties.store(stream,"aaad");

        stream.close();


    }

    private static void method() {
        Properties pro  = new Properties();
        pro.setProperty("aa","ss");
        pro.setProperty("aaa","sss");
        System.out.println(pro.getProperty("aaa"));
    }
}
