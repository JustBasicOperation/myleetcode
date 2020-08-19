package com.zlfjw.written;

import java.util.HashMap;
import java.util.Scanner;

public class Main_05 {
//    static int sum = 0;
//    static int count = 0;
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int M = in.nextInt();
//        int N = in.nextInt();
//
//        if(M < 10 || N < 10 || M > 1000 || N > 1000){
//            System.out.println("[]");
//            return;
//        }
//        int start = 0;
//        StringBuffer buffer = new StringBuffer("[");
//        while(M > start * 2 && N > start*2){
//            findResults(N,M,start,buffer);
//            start++;
//        }
//
//        String end = buffer.toString();
//        if(end.contains(",")){
//            end = buffer.toString().substring(0,buffer.lastIndexOf(","));
//        }
//        if(sum != 0){
//            System.out.println(end + "]");
//        }else {
//            System.out.println("[]");
//        }
//    }
//
//    private static void findResults(int col, int row, int start, StringBuffer buffer) {
//        int X = col - start - 1;
//        int Y = row - start - 1;
//        for(int i = start;i <= X;i++){
//            count++;
//            if(judgeOne(count)){
//                sum++;
//                buffer.append("[" + start + "," + i + "],");
//            }
//        }
//        if(start < Y){
//            for(int i = start + 1;i <= Y;i++){
//                count++;
//                if(judgeOne(count)){
//                    sum++;
//                    buffer.append("[" + i + "," + X + "],");
//                }
//            }
//        }
//
//        if(start < X && start < Y){
//            for(int i = X -1;i >= start;i--){
//                count++;
//                if(judgeOne(count)){
//                    sum++;
//                    buffer.append("[" + Y + "," + i + "],");
//                }
//            }
//        }
//
//        if(start < X && start < Y-1){
//            for(int i = Y -1;i >= start+1;i--){
//                count++;
//                if(judgeOne(count)){
//                    sum++;
//                    buffer.append("[" + i + "," + start + "],");
//                }
//            }
//        }
//    }
//    public static boolean judgeOne(int num){
//        return num %10 == 7 && ((num/10) %10) %2 == 1;
//    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 2, 2};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else {
                map.put(num,1);
            }
        }

    }
}
