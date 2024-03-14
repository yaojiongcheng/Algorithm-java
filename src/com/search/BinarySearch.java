package com.search;

import java.util.ArrayList;
import java.util.List;

// 注意：使用二分查找的前提是该数组是有序的。
public class BinarySearch {

    public static void main(String[] args) {
        // int[] arr = {1,8,10,89,1000,1000,1234};
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};

        // int resIndex = binarySearch(arr,0,arr.length-1,1000);
        // System.out.println("resIndex=" + resIndex);

        List<Integer> resIndexList = binarySearch2(arr, 0, arr.length - 1, 1);
        System.out.println("resIndexList" + resIndexList);
    }

    // 二分查找算法

    /**
     * @param arr 数组
     * @param left 左边的索引
     * @param right 右边的索引
     * @param findVal 要查找的值
     * @return 如果找到就返回下标，如果没有找到，就返回 -1
     */
    public static int binarySearch(int[] arr,int left,int right,int findVal) {

        // 当left > right 时，说明递归整个数组，但没有找到
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) {
            // 向右递归
            return binarySearch(arr,mid+1,right,findVal);
        } else if (findVal < midVal) {
            // 向左递归
            return binarySearch(arr, left, mid-1, findVal);
        } else {
            return mid;
        }
    }

    // 完成一个课后思考题：
    /*
        {1,8,10,89,1000,1000,1234} 当一个有序数组中，有多个相同的数值时，如何将所有的数值都查找到，比如这里的 1000

        思路分析
        1.在找到mid索引值，不要马上返回
        2.向mid索引值的左边扫描，将所有满足 1000 的元素下标，加入到一个集合ArrayList
        3.向mid 索引值的右边扫描，将所有满足 1000 的元素下标，加入到一个集合ArrayList
        4.将ArrayList返回
     */
    public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {
        System.out.println("hello~");

        // 当left > right 时，说明递归整个数组，但没有找到
        if (left > right) {
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) {
            // 向右递归
            return binarySearch2(arr,mid+1,right,findVal);
        } else if (findVal < midVal) {
            // 向左递归
            return binarySearch2(arr, left, mid-1, findVal);
        } else {
            List<Integer> resIndexList = new ArrayList<>();
            // 向mid索引值的左边扫描，将所有满足 1000 的元素下标，加入到一个集合ArrayList
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }
                resIndexList.add(temp);
                temp--;
            }
            resIndexList.add(mid); // 中间的索引值
            temp = mid + 1;
            while (true) {
                if (temp > arr.length-1 || arr[temp] != findVal) {
                    break;
                }
                resIndexList.add(temp);
                temp++;
            }
            return resIndexList;
        }
    }

}
