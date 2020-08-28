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
}