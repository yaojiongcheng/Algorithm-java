package com.GetMaxGbOrMinGy;

public class GetMaxGbOrMinGy {

    private static long getMinGb(long a, long b) {
        if (a < b) {
            long temp = a;
            a = b;// 大值放在a的位置上
            b = temp;// 小值放在b的位置上
        }
        for (long i = a; i > 0; i++)// i从题目给的两个数的最大的那个数开始递增
        {
            if (i % a == 0 && i % b == 0)// 找到一个i能同时是a的倍数，也同时是b的倍数的时候，就输出i
            {
                return i;
            }
        }
        return Math.max(a, b);
    }

    private static long getMaxGy(long a,long b) {
        return a*b/getMinGb(a,b);
    }

}
