package ObjectStream_demo;

import java.io.*;
import java.util.ArrayList;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/2/2 下午1:45
 */
public class O_IO_S {
    /**
     * ObjectOutputStream: extend OutputStream,也为字节输出流，写出字节数据
     *      - 将一个对象以字节形式持久化保存到文件中
     *      - 构造方法：ObjectOutputStream(OutputStream out)
     *      - 序列化操作：
     *          writeObject(Object obj): 将指定对象写出
     *              要求序列化的对象所属的类实现Serializable接口标记该对象可以被序列化
     * ObjectInputStream:extend InputStream,字节输入流，读取字节数据
     *      - 读取对象的字节数据，重构对象
     *      - 构造方法：ObjectInputStream(InputStream in)
     *      - 序列化操作：
     *               readObject(Object obj): 读取指定对象
     *               要求序列化的对象所属的类实现Serializable接口标记该对象可以被序列化
     *               序列化对象的所有属性值也是可以被序列化的
     *               如果对象的某个属性不想被序列化，需要将该属性标示为瞬态的，关键字：transient,其打印就是默认值
     *      - 反序列化：
     *              对于JVM可以反序列化对象，它必须能找到class文件的类，否则抛出类未发现异常
     *              能找到class文件，但是其在序列化对象之后发生修改，反序列化会失败，抛出InvalidClassException
     *                  --序列化的时候会为类生成一个UID，前后两者不同则不行
     *                  --在对象中加入serialVersionUID对象即可
     *
     */

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        final ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("IOandFile/aaa/c.txt"));
        ArrayList<Person> list1 = new ArrayList<>();
        list1.add(new Person("aa"));
        list1.add(new Person("bb"));
        list1.add(new Person("cc"));
        oos.writeObject(list1);
        oos.close();

        final ObjectInputStream ois = new ObjectInputStream(new FileInputStream("IOandFile/aaa/c.txt"));
        final Object o = ois.readObject();
        ois.close();
        ArrayList<Person> list2 = (ArrayList<Person>) o;
        for (Person person : list2) {
            System.out.println(person);
        }

    }

}
