import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/2/3 下午5:03
 */
public class creat_Stu {

    public static void main(String[] args) throws Exception{
        final Class<Student> stuC = Student.class;
        final Constructor<?>[] constructors = stuC.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println("-------fields-----------");

        final Constructor<Student> constructor = stuC.getDeclaredConstructor(String.class);
        final Student stu1 = constructor.newInstance("jWang");

        final Field[] fields = stuC.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        final Field stu_age = stuC.getDeclaredField("age");
        stu_age.setAccessible(true);
        stu_age.set(stu1, 17);
        System.out.println(stu1);

        System.out.println("----------methods----------");

        final Method[] methods = stuC.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        final Method method1 = stuC.getDeclaredMethod("method1", int.class);
        method1.setAccessible(true);
        final Object re1 = method1.invoke(stu1, 44);
        System.out.println(re1);

    }
}
