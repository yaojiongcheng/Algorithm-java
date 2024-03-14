package com.template;

import java.util.Scanner;

public class FastPower {

    public static long p = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        p = scanner.nextLong();
        System.out.println(a + "^" + b + " mod " + p + "=" + getAns(a, b));
    }

    /**
     * 快速幂
     * @param a
     * @param b
     * @return
     */
    public static long getAns(long a, long b) {
        if (b == 0) {
            return 1;
        }
        long ans = 1;
        while (b > 0) {
            if (b % 2 != 0) ans *= a;
            ans %= p;
            a *= a;
            b /= 2;
        }
        return ans;
    }

}
