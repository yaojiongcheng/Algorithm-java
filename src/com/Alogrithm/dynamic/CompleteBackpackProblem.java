package com.Alogrithm.dynamic;

import java.util.Scanner;

public class CompleteBackpackProblem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();  // 背包容量
        int n = scanner.nextInt(); // 物品个数
        int[] w = new int[50]; // 物品容量
        int[] c = new int[50]; // 物品价值
        int[] dp = new int[210];
        for (int i = 1; i <= n; i++) {
            w[i] = scanner.nextInt();
            c[i] = scanner.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = w[i]; j <= m; j++) { // 顺向
                // dp[i][j] = max(dp[i-1][j],dp[i][j-w[i]]+c[i])
                dp[j] = Math.max(dp[j],dp[j-w[i]] + c[i]);
            }
        }

        System.out.println(dp[m]);
    }

}
