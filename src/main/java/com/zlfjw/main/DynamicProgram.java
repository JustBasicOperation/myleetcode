package com.zlfjw.main;

/**
 * 动态规划专题
 */
public class DynamicProgram {
    /**
     *                                              第一类：背包问题
     * =================================================================================================================
     */
    //1.0-1背包问题
    /**
     * 问题描述：有一个行李数组，每件行李有价值和重量两种属性，给定一个背包容量，求这个背包中能够装下的行李价值最大值
     * 定义dp数组：dp[i][j]表示前i件行李中，重量不超过j的情况下，背包能够装下行李的最大价值
     * @param array array
     */
    public static void knapsack(int[][] array){
        //array数组第一列表示重量，第二列表示价值
        int len = array.length;
        int[][] dp = new int[len][len];
        for(int i = 0;i < len;i++){
            dp[i][0] = 0;
        }
        for(int i = 0;i < len;i++){
            dp[0][i] = 0;
        }
        for(int i = 0;i < len;i++){
            for (int j = 0;j < len;j++){

            }
        }
    }
}
