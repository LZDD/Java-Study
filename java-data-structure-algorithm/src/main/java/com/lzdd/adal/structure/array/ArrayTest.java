package com.lzdd.adal.structure.array;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/13 3:43 下午
 **/
public class ArrayTest {
    public static void main(String[] args) {
        // 两种
        //1. new
        int[] array1 = new int[100];
        //2. {}
        int[] array2 = {1,2,23};
        System.out.println(array1.length);
        System.out.println(array2.length);
    }
}
