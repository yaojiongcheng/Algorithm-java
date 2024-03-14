package com.jc.字符串哈希哈希表;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Scanner;

/**
 * 字符串哈希 - 哈希表
 * 快速比较两个字符串是否相同
 */
public class Main {

    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static Scanner scanner = new Scanner(System.in);

    public static long P = 131; // 或者13331
    public static long[] arr; // 读入字符串数组
    public static long[] prr; // P数组

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String next = scanner.next();
        char[] chars = new char[next.length() + 10];
        arr = new long[next.length() + 10];
        prr = new long[next.length() + 10];
        prr[0] = 1;
        for (int i = 1; i <= n; i++) {
            chars[i] = next.charAt(i - 1);
        }
        for (int i = 1; i <= n; i++) {
            prr[i] = prr[i - 1] * P;
            arr[i] = arr[i - 1] * P + chars[i];
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int l1 = scanner.nextInt();
            int r1 = scanner.nextInt();
            int l2 = scanner.nextInt();
            int r2 = scanner.nextInt();
            if (fun(l1, r1) == fun(l2, r2)) {
                ans.append("Yes").append("\n");
            } else {
                ans.append("No").append("\n");
            }
        }
        System.out.print(ans);
    }

    private static long fun(int l, int r) {
        return arr[r] - arr[l - 1] * prr[r - l + 1];
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
