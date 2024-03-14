package com.cPlusPlus;
import java.util.*;

public class NEXT_PERMUTATION {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        input.close();
        //C++STL库algorithm中使用next_permutation(a,a+n)能够获得比原序列字典序大1的序列
        // next_permutation(a,a+n);
        next_permutation(a);
        for (int i = 0; i < n; i++) {
            System.out.printf("%d ", a[i]);
        }
    }

    private static void next_permutation(int[] a) {
        int n = a.length;
        if (n == 1) {
            return;
        }
        int pivot = n - 2;
        while (pivot >= 0 && a[pivot] >= a[pivot + 1]) {
            pivot--;
        }
        if (pivot < 0) {
            reverse(a,0,n-1);
            return;
        }
        int lg = pivot + 1;
        while (lg < n && a[lg] > a[pivot]) {
            lg++;
        }
        swap(a,pivot,lg - 1);
        reverse(a,pivot + 1, n - 1);
    }

    private static void reverse(int[] a, int l, int r) {
        while (l < r) swap(a,l++,r--);
    }

    private static void swap(int[] a, int l, int r) {
        int tmp = a[l];
        a[l] = a[r];
        a[r] = tmp;
    }

}

