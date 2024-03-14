package com.HighPrecision;

import java.util.Scanner;

// 高精度除以低精度
public class Division1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        int[] a = new int[5005];
        int[] c = new int[5005];
        long x = 0;
        long b = Long.parseLong((s2));
        long la = s1.length();
        for (int i = 1; i <= la; i++) {
            a[i] = s1.charAt(i-1) - '0';
        }
        for (int i = 1; i <= la; i++) {
            c[i] = (int) ((x*10 + a[i]) / b);
            x = ((x*10 + a[i]) % b);
        }
        int lc = 1;
        while (c[lc] == 0 && lc < la) lc++; // 删除前导0
        for (int i = lc; i <= la; i++) {
            System.out.print(c[i]);
        }
    }

}

