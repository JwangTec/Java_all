package Single_model_muiliple;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/2/4 下午3:34
 */
public class Person {
    //饿汉单例设计模式


    private Person() {
    }

    //内部创建对象.默认值null --懒汉
    private static Person p;

    //饿汉，直接创建对象并返回
    private static final Person p1 = new Person();

    //提供静态方法返回对象--只有使用的时候调用该方法才创建对象
    public static Person getInstance(){
        if(p == null){
            p = new Person();
        }
        return p;


//        return p1;
    }
}
