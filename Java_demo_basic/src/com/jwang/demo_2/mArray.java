package com.jwang.demo_2;

/**
 * @PROJECT_NAME: Java_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/1/27 下午4:07
 */
public class mArray {
    public static void main(String[] args) {

        //空指针异常 下标越界
        int[] arr = new int[10];
        int arr1[] = new int[12];
        int[] a = new int[]{1,2,3,4,5};
        int[] aa = {1,2,3,4};

        arr1[0] = 1;
        System.out.println(arr1[0]);
        System.out.println(arr1[1]);

        //数组名字.fori
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        //二维数组

        int[] aaa[] = new int[2][3];
        int[][] aaa1 = new int[][]{{11,22},{33,44,66}};
    }
}
