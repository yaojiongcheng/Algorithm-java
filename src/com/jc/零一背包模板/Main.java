package com.jc.零一背包模板;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.*;

public class Main {

    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int m = nextInt();
        int[] v = new int[n + 1];
        int[] w = new int[n + 1];
        for (int i = 0; i < n; i++) {
            v[i] = nextInt();
            w[i] = nextInt();
        }
        /*int[][] f = new int[n+1][m+1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                f[i][j] = f[i-1][j];
                if (j >= v[i])
                    f[i][j] = Math.max(f[i][j],f[i-1][j - v[i]] + w[i]);
            }
        }*/
        int[] f = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = m; j >= v[i]; j--) {
                f[j] = Math.max(f[j], f[j - v[i]] + w[i]);
            }
        }

        System.out.println(f[m]);
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
