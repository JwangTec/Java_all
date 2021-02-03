package proxy_demo;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/2/3 下午5:47
 */
public class Student2 implements Happy{
    Student1 stu1;

    public Student2(Student1 stu1) {
        this.stu1 = stu1;
    }

    @Override
    public void happy() {
        System.out.println("stu2");
        stu1.happy();
        System.out.println("stu1的事做完了");
    }
}
