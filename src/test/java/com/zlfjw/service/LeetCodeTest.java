package com.zlfjw.service;

import com.zlfjw.constant.ListNode;
import com.zlfjw.main.Solution;
import org.junit.Test;

import java.util.List;

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

}
