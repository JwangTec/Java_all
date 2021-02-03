import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/2/3 下午5:23
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Annotation_impl {
    //属性类型：基本类型、Class类型、String、注解类型、枚举类型
//    byte b();
//    short s();
//    int i();
//
//    Class c();
//
    String str();
//
//    Override o();

//    byte[] bb();
}
