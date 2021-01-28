package com.jwang.demo_6;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION: 内部类
 * @USER: jwang
 * @DATE: 2021/1/28 下午6:00
 */
public class Binner_demo {
    private int age;
    private String name;

    //成员内部类
    //访问：外部类名.内部类名 对象名 = new 外部类名().new 内部类名();
    public class Heart{
        //成员变量
        private String name;

        //成员方法
        public void method(){
            System.out.println("aaa");

            //在成员内部类中可以访问外部类的一切成员（包括私有的）
            System.out.println(age);
            method3();

            //同名
            String name = "bbb";
            System.out.println(name);
            System.out.println(this.name);
            System.out.println(Binner_demo.this.name);
        }


    }

    public void method2(){
        //访问成员内部类的成员
//        Binner_demo.Heart bo = new Binner_demo().new Heart();


        Heart h = new Heart();
        System.out.println(h.name);
        h.method();
    }

    private void method3(){
        System.out.println("vvv");
    }
}
