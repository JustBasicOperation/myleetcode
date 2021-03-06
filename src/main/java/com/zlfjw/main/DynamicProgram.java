package com.zlfjw.main;

import java.util.Arrays;

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




    /**
     *
     *                                                     第二类：线性dp
     *  ================================================================================================================
     */
    //300.最长上升子序列
    /**
     * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
     *
     * 示例:
     *
     * 输入: [10,9,2,5,3,7,101,18]
     * 输出: 4
     * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
     *
     * 说明:
     *
     *     可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
     *     你算法的时间复杂度应该为 O(n2) 。
     *
     * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
     *
     * @created: 2020/4/19 17:08
     *
     */
    public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len < 2){
            return len;
        }
        //定义dp[i]表示以nums[i]元素结尾的最长上升子序列的长度
        int[] dp = new int[len];
        Arrays.fill(dp,1);
        int max = 1;
        for(int i = 1;i < len;i++){
            for(int j = i-1;j >= 0;j--){
                if(nums[i] > nums[j]){
                    //状态转移方程：dp[i] = Math.max(dp[i],dp[j]+1)
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    //  max = Math.max(dp[i],max);
                }
            }
        }
        for(int i = 0;i < len;i++){
            max = Math.max(dp[i],max);
        }
        return max;
    }

    //1143.最长公共子序列
    public static int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        if(len1 == 0 || len2 == 0){
            return 0;
        }
        //定义dp数组：dp[i][j]表示text1前i个字符和text2前j个字符的最长公共子序列
        //状态转移方程：if(text1.charAt(i) != text2.charAt(j)) dp[i][j] = dp[i-1][j-1]
        //             else dp[i][j] = max(dp[i-1][j],dp[i-1][j-1],dp[i][j-1]) + 1
        int[][] dp = new int[len1+1][len2+1];
        //数组初始化，此处可省略
        dp[0][0] = 0;
        for(int i = 0;i <= len1;i++){
            dp[i][0] = 0;
        }
        for(int i = 0;i <= len2;i++){
            dp[0][i] = 0;
        }
        for(int i = 1;i <= len1;i++){
            for(int j = 1;j <= len2;j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }

    //152.乘积最大子数组
    public static int maxProduct(int[] nums) {
        int len = nums.length;
        if(len == 0 || len == 1){
            return len == 0 ? 0 : nums[0];
        }
        //dp[i]表示前i个元素中的最大连续子数组乘积
        int[] dp = new int[len];
        dp[0] = nums[0];
        int max = nums[0],min = nums[0];
        for(int i = 1;i < len;i++){
            if(nums[i] < 0){
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(nums[i]*max,nums[i]);
            min = Math.min(nums[i]*min,nums[i]);
            dp[i] = Math.max(max,dp[i-1]);
        }
        return dp[len-1];
    }


}
