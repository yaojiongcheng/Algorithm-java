package com.jc.双指针算法.判断子序列;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Scanner;

/*
 * 双指针算法
 * 判断子序列
 * 请你判断 a 序列是否为 b 序列的子序列。
 * */
public class Main {

    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int n = nextInt();
        int m = nextInt();
        int[] arr = new int[n];
        int[] brr = new int[m];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }
        for (int i = 0; i < m; i++) {
            brr[i] = nextInt();
        }
        int i = 0,j = 0;
        while (i < n && j < m) {
            if (arr[i] == brr[j]) i++;
            j ++;
        }
        if (i == n) System.out.println("Yes");
        else System.out.println("No");
    }

    private static String nextString() throws Exception {
        st.nextToken();
        return st.sval;
    }

    private static long nextLong() throws Exception {
        st.nextToken();
        return (long) st.nval;
    }

    private static int nextInt() throws Exception {
        st.nextToken();
        return (int) st.nval;
    }

    private static double nextDouble() throws Exception {
        st.nextToken();
        return st.nval;
    }

}
