import java.lang.reflect.Method;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/2/3 下午5:18
 */
public class Annotations_main {
    public static void main(String[] args) throws NoSuchMethodException {
        /**
         * 注解功能：生成帮助文档/执行编译期检查/框架配置
         * 注意每个注解的功能和使用位置
         *
         * 元注解：注解上的注解
         *
         * 注解解析：AnnotationElement接口：getAnnotation(注解的Class) isAnnotationPresent
         *
         */

        @SuppressWarnings("all") //压制忽略警告
        int num = 10;

        //获取method方法上的注解
        //反射获取Method类
        final Class<Annotations_main> c1 = Annotations_main.class;
        final Method method = c1.getDeclaredMethod("method");
        final Annotation_impl an1 = method.getAnnotation(Annotation_impl.class); //获取注解

        System.out.println(an1.str()); //获取属性值
        final boolean b = method.isAnnotationPresent(Annotation_impl.class); //判断属性值是否在方法上


    }

    @Annotation_impl(str="aa")//有属性值必须赋值,只有一个数组且只有一个值属性时可以省略{}
    public static void method(){
        int aa;


    }
}
