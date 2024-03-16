package com.jc.差分数组;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Scanner;

public class Main {

    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int n = nextInt();
        int[] p = new int[n + 1];
        int[] t = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = nextInt();
        }
        for (int i = 1; i <= n; i++) {
            t[i] = nextInt();
        }
        int[] ans = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            ans[i] = p[i] - t[i];
        }
        for (int i = n + 1; i > 0; i--) {
            ans[i] = ans[i] - ans[i - 1];
        }
        long res = 0;
        for (int i = 1; i <= n + 1; i++) {
            if (ans[i] > 0) res += ans[i];
        }
        System.out.println(res);
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
