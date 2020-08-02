package com.zlfjw.written;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long sum = 0;
        int x = (int) (1e9+7);
        for(int i = 0;i <= n;i++){
            sum += ((multi(n,i)/multi(i,i)) * Math.pow(m,i))%x;
        }
        System.out.println(sum);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
    }
    public static long multi(int x,int y){
        long res = 1;
        for(long i = x;i > x-y;i--){
            res *= i;
        }
//        System.out.println(res);
        return res;
    }
}
