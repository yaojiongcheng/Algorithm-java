package com.jc.快速幂;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Scanner;

/**
 * 快速幂 求 a ^ b % p
 */
public class Main {

    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        while (n-- > 0) {
            long a = nextLong();
            long b = nextLong();
            long p = nextLong();
            System.out.println(qmi(a, b, p));
        }
    }

    private static long qmi(long a, long b, long p) {
        long res = 1;
        while (b != 0) {
            if (( b & 1) != 0) res = res * a % p;
            b >>= 1;
            a = a * a % p;
        }
        return res;
    }

    private static String nextString() throws IOException {
        st.nextToken();
        return st.sval;
    }

    private static long nextLong() throws IOException {
        st.nextToken();
        return (long) st.nval;
    }

    private static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }

}
