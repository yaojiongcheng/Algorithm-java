package com;

import java.io.*;

public class InputAndOutput {

    public static void main(String args[]) throws IOException{
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int num2 = (int)st.nval;//读取int类型数据
        st.nextToken();
        String str = st.sval;//读取String类型数据
        st.nextToken();
        double num1 =  st.nval;//读取double类型数据
        st.nextToken();
        long num3 = (long)st.nval;//读取long类型数据
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        String x = re.readLine(); //读取一整行的数据
    }

}
