package com.jc.二分;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 二分
 */
public class Main {
    private static final StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws Exception {
        int n = nextInt(), m = nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int key = nextInt();
            int p = upperBound(arr, key);
            if (p == -1 || arr[p] != key) {
                builder.append("-1 ");
            } else {
                builder.append(p + 1).append(" ");
            }
        }
        System.out.println(builder);
    }

    public static int upperBound(int[] arr, int key) {
        if (arr[arr.length - 1] < key) return -1;
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (arr[mid] >= key) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return arr[r] >= key ? r : -1;
    }

    public static int nextInt() throws Exception {
        in.nextToken();
        return (int) (in.nval);
    }
}
