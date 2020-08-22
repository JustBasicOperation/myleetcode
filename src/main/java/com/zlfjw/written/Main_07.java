package com.zlfjw.written;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main_07 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        if(n < 1 || n > 50000){
//            return;
//        }
//        int[] nums = new int[n];
//        int[] out = new int[n];
//        boolean[] dp = new boolean[n];
//        for(int i = 0;i < nums.length;i++){
//            nums[i] = in.nextInt();
//        }
//        for(int i = 0;i < out.length;i++){
//            out[i] = in.nextInt();
//        }
//        for(int i = 0;i < out.length;i++){
//            int index = out[i];
//            dp[index-1] = true;
//            long max = findMax(nums,dp);
//            System.out.println(max);
//        }
//    }
//
//    private static long findMax(int[] nums, boolean[] dp) {
//        long max = 0;
//        long sum = 0;
//        for(int i = 0;i < nums.length;i++){
//            if(!dp[i]){
//                sum += nums[i];
//            }else {
//                max = Math.max(max,sum);
//                sum = 0;
//            }
//        }
//        return max;
//    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] nums = new int[n][2];
        if(n < m){
            System.out.println();
        }
        for (int i = 0;i < n;i++){
            nums[i][0] = i + 1;
            nums[i][1] = in.nextInt() + in.nextInt()*2;
        }
        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (int)o1[1] - (int)o2[1];
            }
        });
        int[][] res = Arrays.copyOfRange(nums, n - m-1, n);
        Arrays.sort(res, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return o2[0] - o1[0];
                }
                return o1[1] - o2[1];
            }
        });
        for (int i = 0;i < res.length;i++){
            System.out.print(res[i][0] + " ");
        }
//        for(int i = n-m,j = 0;i < n;i++){
//            System.out.print(nums[i][0] + " ");
//        }
    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] weights = new int[n];
//        int[] nums = new int[n];
//        for(int i = 0;i < n;i++){
//            weights[i] = in.nextInt();
//        }
//        for(int i = 0;i < n;i++){
//            nums[i] = in.nextInt();
//        }
//
//    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        String[] strings = new String[n];
//        for (int i = 0;i < n;i++){
//            strings[i] = in.next();
//        }
//        for (String string : strings) {
//            if(judge(string)){
//                System.out.println("Accept");
//            }else{
//                System.out.println("Wrong");
//            }
//        }
//    }
//    public static boolean judge(String str){
//        int len = str.length();
//        int ch = 0;
//        int num = 0;
//        if(len < 2){
//            return false;
//        }
//        if(!((str.charAt(0) >= 'a' && str.charAt(0) <= 'z') || (str.charAt(0) >= 'A' && str.charAt(0) <= 'Z'))){
//            return false;
//        }
//        for(int i = 1;i < len;i++){
//            boolean b1 = str.charAt(i) >= 'a' && str.charAt(i) <= 'z';
//            boolean b2 = str.charAt(i) >= 'A' && str.charAt(i) <= 'Z';
//            if(b1 || b2){
//                ch++;
//                continue;
//            }else if((str.charAt(i) >= '0' && str.charAt(i) <= '9')){
//                num++;
//                continue;
//            }else {
//                return false;
//            }
//        }
//        return ch > 0 && num > 0;
//    }
}
