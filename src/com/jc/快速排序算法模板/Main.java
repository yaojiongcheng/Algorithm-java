package com.jc.快速排序算法模板;

import java.util.Scanner;

/**
 * 快速排序算法模板
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[] arr = new int[n];
        String str = scanner.nextLine();
        String[] strings = str.split(" ");
        if (n == 1) {
            System.out.println(strings[0]);
            return;
        }
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(strings[i]);
        }
        quick_sort(arr, 0, n - 1);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append(arr[i]).append(" ");
        }
        System.out.println(stringBuilder);
    }

    private static void quick_sort(int[] arr, int l, int r) {
        if (l >= r) return;
        int i = l - 1, j = r + 1, q = arr[l + r >> 1];
        while (i < j) {
            do i++; while (arr[i] < q);
            do j--; while (arr[j] > q);
            if (i < j) {
                int swap = arr[i];
                arr[i] = arr[j];
                arr[j] = swap;
            }
        }
        quick_sort(arr, l, j);
        quick_sort(arr, j + 1, r);
    }

}
