package Enum_demo;

public enum Sex {
    //枚举类型（引用类型之一）
    //枚举值名称需要大写
    //BOY，GIRL--省略格式
    BOY("男"),GIRL("女"); //相当于两个对象，调用其私有方法Sex

    private String name; //该类的成员变量--可以创建上面两个对象

    private Sex(String name) {
        this.name = name;
    }

    public void show(){
        System.out.println("method");
    }
}
