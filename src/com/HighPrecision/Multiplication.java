package com.HighPrecision;

import java.util.Scanner;

public class Multiplication {

    public static void main(String[] args) {
        int[] a = new int[10090];
        int[] b = new int[10090];
        int[] c = new int[10090];
        Scanner s = new Scanner(System.in);
        char[] c1 = s.nextLine().toCharArray();
        char[] c2 = s.nextLine().toCharArray();
        int al = c1.length;
        int bl = c2.length;
        int cl = al + bl;
        for (int i = 0; i < al; i++) {
            a[al - i] = c1[i] - '0';
        }
        for (int i = 0; i < bl; i++) {
            b[bl - i] = c2[i] - '0';
        }
        for (int i = 1; i <= al; i++) {
            for (int j = 1; j <= bl; j++) {
                c[i+j-1] += a[i] * b[j];
                c[i+j] += c[i+j-1] / 10;
                c[i+j-1] %= 10;
            }
        }
        while (cl > 1 && c[cl] == 0) cl--;
        for (int i = cl; i > 0; i--) {
            System.out.print(c[i]);
        }
    }

}
