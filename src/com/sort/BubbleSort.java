package com.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BubbleSort {

    public static void main(String[] args) {

        // int arr[] = {3,9,-1,10,20};

        // System.out.println("排序前");
        // System.out.println(Arrays.toString(arr));

        // 冒泡排序的演变过程

        // 测试一下冒泡排序的速度（O(n^2)），给80000个数据，测试
        // 创建一个80000个的随机的数组
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random() * 8000000); // 生成一个[0,8000000)数
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SS");
        String data1Str = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是=" + data1Str);

        // 测试冒泡排序
        bubbleSort(arr);

        Date date2 = new Date();
        String data2Str = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是=" + data2Str);

        // System.out.println("排序后");
        // System.out.println(Arrays.toString(arr));

/*
        // 冒泡排序的时间复杂度 O(n^2)
        int temp = 0; // 临时变量
        for (int j = 0; j < arr.length - 1; j++) {
            for (int i = 0; i < arr.length - 1 - j; i++) {
                // 如果前面的数比后面的数大，则交换
                if (arr[i] > arr[i+1]) {
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
            System.out.println("第" + (j+1) + "趟排序后的数组");
            System.out.println(Arrays.toString(arr));
        }
*/


/*
        // 第一趟排序，就是将最大的数排在最后
        int temp = 0; // 临时变量
        for (int i = 0; i < arr.length - 1; i++) {
            // 如果前面的数比后面的数大，则交换
            if (arr[i] > arr[i+1]) {
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }

        System.out.println("第一趟排序后的数组");
        System.out.println(Arrays.toString(arr));

        // 第二趟排序，就是将第二大的数排在倒数第二位
        for (int i = 0; i < arr.length - 1 - 1; i++) {
            // 如果前面的数比后面的数大，则交换
            if (arr[i] > arr[i+1]) {
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }

        System.out.println("第二趟排序后的数组");
        System.out.println(Arrays.toString(arr));

        // 第三趟排序，就是将第三大的数排在倒数第三位
        for (int i = 0; i < arr.length - 1 - 2; i++) {
            // 如果前面的数比后面的数大，则交换
            if (arr[i] > arr[i+1]) {
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }

        System.out.println("第三趟排序后的数组");
        System.out.println(Arrays.toString(arr));

        // 第四趟排序，就是将第四大的数排在倒数第四位
        for (int i = 0; i < arr.length - 1 - 3; i++) {
            // 如果前面的数比后面的数大，则交换
            if (arr[i] > arr[i+1]) {
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }

        System.out.println("第四趟排序后的数组");
        System.out.println(Arrays.toString(arr));

*/
    }

    // 将前面的冒泡排序算法，封装成一个方法
    public static void bubbleSort(int[] arr) {
        // 冒泡排序优化
        int temp = 0; // 临时变量
        boolean flag = false; // 标识变量，表示是否进行过交换
        for (int j = 0; j < arr.length - 1; j++) {
            for (int i = 0; i < arr.length - 1 - j; i++) {
                // 如果前面的数比后面的数大，则交换
                if (arr[i] > arr[i+1]) {
                    flag = true;
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
            // System.out.println("第" + (j+1) + "趟排序后的数组");
            // System.out.println(Arrays.toString(arr));

            if (!flag) {
                // 说明在一趟排序中，一次交换都没有发生过
                break;
            } else {
                flag = false; // 重置flag，进行下一次判断
            }
        }
    }

}
