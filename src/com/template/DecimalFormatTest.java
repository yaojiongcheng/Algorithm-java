package com.template;

import java.text.DecimalFormat;

public class DecimalFormatTest {


    /**
     * 四舍五入保留两位小数
     */
    public static final DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) throws Exception {
        System.out.println(df.format(2.21 / 2));
    }

}
