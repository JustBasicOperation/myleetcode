package com.zlfjw.written;

/**
 * @author faustzhao
 * @date 2020/8/12 19:46
 * @description
 */
public class Main_04 {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,0,1,0,0},{0,1,1,0,1},{0,0,1,0,1}};
        int raw = 3,col = 5;
        int S = 2;
        boolean[][] judge = new boolean[raw][col];
        backTrace(0,0,nums,S,judge);
        System.out.println(judge[raw-1][col-1]);
    }

    public static void backTrace(int x,int y,int[][] nums,int S,boolean[][] judge){
        if(x >= nums.length || y >= nums[0].length || nums[x][y] == 0){
            judge[x][y] = false;
            return;
        }
        if(x < nums.length && y < nums[0].length && nums[x][y] == 1){
            judge[x][y] = true;
        }
        backTrace(x,y+S,nums,S,judge);
        judge[x][y] = false;
        backTrace(x+S,y,nums,S,judge);
        judge[x][y] = false;
    }
}
