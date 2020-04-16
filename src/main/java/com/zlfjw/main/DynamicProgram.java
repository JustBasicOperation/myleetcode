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
     * 数学模型：定义w表示行李的重量；v表示行李的价值；x表示选或者不选，取值为0或1；n表示行李的数量；cap表示背包容量
     *          所以可得：
     *                 ∑vi*xi (1<= i <= n),xi = {0,1}
     *          约束条件为：
     *                 ∑wi*xi <= cap (1<= i <= n)
     * 设计状态：dp[i][j]表示背包容量为j的情况下，前i件物品最佳组合对应的价值
     * 状态转移方程：if(w[i] < j) dp[i][j] = Math.max{dp[i-1][j],dp[i-1][j-w[i]]+v[i]}
     *              else dp[i][j] = dp[i-1][j]
     * @param array array
     */
    public static void knapsack(int[][] array,int cap){
        //array数组第一列表示重量，第二列表示价值
        int len = array.length;
        int[][] dp = new int[len][cap];
        for(int i = 0;i < len;i++){
            dp[i][0] = 0;
        }
        for(int i = 0;i < cap;i++){
            dp[0][i] = 0;
        }
        for(int i = 1;i < len;i++){
            for (int j = 1;j < cap;j++){
                if(array[i-1][0] < j){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-array[i-1][0]] + array[i-1][1]);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        for (int i = 0;i < len;i++){
            for(int j = 0;j < cap;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(dp[len-1][cap-1]);
    }
}
