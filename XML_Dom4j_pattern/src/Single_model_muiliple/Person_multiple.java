package Single_model_muiliple;

import java.util.ArrayList;
import java.util.Random;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/2/4 下午3:50
 */
public class Person_multiple {

    //构造私有化
    private Person_multiple() {}
    //固定数量类对象--静态代码块

    private static ArrayList<Person_multiple> list = new ArrayList<>();
    static {
        for (int i = 0; i < 3; i++) {
            Person_multiple p = new Person_multiple();
            list.add(p);
        }
    }
    //静态方法随机获取
    public static Person_multiple getInstance(){
        //Random
        final Random random = new Random();
        final int index = random.nextInt(list.size());
        //取对象
        Person_multiple p = list.get(index);

        //返回
        return p;
    }
}
