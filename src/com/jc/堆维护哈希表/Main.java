package com.jc.堆维护哈希表;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.*;

/*
* 堆维护 || 哈希表
* */
public class Main {

    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int[] arr = new int[n + 1];
        int[] ans = new int[n + 1];
        int[] cnt = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }

        for (int i = 0; i < n; i++) {
            cnt = new int[n + 1];
            int t = 0;
            for (int j = i; j < n; j++) {
                int x = arr[j];
                cnt[x]++;
                if (cnt[x] > cnt[t] || cnt[x] == cnt[t] && x < t) {
                    t = x;
                }
                ans[t]++;
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    private static double nextDouble() throws IOException {
        st.nextToken();
        return st.nval;
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

}
