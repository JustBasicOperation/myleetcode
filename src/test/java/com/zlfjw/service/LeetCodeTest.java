package com.zlfjw.service;

import com.zlfjw.constant.ListNode;
import com.zlfjw.main.Solution;
import com.zlfjw.written.Main;
import org.junit.Test;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author zhaolinfeng3
 **/
public class LeetCodeTest {
    @Test
    public void test1(){
        int i = Solution.lengthOfLongestSubstring("pwwwkew");
        System.out.println(i);
    }

    /**
     * "wordgoodgoodgoodbestword"
     * ["word","good","best","good"]
     */
    @Test
    public void test2(){
        List<Integer> barfoothefoobarman = Solution.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"});
        barfoothefoobarman.forEach(integer -> {
            System.out.println(integer);
        });
    }

    @Test
    public void test3(){
        List<Integer> barfoothefoobarman = Solution.findSubstring("barfoothefoobarman", new String[]{"bar","foo"});
        barfoothefoobarman.forEach(integer -> {
            System.out.println(integer);
        });
    }

    @Test
    public void test4(){
        List<Integer> barfoothefoobarman = Solution.findSubstring("", new String[]{""});
        barfoothefoobarman.forEach(integer -> {
            System.out.println(integer);
        });
    }

    @Test
    public void test5(){
        int[] a = new int[]{};
        int[] b = new int[]{1};
        double medianSortedArrays = Solution.findMedianSortedArrays(a, b);
        System.out.println(medianSortedArrays);
    }

    @Test
    public void test6(){
        String asds = Solution.longestPalindrome("asds");
        System.out.println(asds);
    }

    @Test
    public void test7(){
        int i = Solution.myAtoi("0-1");
        System.out.println(i);
    }

    @Test
    public void test8(){
//        boolean aa = Solution.isMatchplus("aaa", "aa*");
//        System.out.println(aa);
    }

    @Test
    public void test9(){
        List<List<Integer>> lists = Solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }

    @Test
    public void test10(){
        int[] array = new int[]{1,2,3,4,5,6,7};
        Solution.rotate(array,3);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    @Test
    public void test11(){
        String s = Solution.countAndSay(5);
        System.out.println(s);
    }

    @Test
    public void test12(){
        String multiply = Solution.multiply("123", "456");
        System.out.println(multiply);
    }

    @Test
    public void test13(){
        int i = Solution.uniquePaths(10, 10);
        System.out.println(i);
    }

    @Test
    public void test14(){
        int i = Solution.mySqrt(5);
        System.out.println(i);
    }

    @Test
    public void test15(){
        int i = Solution.mySqrtPlus(2147395599);
        System.out.println(i);
    }

    @Test
    public void test16(){
        int n = 4;
        String[] strs = new String[]{"aaa","bcdef","cde","zzz"};
        Solution.longestMelody(n,strs);
    }

    @Test
    public void test17(){
        int n = 5;
        String[] strs = new String[]{"aaa","bcdef","ij","jk","zzz"};
        Solution.myLongestMelody(n,strs);
    }

    @Test
    public void test18(){
        ListNode head = new ListNode(0);
        ListNode tail = head;
        for (int i = 1;i < 6;i++){
            ListNode newNode = new ListNode(i);
            tail.next = newNode;
            tail = newNode;
        }
        ListNode listNode = Solution.reverseList_recusion(head);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    @Test
    public void test19(){
        int i = Solution.longestNums(new int[]{2, 2, 2, 2,});
        System.out.println(i);
    }

    @Test
    public void test20(){
        int i = Solution.minDistance("a", "b");
        System.out.println(i);
    }

    @Test
    public void test21(){
        ListNode l1 = new ListNode(1);
        ListNode tail1 = l1;
//        tail1.next = new ListNode(4);
//        tail1 = tail1.next;
//        tail1.next = new ListNode(3);

        ListNode l2 = new ListNode(9);
        ListNode tail2 = l2;
        tail2.next = new ListNode(9);
//        tail2 = tail2.next;
//        tail2.next = new ListNode(6);

        Solution.addTwoNumbers(l1,l2);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.nextInt();
        Solution.eatCake();
    }

    @Test
    public void test22(){
        String s = Solution.longestPalindrome("abcba");
        System.out.println(s);
    }

    @Test
    public void test23(){
        Main.multi(3,3);
        int a = (int) (1e9+7);
        int b = Integer.MAX_VALUE;
        System.out.println(b%a);
        System.out.println(a);
    }

    @Test
    public void test24(){
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
//        System.out.println(Long.MAX_VALUE);
//        System.out.println(Float.MAX_VALUE);
//        System.out.println(Double.MAX_VALUE);
        BigInteger bigInteger = new BigInteger("346816816468484897646454646816468468");
        System.out.println(bigInteger);
    }

    @Test
    public void test25(){
        int[] nums = new int[]{5,5,10};
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0;i < nums.length;i++){
            if(nums[i] == 5){
                sum += nums[i];
            }else if(nums[i] % 5 != 0){
                System.out.println(false);
                break;
            }else{
                sum += nums[i];
                if(sum > nums[i] - 5){
                    sum -= nums[i]-5;
                }else{
                    System.out.println(false);
                }
            }
        }
        System.out.println(true);
    }

    @Test
    public void test26(){
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        ListNode listNode = Solution.reverserList(root);
        while(listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

}
