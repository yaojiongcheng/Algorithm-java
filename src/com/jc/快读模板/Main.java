package com.jc.快读模板;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @Author JC
 * @description 快读模板
 * @Date 2023-10-17 01:07
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        double DoubleN = st.nval;
        st.nextToken();
        int intN = (int) st.nval;
        st.nextToken();
        long longN = (long) st.nval;
        st.nextToken();
        String strVal = st.sval;
    }

}
