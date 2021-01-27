package com.jwang.demo_1;

import java.util.Random;
import java.util.Scanner;

/**
 * @PROJECT_NAME: Java_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/1/27 下午2:33
 */
public class Control {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();


        if (age % 18 == 2) {
            System.out.println("success");
        } else if (age < 17) {
            System.out.println("success");
        } else {
            System.out.println("su");
        }

        //case值不能重复,且只能是常量,无break则直接穿透到有break的地方，且case不再有匹配效果,
        //循环前取名即标号，break/continu 标号名；可跳到指定循环外
        ab:
        switch (age) {
            case 18:
            case 11:
            case 13:
                System.out.println("as");
                break ab;
            case 12:
                System.out.println("a");
                break;
            default:
                System.out.println("end");
                break;
        }

        for (int i = 0; i < 2; i++) {
            if (i == 5) {
                continue;
            }
            if (i == 1) {
                break;
            }
            System.out.println("i:" + i);
        }

        while (age < 17) {
            System.out.println(age);
            age++;
        }

        do {
            System.out.println(age);
            age--;
        } while (age > 15);

        final Random random = new Random();
        int num = random.nextInt(10);
        System.out.println(num);
    }
}
