package com.zlfjw.written;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main_02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int n = 0;
        for (int i = 0;i < t;i++){
            n = in.nextInt();
            int[] values = new int[n];
            for (int j = 0;j < n;j++){
                values[i] = in.nextInt();
            }
            int res = judge(values);
        }
    }
    public static int judge(int[] nums){
        int res = 0;
        Arrays.sort(nums);
        for(int i = 0,j = nums.length-1;i < j;i++,j--){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        for (int i = 0;i < nums.length;i++){
            if(nums[i] == 0){
                continue;
            }
            boolean eq = judgeEqual(nums,i);
            if(eq){
                nums[i] = 0;
            }
        }
        for(int num : nums){
            res += num;
        }
        return res;
    }

    private static boolean judgeEqual(int[] nums, int i) {
        return true;
    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] nums = new int[n];
//        for (int i = 0;i < n;i++){
//            nums[i] = in.nextInt();
//        }
//        int count = 0;
//        for (int i = 0;i < n;i++){
//            count += judge(nums[i]);
//        }
//        System.out.println(count);
//    }
//    public static int judge(int i){
//        int res = i/2;
//        return res;
//    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int m = in.nextInt();
//        int[] nums = new int[m];
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i = 0;i < m;i++){
//            nums[i] = in.nextInt();
//            list.add(nums[i]);
//        }
//        int[] arr = new int[n-m];
//        int index = 0;
//        for(int i = 0;i <= n;i++){
//            if(!list.contains(i)){
//                arr[index++] = i;
//            }
//        }
//        for(int i = arr.length-1;i >= 0;i--){
//            boolean find = false;
//            for(int j = 0;j < list.size();j++){
//                if(list.get(j) > arr[i]){
//                    list.add(j,arr[i]);
//                    find = true;
//                    break;
//                }
//            }
//            if(!find){
//                list.add(nums.length,arr[i]);
//            }
//        }
//
//        list.forEach(e->{
//            System.out.println(e+" ");
//        });
//    }

}
