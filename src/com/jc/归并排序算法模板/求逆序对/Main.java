package com.jc.归并排序算法模板.求逆序对;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Scanner;

/*
 * 求逆序对
 * */
public class Main {

    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static Scanner scanner = new Scanner(System.in);

    public static int[] a, b;


    public static void main(String[] args) throws Exception {
        int n = nextInt();
        a = new int[n];
        b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }
        long res = mergeSort(0, n - 1);
        System.out.println(res);
    }

    private static long mergeSort(int l, int r) {
        if (l >= r) return 0;

        int mid = l + r >> 1;
        long res = mergeSort(l, mid) + mergeSort(mid + 1, r);

        int i = l, j = mid + 1, k = 0;
        while (i <= mid && j <= r) {
            if (a[i] <= a[j]) b[k++] = a[i++];
            else {
                b[k++] = a[j++];
                res += mid - i + 1;
            }
        }

        while (i <= mid) b[k++] = a[i++];
        while (j <= r) b[k++] = a[j++];

        for (i = l, j = 0; i <= r; i++, j++) a[i] = b[j];

        return res;
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
