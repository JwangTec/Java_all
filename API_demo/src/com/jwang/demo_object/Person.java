package com.jwang.demo_object;

import java.util.Objects;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/1/29 下午12:52
 */
public class Person {
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        //向下转型，传入对象为父类
        Person person = (Person) o;
        //objects.equals:比较两个字符串内容相同，加了为null的判断，其空指针安全或容忍空指针
                //  return (a == b) || (a != null && a.equals(b))
        //多态，传入为String，使用子类String类的equals方法
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
