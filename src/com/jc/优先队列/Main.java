package com.jc.优先队列;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.PriorityQueue;


/*
* 优先队列
PriorityQueue（优先队列） 采用的是堆排序，
实际上是一个堆（不指定Comparator时默认为最小堆）
队列既可以根据元素的自然顺序来排序，也可以根据 Comparator来设置排序规则。
队列的头是按指定排序方式的最小元素。如果多个元素都是最小值，则头是其中一个元素。
新建对象的时候可以指定一个初始容量，其容量会自动增加。

注意1： 该队列是用数组实现，但是数组大小可以动态增加，容量无限。

注意2： 队列的实现不是同步的。不是线程安全的。如果多个线程中的任意线程从结构上修改了列表， 则这些线程不应同时访问 PriorityQueue实例。保证线程安全可以使用PriorityBlockingQueue 类。

注意3： 不允许使用 null 元素。

注意4： 插入方法（offer()、poll()、remove() 、add() 方法）时间复杂度为O(log(n)) ；remove(Object) 和 contains(Object) 时间复杂度为O(n)；检索方法（peek、element 和 size）时间复杂度为常量。

注意5：方法iterator()中提供的迭代器并不保证以有序的方式遍历优先级队列中的元素。（原因可参考PriorityQueue的内部实现）如果需要按顺序遍历，可用Arrays.sort(pq.toArray())。

注意6： 可以在构造函数中指定如何排序。如：PriorityQueue()
使用默认的初始容量（11）创建一个 PriorityQueue，并根据其自然顺序来排序其元素（使用Comparable）。
PriorityQueue(int initialCapacity)
使用指定的初始容量创建一个 PriorityQueue，并根据其自然顺序来排序其元素（使用 Comparable）。
PriorityQueue(int initialCapacity, Comparator<? super E> comparator)
使用指定的初始容量创建一个 PriorityQueue，并根据指定的比较器comparator来排序其元素。

注意7： 此类及其迭代器实现了 Collection 和 Iterator 接口的所有可选 方法。

PriorityQueue对元素采用的是堆排序，头是按指定排序方式的最小元素。堆排序只能保证根是最大（最小），整个堆并不是有序的。
方法iterator()中提供的迭代器可能只是对整个数组的依次遍历。也就只能保证数组的第一个元素是最小的。

因此使用方法提供iterator()的不保证是以有序的方式遍历优先级队列的元素
* */
public class Main {

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n = (int) st.nval;
        PriorityQueue<Long> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st.nextToken();
            long start = (long) st.nval;
            queue.add(start);
        }
        System.out.println(Arrays.toString(queue.toArray()));
    }

}
