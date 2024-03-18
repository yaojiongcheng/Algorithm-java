package com.jc.多路归并;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.*;


/*
* 多路归并
* 给定 n 个有序序列
* 1. 要求把 n 个有序序列合并成一个有序序列
* 2. 返回前 k 个最大/小的数
* */
public class Main {

    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        fun1();
        fun2();
    }

    private static void fun1() {
        // 测试数据
        int[][] data = {
                {1, 3, 5, 7},
                {2, 4, 6, 8},
                {0, 9, 10, 11}
        };
        // 调用多路归并排序方法
        List<Integer> result = kMergeSort(data);
        // 打印结果
        System.out.println(result);
    }

    // 多路归并排序方法
    public static List<Integer> kMergeSort(int[][] data) {
        // 结果集合
        List<Integer> result = new ArrayList<>();
        // 边界条件判断
        if (data == null || data.length == 0) {
            return result;
        }
        // 建立一个优先队列，指定比较器为升序
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        // 将每个子序列的第一个元素加入优先队列中
        for (int i = 0; i < data.length; i++) {
            if (data[i].length > 0) {
                // 每个元素是一个数组，包含三个信息：值，所在行号，所在列号
                queue.offer(new int[]{data[i][0], i, 0});
            }
        }
        // 当优先队列不为空时，循环执行以下操作
        while (!queue.isEmpty()) {
            // 弹出队列顶元素，并将其值添加到结果集合中
            int[] min = queue.poll();
            result.add(min[0]);
            // 如果该元素所在子序列还有下一个元素，则将其加入优先队列中
            if (min[2] + 1 < data[min[1]].length) {
                queue.offer(new int[]{data[min[1]][min[2] + 1], min[1], min[2] + 1});
            }
        }
        // 返回结果集合
        return result;
    }

    private static void fun2() throws Exception {
        int n = nextInt();
        List<Integer>[] lists = new List[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                lists[i].add(nextInt());
            }
        }
        int k = nextInt();
        List<Integer> list1 = topK(lists, k, false);
        List<Integer> list2 = topK(lists, k, true);
        for (int i = 0; i < list1.size(); i++) {
            System.out.print(list1.get(i) + " ");
        }
        System.out.println("\n--------------------------------");
        for (int i = 0; i < list2.size(); i++) {
            System.out.print(list2.get(i) + " ");
        }
    }

    public static List<Integer> topK(List<Integer>[] lists, int k, boolean isMax) {
        PriorityQueue<Integer> queue;
        if (isMax) {
            queue = new PriorityQueue<>(); // 默认是最小堆
        } else {
            queue = new PriorityQueue<>(Comparator.reverseOrder()); // 最大堆
        }

        for (List<Integer> list : lists) {
            for (Integer num : list) {
                if (queue.size() < k) {
                    queue.offer(num);
                } else if (isMax ? queue.peek() < num : queue.peek() > num) {
                    queue.poll();
                    queue.offer(num);
                }
            }
        }

        List<Integer> topKNumbers = new ArrayList<>();
        while (!queue.isEmpty()) {
            topKNumbers.add(queue.poll());
        }

        // 注意返回列表时要反转，因为PriorityQueue是先进先出
        Collections.reverse(topKNumbers);
        return topKNumbers;
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
