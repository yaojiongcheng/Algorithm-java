package com.JosephRing;

/**
 * 约瑟夫环
 */
public class JosephRing {

    public static void main(String[] args) {
        int n = 1;
        int m = 1;
        System.out.println(getLive(n, m));
    }

    /**
     * 给定的编号是 1~n 的情况下，数到m就出局
     * @param n
     * @param m
     * @return
     */
    public static int getLive(int n,int m) {
        if (n == 1) return 1;
        return (getLive(n - 1,m) + m - 1) % n + 1;
    }

}
