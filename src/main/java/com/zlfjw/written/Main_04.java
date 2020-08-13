package com.zlfjw.written;

import java.util.Stack;

public class Main_04 {
    public static void main(String[] args) {
        int i = GetCoinCount(200);
        System.out.println(i);
    }

    public static int GetCoinCount (int N) {
        // write code here
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        N = 1024 - N;
        a = N / 64;
        if((N = N - a*64) > 0){
            b = N / 16;
        }
        if((N = N - b*16) > 0){
            c = N / 4;
        }
        if((N = N - 4*c) > 0){
            d = N;
        }
        return a + b + c + d;
    }
//    public static boolean isValidExp(String s){
//        HashMap<Character, Integer> map = new HashMap<>();
//        for (char c : s.toCharArray()) {
//            map.put(c,map.get(c) == null ? 1 : map.get(c)+1);
//        }
//        return map.get('(') == map.get(')') && map.get('{') == map.get('}') && map.get('[') == map.get(']');
//    }
    public static boolean isValidExp(String s){
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                Character pop = stack.peek();
                if(pop == '(' && c != ')'){
                    stack.pop();
                }else if(pop == '{' && c == '}'){
                    stack.pop();
                }else if(pop == '[' && c == ']'){
                    stack.pop();
                }
            }
        }
        return stack.size() == 0;
    }

//    public static boolean Game24(int[] nums){
//        List<Integer> list = new ArrayList<>();
//        for (int num : nums) {
//            list.add(num);
//        }
//        boolean res = judge(list);
//        return res;
//    }
//
//    public static boolean judge(List<Integer> list){
//        for (int i = 0;i < list.size();i++){
//            int tmp = list.get(i);
//            list.remove(i);
//            if(getRel(list,tmp)){
//                return true;
//            }
//            list.add(i,tmp);
//        }
//        return false;
//    }
//
//    private static boolean getRel(List<Integer> list, int tmp) {
//        if(list.size() > 0){
//            for (int i = 0;i < list.size();i++){
//                int n = list.get(i);
//                list.remove(i);
//                if(getRel(list,tmp*n) || getRel(list,tmp + n) || getRel(list,tmp - n)){
//                    return true;
//                }else if(tmp % n == 0){
//                    if(getRel(list,tmp/n)){
//                        return true;
//                    }
//                }
//                list.add(i,n);
//            }
//            return false;
//        }else{
//            if(tmp == 24){
//                return true;
//            }else {
//                return false;
//            }
//        }
//    }


}
