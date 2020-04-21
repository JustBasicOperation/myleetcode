package com.zlfjw.main;

import org.junit.Test;

public class DynamicProgramTest {

    @Test
    public void test01(){
        int[][] array = new int[][]{{77,92},{22,22},{29,87},{50,46},{99,90}};
        DynamicProgram.knapsack(array,100);
    }

    @Test
    public void test02(){
        String text1 = "abcde";
        String text2 = "ace";
        int i = DynamicProgram.longestCommonSubsequence(text1, text2);
        System.out.println(i);
    }
}
