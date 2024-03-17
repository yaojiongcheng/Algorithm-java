package com.jc.离散化;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.*;

/*
* 离散化
* 将 值域 1~1e9 映射到 1e5
* */
public class Main {

    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static Scanner scanner = new Scanner(System.in);

    public static int[] alls;

    public static void main(String[] args) throws Exception {
        Set<Integer> set = new HashSet<>(); // 存储所有离散化的值
        int n = nextInt();
        for (int i = 0; i < n; i++) {
            set.add(nextInt());
        }
        Object[] objects = set.toArray();
        alls = new int[objects.length];
        for (int i = 0; i < objects.length; i++) {
            alls[i] = (int) objects[i];
        }
        Arrays.sort(alls); // 将离散化的值进行排序
        int m = nextInt();
        int idx = getX(m); // 找到第一个大于等于x的值
        System.out.println(alls[idx]);
    }

    private static int getX(int x) {
        int l = 0, r = alls.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (alls[mid] >= x) r = mid;
            else l = mid + 1;
        }
        return r + 1; // 映射到 1,2,...,n
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
