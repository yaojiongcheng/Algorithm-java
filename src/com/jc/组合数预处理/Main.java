package com.jc.组合数预处理;

import java.util.Scanner;

/**
 * C(n,m) 组合数预处理
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    arr[i][j] = 1;
                }  else {
                    arr[i][j] = arr[i - 1][j] + arr[i-1][j-1];
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.println("C(" + i + "," + j + ")=" + arr[i][j]);
            }
        }
    }

}
