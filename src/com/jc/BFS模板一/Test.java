package com.jc.BFS模板一;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

/*
* BFS模板 模板一
*
模板一：
如果不需要确定当前遍历到了哪一层，BFS 模板如下。

while queue 不空：
    cur = queue.pop()
    if cur 有效且未被访问过：
        进行处理
    for 节点 in cur 的所有相邻节点：
        if 该节点有效：
            queue.push(该节点)

* */
public class Test {

    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static int N = 110, n, m;
    public static int[][] graph = new int[N][N];
    public static int[][] len = new int[N][N];
    public static Point[] points = new Point[N * N];
    public static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        n = nexInt();
        m = nexInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = nexInt();
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {

        int hh = 0, tt = 0;
        points[0] = new Point(0, 0);

        for (int i = 0; i < len.length; i++) {
            Arrays.fill(len[i], -1);
        }
        len[0][0] = 0;

        while (hh <= tt) {
            Point t = points[hh++];
            for (int i = 0; i < 4; i++) {
                int x = t.x + dx[i], y = t.y + dy[i];
                if (x >= 0 && x < n && y >= 0 && y < m && graph[x][y] == 0 && len[x][y] == -1) {
                    len[x][y] = len[t.x][t.y] + 1;
                    points[++tt] = new Point(x, y);
                }
            }
        }
        return len[n - 1][m - 1];
    }

    private static int nexInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }

}

class Point {

    int x;
    int y;

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
