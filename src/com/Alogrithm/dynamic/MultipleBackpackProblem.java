package com.Alogrithm.dynamic;

import java.util.Scanner;

public class MultipleBackpackProblem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] v = new int[510];
        int[] w = new int[510];
        int[] s = new int[510];
        int[] dp = new int[6100];
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            v[i] = scanner.nextInt();
            w[i] = scanner.nextInt();
            s[i] = scanner.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= 1; j--) {
                for (int k = 0; k <= s[i] && j >= k*v[i]; k++) {
                    // 从01背包的状态转移方程式，去增加第i个物品拿k个的循环
                    dp[j] = Math.max(dp[j],dp[j-k*v[i]] + k*w[i]);
                }
            }
        }

        System.out.println(dp[m]);
    }

}
