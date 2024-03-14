package com.HighPrecision;

import java.util.Scanner;

public class Subtraction {

    public static void main(String[] args) {
        int la, lb, lc;
        Scanner s = new Scanner(System.in);
        int[] a = new int[10090];
        int[] b = new int[10090];
        int[] c = new int[10090];
        String s1 = s.nextLine();
        String s2 = s.nextLine();
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int flag = 0;
        if (!compare(c1, c2)) { // 如果s1 < s2,则交换两个数
            flag = 1;
            c1 = s2.toCharArray();
            c2 = s1.toCharArray();
        }
        la = c1.length;
        lb = c2.length;
        for (int i = 0; i < la; i++) {
            a[la - i] = c1[i] - '0';
        }
        for (int i = 0; i < lb; i++) {
            b[lb - i] = c2[i] - '0';
        }
        lc = Math.max(la,lb);
        for (int i = 1; i <= lc; i++) {
            if (a[i] < b[i]) {
                a[i + 1]--;
                a[i] += 10;
            }
            c[i] = a[i] - b[i];
        }
        while (c[lc] == 0 && lc > 1) lc--;
        if (flag == 1) System.out.print("-");
        for (int i = lc; i > 0; i--) {
            System.out.print(c[i]);
        }
    }

    /**
     * 如果s1 >= s2 ,返回true,否则返回false
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean compare(char[] s1, char[] s2) {
        int u = s1.length, v = s2.length;
        if (u != v) return u > v;
        for (int i = 0; i < u; i++) {
            if (s1[i] != s2[i]) return s1[i] > s2[i];
        }
        return true;
    }

}
