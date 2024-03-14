package com.Math;

import java.util.Scanner;

/**
 * 相关题目: 洛谷P3951
 * 裴蜀定理 a,b 互质(公约数只有1的两个自然数,叫做互质数) 的充分必要条件是 存在整数x,y使ax+by=1.
 * 推论:
 *      如果a,b均是正整数且互质,那么由 ax+by,x>=0,y>=0 不能凑出的最大数是 ab-a-b
 */
public class PeiShuTheorem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long p = scanner.nextLong();
        long q = scanner.nextLong();
        System.out.println(p * q - p - q);
    }

}
