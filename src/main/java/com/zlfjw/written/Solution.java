package com.zlfjw.written;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 3},{1,4},{2,3},{2,4},{4,3}};
        int judge = findJudge(4, nums);
        System.out.println(judge);
    }
    public static int findJudge(int N, int[][] trust) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int temp = trust[0][1];
        int len = trust.length;
        int count = 0;
        for(int i = 0;i < len;i++){
            if(temp == trust[i][1]){
                count++;
            }
            map.put(i,trust[i][0]);
        }
        if(!map.containsValue(temp) && count == len){
            return temp;
        }else{
            return -1;
        }
    }
}

