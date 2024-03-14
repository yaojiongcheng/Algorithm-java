package com.HighPrecision;

import java.util.Scanner;

public class Addition {

    public static void main(String[] args) {
        int la,lb,lc;

        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();

        int[] a = new int[505];
        int[] b = new int[505];
        int[] c = new int[505];

        la = s1.length();
        lb = s2.length();

        for (int i = 0; i < la; i++) {
            a[la - i] = s1.charAt(i) - '0'; // 将字符转换为数字，并且将字符转置便于计算
        }
        for (int i = 0; i < lb; i++) {
            b[lb - i] = s2.charAt(i) - '0';
        }

        lc = Math.max(la,lb) + 1;

        for (int i = 1; i <= lc; i++) {
            c[i] += a[i] + b[i];
            c[i + 1] = c[i] / 10;
            c[i] = c[i] % 10;
        }

        if (c[lc] == 0 && lc > 0) lc--; // 删除前导0

        for (int i = lc; i > 0; i--) {
            System.out.print(c[i]);
        }

    }

}
