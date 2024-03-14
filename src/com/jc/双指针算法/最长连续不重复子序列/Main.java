package com.jc.双指针算法.最长连续不重复子序列;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Scanner;

/*
 * 双指针算法
 * 最长连续不重复子序列
 * */
public class Main {

    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int n = nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }
        int[] cnt = new int[(int) (1e5 + 1)];
        int ans = 0;
        for (int i = 0, j = 0; i < n; i++) {
            cnt[arr[i]]++;
            while (cnt[arr[i]] > 1) {
                cnt[arr[j]]--;
                j++;
            }
            ans = Math.max(ans, i - j + 1);
        }
        System.out.println(ans);
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
