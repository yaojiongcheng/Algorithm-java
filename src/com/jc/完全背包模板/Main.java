package com.jc.完全背包模板;

import java.util.Scanner;

/**
 * @Author JC
 * @description TODO
 * @Date 2023-10-12 00:10
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] v = new int[n+1];
        int[] w = new int[n+1];
        int[] f = new int[m+1];
        for (int i = 1; i <= n; i++) {
            v[i] = scanner.nextInt();
            w[i] = scanner.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = v[i]; j <= m; j++) {
                f[j] = Math.max(f[j],f[j - v[i]] + w[i]);
            }
        }
        System.out.println(f[m]);
    }
}
