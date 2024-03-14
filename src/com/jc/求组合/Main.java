package com.jc.求组合;

import java.util.Scanner;

/**
 * 求组合 C(n,m)
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println(fun(n,m));
    }

    private static long fun(int n, int m) {
        long cnt = 1;
        if (m < n - m) {
            return fun(n,n-m);
        }
        for (int i = 0; i < n-m; i++) {
            cnt *= m + i + 1;
            cnt /= i + 1;
        }
        return cnt;
    }

}
