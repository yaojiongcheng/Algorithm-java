package com.jc.差分数组;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Scanner;


/**
 * 差分数组 d[i] = a[i] - a[i-1]
 * 将 数组p 变为 数组t
 * 每次只能选择连续的一段区间 +1/-1
 * 求最小操作次数
 */
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
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ans[i] = p[i] - t[i];
        }
        for (int i = n; i > 0; i--) {
            ans[i] = ans[i] - ans[i - 1];
        }
        long res1 = 0;
        long res2 = 0;
        for (int i = 1; i <= n; i++) {
            if (ans[i] > 0) res1 += ans[i];
            else if (ans[i] < 0) res2 += Math.abs(ans[i]);
        }
        System.out.println(Math.max(res1, res2));
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
