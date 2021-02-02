package ObjectStream_demo;

import java.io.Serializable;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/2/2 下午1:49
 */
public class Person implements Serializable {

    //指定序列化的版本ID
    private static final Long serialVersionUID = 4L;
    private String name;

    //不想被序列化的字段
    private transient Integer age;

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
