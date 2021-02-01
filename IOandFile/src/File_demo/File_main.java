package File_demo;

import java.io.File;
import java.io.IOException;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/2/1 下午4:34
 */
public class File_main {
    /**
     * File类：
     *      文件和目录路径名的抽象表示，用于其创建、查找、删除等操作
     *      构造方法：路径不一定存在
     *          -- File(String pathname):将给定的字符串转换为抽象路径名来创建新的File实例
     *          -- File(String parent, String child):父路径名字和子路径名字字符床创建实例
     *          -- File(File parent, String chile):父类抽象路径名和子类路径名字符串创建
     *      成员方法：
     *          获取：
     *              - getAbsolutePath：File的绝对路径字符串
     *              - getAbsoluteFile:返回的为File对象的字符串
     *              - getPath：将File转换为路径字符串--构造路径
     *              - getName：文件或目录名称
     *              - Length:文件长度，不能获取文件夹的大小,文件大小需要遍历文件夹获取
     *
     *          判断
     *              - exists:file是否实际存在
     *              - isDirectory:是否是目录
     *              - isFile:是否为文件
     *                  --只对路径存在的文件有效
     *
     *          创建和删除
     *              - creatNewFile:只有该名称的文件不存在时，创建一个新的空文件,没有后缀也会创建
     *              - delete：删除此文件和目录,但不能删除非空文件夹
     *              - mkdir：创建目录
     *              - mkdirs： 创建目录，包括不存在的父目录
     *
     *          遍历：
     *              -list():返回一个String数组，表示file目录中所有子文件或子目录的名称 -- 名称
     *              -listFiles()：返回一个File数组，存储所有子文件和目录的路径的file对象--绝对路径
     *                  -- 若文件夹路径不存在，会返回null，遍历数组报空指针异常
     *                  -- 若文件路径无访问权限，会返回null，遍历数组报空指针异常
     *
     *
     *      相对路径：相当于项目路径而言 此处相当于/Users/jwang/Desktop/Java_stu_all
     *
     * 递归：在当前方法内调用自己
     *      - 递归要有出口（结束方法），否则会报栈内存溢出
     *      - 递归出口不能太晚
     *      - 文件搜索
     *          -- 创建file对象
     *          -- 定义方法获取目录路径下所有。Java
     *          -- 调用
     */
    public static void main(String[] args) throws IOException {
//        File_demo();
//        method1();
//        cm_file_demo();
//        get_fileAll();

        final File file = new File("../");
        find_javaFile(file);

    }

    public static void find_javaFile(File file){
        final File[] files = file.listFiles();
        if(files != null){
            for (File file1 : files) {
                if(file1.isFile() && file1.getName().endsWith(".java")){
                    System.out.println(file1);
                }
                find_javaFile(file1);
            }
        }
    }

    private static void get_fileAll() {
        File file1 = new File("IOandFile/aaa");
        final String[] list = file1.list();
        for (String s : list) {
            System.out.println(s);
        }

        final File[] files = file1.listFiles();
        for (File file : files) {
            System.out.println(file);
        }
    }

    private static void cm_file_demo() throws IOException {
        File file1 = new File("IOandFile/aaa/bb.txt");
        System.out.println(file1.exists());

        final boolean newFile = file1.createNewFile();
        System.out.println(newFile);
        System.out.println(file1.exists());

        final boolean delete = file1.delete();
        System.out.println(delete);
    }

    private static void method1() {
        File file1 = new File("IOandFile/aaa/aa");
        System.out.println(file1.getAbsoluteFile());  ///Users/jwang/Desktop/Java_stu_all/IOandFile/aaa/aa
        System.out.println(file1.getPath()); //构造方法传入的路径 IOandFile/aaa/aa
        System.out.println(file1.getName());
        System.out.println(file1.length());
    }

    private static void File_demo() {
        File file1 = new File("/File_demo/aa.jpg");
        File file2 = new File("/File_demo", "aa.jpg");
        System.out.println(file1);
        System.out.println(file2);

        File parent = new File("/File_demo"); //文件夹
        File file3 = new File(parent,"aa.jpg");  //文件
    }
}
