package com.jc.双指针算法.数组元素的目标和;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Scanner;

/*
 * 双指针算法
 * 数组元素的目标和
 * 给定两个升序排序的有序数组 A 和 B，以及一个目标值 x。
 * 请你求出满足 A[i]+B[j]=x 的数对 (i,j)。
 * */
public class Main {

    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int n = nextInt();
        int m = nextInt();
        int x = nextInt();
        int[] arr = new int[n];
        int[] brr = new int[m];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }
        for (int i = 0; i < m; i++) {
            brr[i] = nextInt();
        }
        for (int i = 0, j = m - 1; i < n; i++) {
            while (j >= 0 && arr[i] + brr[j] > x) j--;
            if (arr[i] + brr[j] == x) {
                System.out.println(i + " " + j);
                return;
            }
        }
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
