package com.HighPrecision;

import java.util.Arrays;
import java.util.Scanner;

// 高精度除以高精度
public class Division2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        int[] tmp = new int[305];
        int[] a = init(s1);
        int[] b = init(s2);
        int[] c = new int[305];
        c[0] = a[0] - b[0] + 1;
        for (int i = c[0]; i >= 1; i--) {
            Arrays.fill(tmp,0);
            numcpy(b,tmp,i);
            while (compare(a,tmp) >= 0) {
                c[i]++;
                minu(a,tmp);
            }
        }
        while (c[c[0]] == 0 && c[0] > 0) c[0]--;
        print(c);
        System.out.println();
        print(a);
    }

    private static void print(int[] a) {
        if (a[0] == 0) {
            System.out.println(0);
            return;
        }
        for (int i = a[0]; i > 0; i--) {
            System.out.print(a[i]);
        }
    }

    /**
     * 作减法
     * @param a
     * @param b
     */
    private static void minu(int[] a, int[] b) {
        for (int i = 1; i <= a[0]; i++) {
            if (a[i] < b[i]) {
                a[i+1]--;
                a[i] = a[i] + 10;
            }
            a[i] = a[i] - b[i];
        }
        while (a[a[0]] == 0 && a[0] > 0) a[0]--; // 删除a的前导0，修正a的位数
    }

    /**
     * 返回1表示a>b,返回0表示a=b,返回-1表示a<b
     * @param a
     * @param b
     * @return
     */
    private static int compare(int[] a, int[] b) {
        if (a[0] > b[0]) return 1;
        if (a[0] < b[0]) return -1;
        for (int i = a[0]; i > 0; i--) {
            if (a[i] > b[i]) return 1;
            if (a[i] < b[i]) return -1;
        }
        return 0;
    }

    /**
     * 将p数组整体移动n位到q数组中
     * @param p
     * @param q
     * @param n
     */
    private static void numcpy(int[] p, int[] q, int n) {
        for (int i = 1; i <= p[0]; i++) {
            q[i+n-1] = p[i];
        }
        q[0] = p[0] + n - 1;
    }

    public static int[] init(String s1) {
        int[] a = new int[305];
        char[] c = s1.toCharArray();
        a[0] = c.length;
        for (int i = 0; i < a[0]; i++) {
            a[a[0] - i] = c[i] - '0';
        }
        return a;
    }

}
