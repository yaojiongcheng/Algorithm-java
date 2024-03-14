package com.jc.求最大公因数和最小公倍数;

import java.util.Scanner;

/**
 * 求最大公因数和最小公倍数
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int gcd = gcd(a,b);
        int lcm = lcm(a,b);
        System.out.println(gcd);
        System.out.println(lcm);
    }

    // 求最小公倍数
    private static int lcm(int a, int b) {
        int k = gcd(a,b);
        return a * b / k;
    }

    // 求最大公因数
    private static int gcd(int a, int b) {
        while (b != 0) {
            int z = a % b;
            a = b;
            b = z;
        }
        return a;
    }

}
