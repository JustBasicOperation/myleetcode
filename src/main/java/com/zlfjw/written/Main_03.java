package com.zlfjw.written;

import java.math.BigInteger;

public class Main_03 {
    public static void main(String[] args) {
        String s = addStrings("000", "999");
        System.out.println(s);
    }

    public static String addStrings(String num1,String num2){
        StringBuffer buffer = new StringBuffer();
        StringBuffer buffer1 = new StringBuffer(num1);
        StringBuffer buffer2 = new StringBuffer(num2);
        num1 = buffer1.reverse().toString();
        num2 = buffer2.reverse().toString();
        int index = 0;
        int carry = 0;
        while(index < num1.length() && index < num2.length()){
            int n1 = Integer.parseInt(num1.charAt(index) + "");
            int n2 = Integer.parseInt(num2.charAt(index) + "");
            int sum = n1+n2+carry;
            if(sum > 9){
                carry = 1;
                buffer.append(sum%10);
            }else{
                carry = 0;
                buffer.append(sum);
            }
            index++;
        }
        while (index < num1.length()){
            int num = Integer.parseInt(num1.charAt(index) + "");
            int sum = num+carry;
            if(sum>9){
                carry = 1;
                buffer.append(sum%10);
            }else{
                buffer.append(sum);
                carry = 0;
            }
            index++;
        }
        while(index < num2.length()){
            int num = Integer.parseInt(num2.charAt(index) + "");
            int sum = num+carry;
            if(sum>9){
                carry = 1;
                buffer.append(sum%10);
            }else{
                buffer.append(sum);
                carry = 0;
            }
            index++;
        }
        if(carry == 1){
            return buffer.append(carry).reverse().toString();
        }
        return buffer.reverse().toString();
    }
}
