package com.jc.区间合并;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/*
 * 区间合并
 * 给定 n 个区间 [l,r]，要求合并所有有交集的区间。
 * */
public class Main {

    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static Scanner scanner = new Scanner(System.in);

    public static final int N = 100010;
    public static List<Point> points = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        int n = nextInt();
        for (int i = 0; i < n; i++) {
            int l = nextInt();
            int r = nextInt();
            points.add(new Point(l, r));
        }

        merge();

        System.out.println(points.size());
    }

    private static void merge() {
        List<Point> ans = new ArrayList<>();

        points.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.x - o2.x;
            }
        });

        int st = (int) -2e9, ed = (int) -2e9;
        for (int i = 0; i < points.size(); i++) {
            if (ed < points.get(i).x) {
                if (st != -2e9) {
                    ans.add(new Point(st, ed));
                }
                st = points.get(i).x;
                ed = points.get(i).y;
            } else {
                ed = Math.max(ed,points.get(i).y);
            }
        }
        if (st != -2e9) {
            ans.add(new Point(st,ed));
        }

        points = ans;
    }

    private static String nextString() throws Exception {
        st.nextToken();
        return st.sval;
    }

    private static long nextLong() throws Exception {
        st.nextToken();
        return (long) st.nval;
    }

    private static int nextInt() throws Exception {
        st.nextToken();
        return (int) st.nval;
    }

    private static double nextDouble() throws Exception {
        st.nextToken();
        return st.nval;
    }

}
