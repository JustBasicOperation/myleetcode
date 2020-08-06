package com.zlfjw.written;

import java.util.Scanner;

public class Main_01 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        double sum = 0;
//        for(int i = 1;i <= n;i++){
//            double a = Math.pow(2,i);
//            sum += 1/(5*a);
//        }
//        String str = String.format("%.4f",sum);
//        System.out.println(str);
//    }
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    int count = 0;
    for(int i = n;i <= m;i++){
        if(judge(i)){
            count++;
        }
    }
    System.out.println(count);
}
    public static boolean judge(int i){
        int tmp = 1000000000;
        while(i > 0){
            if(isNum(i) && judgeHuiwen(i)){
                return true;
            }
            i = i% tmp;
            tmp = tmp/10;
        }
        return true;
    }
    public static boolean judgeHuiwen(int num){
        char[] cs = Integer.toString(num).toCharArray();
        int i = 0,j = cs.length-1;
        while(i <= j){
            if(cs[i] != cs[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static boolean isNum(int num){
        int i = 2;
        while(i * i <= num){
            int j = num/i;
            if(j*i == num){
                return false;
            }
            i++;
        }
        return true;
    }
}
