package com.jc.BFS模板二;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/**
 * BFS模板 模板二
 *
模板二：
如果要确定当前遍历到了哪一层，BFS 模板如下。
这里增加了 level 表示当前遍历到二叉树中的哪一层了，也可以理解为在一个图中，现在已经走了多少步了。size 表示在当前遍历层有多少个元素，也就是队列中的元素数，我们把这些元素一次性遍历完，即把当前层的所有元素都向外走了一步

level = 0
while queue 不空：
    size = queue.size()
    while (size --) {
        cur = queue.pop()
        if cur 有效且未被访问过：
            进行处理
        for 节点 in cur的所有相邻节点：
            if 该节点有效：
                queue.push(该节点)
    }
    level ++;
 */
public class Main {

    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static Scanner scanner = new Scanner(System.in);

    public static int n, m, k;
    public static int[][] graph;
    public static Queue<Point> queue = new LinkedList<>();
    public static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    public static Point last;

    public static void main(String[] args) throws IOException {
        n = nextInt();
        m = nextInt();
        k = nextInt();
        graph = new int[n + 1][m + 1];
        for (int i = 0; i < k; i++) {
            int x = nextInt();
            int y = nextInt();
            graph[x][y] = 1;
            queue.offer(new Point(x,y));
        }
        bfs();
        System.out.println(last.x + " " + last.y);
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            if (queue.size() == 1) last = queue.peek();
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = point.x + dx[i];
                int y = point.y + dy[i];
                if (x > n || y > m || x <= 0 || y <= 0 || graph[x][y] == 1) continue;
                graph[x][y] = 1;
                queue.offer(new Point(x,y));
            }
        }
    }

    private static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }

}
