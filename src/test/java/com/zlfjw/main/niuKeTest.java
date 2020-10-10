package com.zlfjw.main;

import com.zlfjw.constant.RandomListNode;
import com.zlfjw.constant.TreeNode;
import org.junit.Test;

import java.util.ArrayList;

public class niuKeTest {
    @Test
    public void test01(){
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(5);
        node.right = new TreeNode(12);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(7);
        NiuKe.FindPath(node, 22,new ArrayList(),new ArrayList());
    }

    @Test
    public void test02(){

    }

    @Test
    public void test03(){
        RandomListNode randomListNode = new RandomListNode(1);
        RandomListNode tail = randomListNode;
        for(int i = 2;i <= 5;i++){
            tail.next = new RandomListNode(i);
            tail.random = new RandomListNode(i+1);
            tail = tail.next;
        }
        RandomListNode clone = NiuKe.Clone(randomListNode);
        while (clone != null){
            System.out.println(clone.label);
            if(clone.random != null)System.out.println(clone.random.label);
            clone = clone.next;
        }
    }

    @Test
    public void test04(){
        ArrayList<String> res = NiuKe.Permutation("aa");
        res.forEach(s->{
            System.out.println(s);
        });
    }

    @Test
    public void test05(){
        String str1 = "123";
        String str2 = "321";
        int num1 = Integer.valueOf(str1+str2);
        int num2 = Integer.valueOf(str2+str1);
        System.out.println(num1);
        System.out.println(num2);
    }

    @Test
    public void test06(){
        String str = "12:123:1234";
        String[] split = str.split(":");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }
    }
}