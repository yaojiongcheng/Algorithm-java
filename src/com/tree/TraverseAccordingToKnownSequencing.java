package com.tree;

import java.util.Scanner;

// 已知中序和后序遍历求先序遍历
public class TraverseAccordingToKnownSequencing {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String mid = scanner.next();
        String aft = scanner.next();
        tree(mid,aft);
    }

    private static void tree(String mid, String aft) {
        char root = aft.charAt(aft.length() - 1);
        System.out.print(root);
        int index = mid.indexOf(root);
        if (index > 0) {
            tree(mid.substring(0,index),aft.substring(0,index));
        }
        if (index < mid.length() - 1) {
            tree(mid.substring(index + 1),aft.substring(index,aft.length() - 1));
        }
    }

}
