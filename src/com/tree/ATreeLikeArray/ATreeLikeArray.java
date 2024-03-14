package com.tree.ATreeLikeArray;

import java.util.Scanner;

/**
 * 树状数组
 * 代码短 常数很小
 * 用法:
 *      1. 某个位置上的数加上一个数 单点修改 O(log(n))
 *      2. 求某一个前缀和 区间查询 O(log(n)) => C[x] + C[x-lowbit(x)] + ...
 * 注意:
 *      C[x] x的二进制表示最后有k个零 即 第k层
 *      C[x] = (x - 2的k次方 , x]
 *      lowbit(x) = 2的k次方 = x & -x
 *      C[x] = (x - lowbit(x) , x]
 *      lowbit(x)是x的二进制表达式中最低位的1所对应的值。
 *      x 的父节点是 x + lowbit(x)
 * */
public class ATreeLikeArray {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
    }

    public static void update(int[] arr,int x) {
        for (int i = x; i <= arr.length; i += lowbit(i)) {
            arr[x] += i;
        }
    }

    public static int getSum(int[] arr,int x) {
        int res = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            res += arr[i];
        }
        return res;
    }

    private static int lowbit(int x) {
        return x & -x;
    }

}
