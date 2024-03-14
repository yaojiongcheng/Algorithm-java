package com.jc.归并排序算法模板;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = {12, 5, 7, 9, 8, 65, 54, 21, 7878, 65, 21, 2};
        int[] tmp = new int[arr.length];
        mergeSort(tmp, arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] tmp, int[] q, int l, int r) {
        if (l >= r) return;
        int mid = l + r >> 1;
        mergeSort(tmp, q, l, mid);
        mergeSort(tmp, q, mid + 1, r);
        int k = 0, i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            if (q[i] <= q[j]) tmp[k++] = q[i++];
            else tmp[k++] = q[j++];
        }
        while (i <= mid) tmp[k++] = q[i++];
        while (j <= r) tmp[k++] = q[j++];
        for (i = l, j = 0; i <= r; i++, j++) q[i] = tmp[j];
    }
}
