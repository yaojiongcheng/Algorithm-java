package com.jc.前缀和;

import java.util.Arrays;
import java.util.Scanner;

/*
* @Author JC
* @description 前缀和
* @Date 2023-10-12 00:16
* @Version 1.0
*/
public class Main{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int i = 1; i < n; i++) {
            arr[i] += arr[i-1];
        }

        System.out.println(Arrays.toString(arr));
    }

}
