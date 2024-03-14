package com.template;

import java.util.Scanner;

// 求最大子段和
public class MaxSubsegmentsAnd {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] profit = new int[n+1];
        int ans = -999999999;
        for (int i = 1; i < n + 1; i++) {
            profit[i] = scanner.nextInt();
            profit[i] = Math.max(profit[i],profit[i] + profit[i-1]);
            ans = Math.max(profit[i],ans);
        }
        System.out.println(ans);
    }

}
