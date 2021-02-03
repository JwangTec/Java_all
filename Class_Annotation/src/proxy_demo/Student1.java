package proxy_demo;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/2/3 下午5:44
 */
public class Student1 implements Happy{

    private String name;

    public Student1(String name) {
        this.name = name;
    }

    public Student1() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student1{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public void happy(){
        System.out.println("stu1-happy");
    }
}
