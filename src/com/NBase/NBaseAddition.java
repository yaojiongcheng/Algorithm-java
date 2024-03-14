package com.NBase;
import java.util.*;

public class NBaseAddition  {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String num1=sc.nextLine();
        String num2=sc.nextLine();
        //注意区别在这里，多个个进制输入
        int base=sc.nextInt();

        int i=num1.length()-1,j=num2.length()-1;
        //处理进位
        int add=0;
        //通过StringBuilder处理，主要它有反转的这个函数
        StringBuilder ans=new StringBuilder();
        //此处是个大条件，只有一方不满足才会退出
        while(i>=0||j>=0||add!=0){
            //转换为字母通过-‘0’
            int x=i>=0?num1.charAt(i)-'0':0;
            int y=j>=0?num2.charAt(j)-'0':0;
            int result=x+y+add;
            //添加值到每个字符串的最后一个
            ans.append(result%base);
            //添加进位给予到下一个值
            add=result/base;
            i--;
            j--;
        }
        //字符串的反转
        ans.reverse();

        System.out.println(ans);

    }

}

