package com.zlfjw.written;

import java.util.*;

public class Main_06 {
    //    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
//        for(int a = 0;a <= 9;a++){
//            for(int b = 0;b <= 9;b++){
//                for(int c = 0;c <= 9;c++){
//                    int num1 = (a *100 + b*10 + c);
//                    int num2 = (a *100 + c*10 + c);
//                    if(num1 + num2 == n && num1 != num2){
//                        map.put(num1,num2);
//                    }
//                }
//            }
//        }
//        System.out.println(map.size());
//        map.forEach((k,v)->{
//            System.out.println(k + " " + v);
//        });
//    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Long> list = new LinkedList<>();
        List<Long> res = getList(list, n * n);
        long[][] nums = new long[n][n];
        int index = list.size() - 1;
        int left = 0;
        /**
         * 这里需要注意右边界数组越界问题
         */
        int right = n-1;
        int top = 0;
        /**
         * 同理，所以需要等于n-1
         */
        int bottom = n-1;
        while (true) {
            if (left > right) {
                break;
            }
            for (int i = left; i <= right; i++) {
                nums[top][i] = list.get(index--);
                System.out.println(top + ":" + i);
            }
            top++;

            if (top > bottom) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                nums[i][right] = list.get(index--);
                System.out.println(i + ":" + right);
            }
            right--;

            if (right < left) {
                break;
            }
            for (int i = right; i >= left; i--) {
                nums[bottom][i] = list.get(index--);
                System.out.println(bottom + ":" + i);
            }
            bottom--;

            if (bottom < top) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                nums[i][left] = list.get(index--);
                System.out.println(i + ":" + left);
            }
            left++;

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static List<Long> getList(List<Long> list, int n) {
        long a = 1;
        long b = 1;
        long c = a + b;
        list.add(a);
        if (n == 1) {
            return list;
        }
        list.add(b);
        if (n == 2) {
            return list;
        }
        list.add(c);
        for (int i = 3; i < n; i++) {
            a = b;
            b = c;
            c = a + b;
            list.add(c);
        }
        return list;
    }
}

