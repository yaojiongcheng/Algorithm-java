package com.jc.矩形操作;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Scanner;

// 判断两个矩形经过 翻转/旋转90度 后是否相等
public class Main {

    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int n = scanner.nextInt();
        scanner.nextLine();
        char[][] x = new char[n][n];
        char[][] y = new char[n][n];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.next().toCharArray();
        }
        for (int i = 0; i < n; i++) {
            y[i] = scanner.next().toCharArray();
        }
        if (check(x, y)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static boolean check(char[][] x, char[][] y) {
        if (Arrays.deepEquals(x, y)) return true;
        for (int i = 0; i < 4; i++) {
            x = rotate(x);
            if (Arrays.deepEquals(x, y)) return true;
        }
        x = flip(x);
        for (int i = 0; i < 4; i++) {
            x = rotate(x);
            if (Arrays.deepEquals(x, y)) return true;
        }
        return false;
    }

    private static char[][] rotate(char[][] x) { // 矩形逆时针旋转90度
        x = flip(x);
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < i; j++) {
                swap(x,i,j,j,i);
            }
        }
        return x;
    }

    private static char[][] flip(char[][] x) { // 矩形翻转
        for (int i = 0; i < x.length; i++) {
            for (int j = 0,k = x.length - 1; j < k; j++,k--) {
                swap(x,i,j,i,k);
            }
        }
        return x;
    }

    private static void swap(char[][] x, int i, int j, int k, int t) {
        char c = x[i][j];
        x[i][j] = x[k][t];
        x[k][t] = c;
    }

    private static String nextString() throws IOException {
        st.nextToken();
        return st.sval;
    }

    private static long nextLong() throws IOException {
        st.nextToken();
        return (long) st.nval;
    }

    private static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }

    private static double nextDouble() throws IOException {
        st.nextToken();
        return st.nval;
    }

}
