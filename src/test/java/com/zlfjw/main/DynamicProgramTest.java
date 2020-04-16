package com.zlfjw.main;

import org.junit.Test;

public class DynamicProgramTest {

    @Test
    public void test01(){
        int[][] array = new int[][]{{77,92},{22,22},{29,87},{50,46},{99,90}};
        DynamicProgram.knapsack(array,100);
    }

}
