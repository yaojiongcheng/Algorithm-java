package com.jc.多重背包模板一;

import java.util.Scanner;

/**
 * @Author JC
 * @description 多重背包模板
 * @Date 2023-10-12 00:16
 * @Version 1.0
 */
public class Main {

    public static final int[] dp = new int[1005];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int t = scanner.nextInt();
        while (n > 0) {
            // 体积
            int w = scanner.nextInt();
            // 价值
            int v = scanner.nextInt();
            // 数量
            int s = scanner.nextInt();
            while (s > 0) {
                for (int j = t; j >= w; j--) {
                    dp[j] = Math.max(dp[j],dp[j - w] + v);
                }
                s--;
            }
            n--;
        }
        System.out.println(dp[t]);
    }

}
