import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/2/3 下午4:14
 */
public class GetClass_main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //获取Student类的字节码对象（Class对象）
        Class c1 = Student.class;

        Student stu = new Student();
        Class c2 = stu.getClass();

        Class c3 = Class.forName("Student");

//        System.out.println(c1);
//        System.out.println(c2);
//        System.out.println(c3);

        //每个类只有一个Class对象
//        System.out.println(c1==c2);
//        System.out.println(c1==c3);
//        System.out.println(c2==c3);

        //Class类方法
//        System.out.println(c1.getSimpleName()); //名
//        System.out.println(c1.getName()); //路径
//        final Object o = c1.newInstance(); //关联的相关对象

        //Constructor类：类中每一个构造方法都是一个其对象
        //反射获取 getDeclaredConstructor()
        final Constructor constructor = c1.getConstructor(String.class); //只能获取public  方法
//        System.out.println(constructor);

        final Constructor con2 = c1.getDeclaredConstructor(String.class);
//        System.out.println(con2);

        final Constructor[] dcons = c1.getDeclaredConstructors();

//        for (Constructor dcon : dcons) {
//            System.out.println(dcon);
//        }

        //执行构造方法 newInstance/setAccessible(true:权限检查取消)
        final Object instance = con2.newInstance("name");
        final Constructor c5 = c1.getDeclaredConstructor(int.class);
        c5.setAccessible(true);
        final Object stu3 = c5.newInstance(14);
        System.out.println(stu3);

        //获取成员method --Method类的对象

        //反射获取
        final Method method1 = c1.getDeclaredMethod("method1", int.class);

        final Method[] methods = c1.getDeclaredMethods();

        //执行 Method类方法invoke,参数为类实例对象和方法参数
        //有时候需要设置取消检查：c5.setAccessible(true);
        Student s3 = new Student();
        final Object invoke = method1.invoke(c1.newInstance(), 100);
//        System.out.println(invoke);

        //获取成员变量：Filed类的对象--不需要设置取消检查，可以直接获取
        final Field name = c1.getDeclaredField("name");
        final Field[] fields = c1.getDeclaredFields();
        //赋值 --set 参数：相关对象，值
        //取值 --get
        final Class<?> nameType = name.getType();//获取类型

        //暴力反射，设置取消检查
        name.setAccessible(true);
        final Object ss = c1.newInstance();
        name.set(ss,"aa");
        System.out.println(name.get(ss));


    }
}
