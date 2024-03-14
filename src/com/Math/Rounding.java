package com.Math;

import java.util.Scanner;

/**
 * 取整
 * a / b向上取整 == (a + b - 1) / b向下取整
 */
public class Rounding {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(a / b);
        System.out.println((a + b - 1) / b);
    }

}
