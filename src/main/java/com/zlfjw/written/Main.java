package com.zlfjw.written;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        escape(x,m,n);
    }

    public static void escape(int x,int m,int n){
        int count = 0;
        int start = 0;
        while(true){
            if(start == x){
                break;
            } else if(start > x){
                start -= n;
                count++;
            } else {
                start += m;
                count++;
            }
        }
        System.out.println(count);
    }
}
