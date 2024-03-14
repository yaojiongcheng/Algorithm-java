package com.tree.ATreeLikeArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 动态求连续区间和
 *      给定n个数组成的一个数列，规定有两种操作，一是修改某个元素，二是求子数列[a,b]的连续和.
 */
public class Temp1 {

    public static int n = 0;
    public static int[] arr = new int[1000010];
    public static int[] tr = new int[1000010];


    public static void main(String[] args) throws IOException {
        StreamTokenizer streamTokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        streamTokenizer.nextToken();
        n = (int) streamTokenizer.nval;
        streamTokenizer.nextToken();
        int m = (int) streamTokenizer.nval;
        for (int i = 1; i <= n; i++) {
            streamTokenizer.nextToken();
            arr[i] = (int) streamTokenizer.nval;
        }
        for (int i = 1; i <= n; i++) {
            add(i,arr[i]);
        }

        while (m > 0) {
            streamTokenizer.nextToken();
            int k = (int) streamTokenizer.nval;
            streamTokenizer.nextToken();
            int x = (int) streamTokenizer.nval;
            streamTokenizer.nextToken();
            int y = (int) streamTokenizer.nval;
            if (k == 0) {
                System.out.println(query(y) - query(x - 1));
            } else {
                add(x,y);
            }
            m--;
        }
    }

    public static int query(int x) {
        int res = 0;
        for (int i = x; i != 0 ; i -= lowbit(i)) {
            res += tr[i];
        }
        return res;
    }

    public static void add(int x,int v) {
        for (int i = x; i <= n; i += lowbit(i)) {
            tr[i] += v;
        }
    }

    public static int lowbit(int x) {
        return x & -x;
    }

}
