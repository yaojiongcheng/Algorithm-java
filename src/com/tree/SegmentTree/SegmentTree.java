package com.tree.SegmentTree;


// 线段树
public class SegmentTree {

    public static void main(String[] args) {
        int[] a = new int[100];
        int left = 0;
        int right = 5;
        tree_insert(a,0,left,right,3);
        tree_insert(a,0,left,right,5);
        tree_insert(a,0,left,right,2);
        print_tree(a,0,left,right);

        for (int i = 0; i < 6; i++) {
            if (tree_search(a,0,left,right,i) != 0) {
                System.out.println(i + " is in tree.");
            }
        }
    }

    /**
     * 线段树的数据插入，使用a来存储线段树中的数据
     * 变量pos对应正在访问的数组下标
     * left和right表示当前正在处理的区间的左右端点，数字num是待插入的数字
     * @param a
     * @param pos
     * @param left
     * @param right
     * @param num
     */
    public static void tree_insert(int[] a,int pos,int left,int right,int num) {
        a[pos]++; // 区间left到right中保存的数字增加了一个
        // 如果此时待添加的数字num和左右端点相同
        if (num == right && num == left) {
            // 当前的区间是单位区间，并且这个单位区间就对应了数字num
            return; // 函数返回
        }
        int mid = (left + right) / 2; // 计算区间的中点
        int left_child = pos * 2 + 1; // 计算该区间的左孩子区间对应的数组下标
        int right_child = pos * 2 + 2; // 计算该区间的右孩子区间对应的数组下标
        if (num <= mid) {
            // 将num插入到该区间的左孩子区间
            tree_insert(a,left_child,left,mid,num);
        } else {
            // 插入到右孩子区间中
            tree_insert(a,right_child,mid + 1,right,num);
        }
    }

    /**
     * 线段树的数据查找
     * @param a
     * @param pos
     * @param left
     * @param right
     * @param num
     * @return
     */
    public static int tree_search(int[] a,int pos,int left,int right,int num) {
        // 如果正在查询的数字num和左右端点相同
        if (num == right && num == left) {
            // 当前的区间就是表示数字num的区间
            return a[pos]; // 返回该区间保存的数据
        }
        int mid = (left+right)/2; // 计算区间的中点
        int left_child = pos * 2 + 1; // 左孩子数组下标
        int right_child = pos * 2 + 2; // 右孩子数组下标
        if (num <= mid) { // 如果num小于等于区间的中间位置mid
            // 在左区间中继续查找
            return tree_search(a,left_child,left,mid,num);
        } else {
            // 在右区间中继续查找
            return tree_search(a,right_child,mid + 1,right,num);
        }
    }

    /**
     * 线段树的打印
     * @param a
     * @param pos
     * @param left
     * @param right
     */
    public static void print_tree(int[] a,int pos,int left,int right) {
        // 打印当前节点对应的区间左右端点，该区间的数组位置和数组中存储的值
        System.out.println("[" + left + "] " + right + " a" + "[" + pos + "] = " + a[pos]);
        if (left == right) { // 如果left等于right
            // 该区间是线段树的叶子节点
            return; // 函数返回
        }
        int mid = (left + right) / 2; // 计算区间中点
        print_tree(a,pos * 2 + 1,left,mid); // 递归的打印左子树
        print_tree(a,pos * 2 + 2,mid + 1,right); // 递归的打印右子树
    }

}
