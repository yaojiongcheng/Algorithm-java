package com.jc.前后缀分解;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/*
* 前后缀分解
* */
public class Main {

    public static void main(String[] args) throws Exception {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n = (int) st.nval;
        int[] arr = new int[n];
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            st.nextToken();
            arr[i] = (int) st.nval;
        }
        for (int i = 0, p = 1; i < n; i++) {
            ans[i] = p;
            p *= arr[i];
        }
        for (int i = n - 1, p = 1; i >= 0; i--) {
            ans[i] *= p;
            p *= arr[i];
        }
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }

}
