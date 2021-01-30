package com.jwang.sort_demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION: 排序
 * @USER: jwang
 * @DATE: 2021/1/30 下午4:46
 */
public class sort_demo1 {
    /**
     * 冒泡：length-1-i
     * 选择:j=i+1;length
     * 二分查找：while -- left<= right middle = (left+right)/2 mid-1 or mid+1
     */

    public static void main(String[] args) {
        int[] arr = {1,9,8,6,3,4,5,6};
        method2(arr);
//        method1(arr);
    }

    public static void method1(int[] list){
        System.out.println(Arrays.toString(list));

        for (int i = 0; i < list.length-1; i++) {
            for (int j = 0; j < list.length - 1- i; j++) {
                if (list[j] > list[j+1]){
                    int temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(list));
    }

    public static void method(int[] list){
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = i + 1; j < list.length; j++) {
                if(list[i] > list[j]){
                    int temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }

        //优化-记录索引，比较完之后找到最小值索引再交换

        System.out.println(Arrays.toString(list));
    }

    public static void method2(int[] list){
        for (int i = 0; i < list.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < list.length; j++) {
                if(list[min] > list[j]){
                    min = j;
                }
            }

            if (min != i) {
                int temp = list[i];
                list[i] = list[min];
                list[min] = temp;
            }
        }

        //优化-记录索引，比较完之后找到最小值索引再交换

        System.out.println(Arrays.toString(list));
    }

    public static void method5(int[] arr){
        int left = 1;
        int num = 40;
        int right = arr.length-1;
        while (left <= right){
            int mid = (left + right) / 2;
            if(arr[mid] == num);
        }
    }
}
