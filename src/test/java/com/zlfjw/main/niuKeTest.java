package com.zlfjw.main;

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
        ArrayList<ArrayList<Integer>> arrayLists = NiuKe.FindPath(node, 22);
        for (int i = 0; i < arrayLists.size(); i++) {
            for(int j = 0;j < arrayLists.get(i).size();j++){
                int res = arrayLists.get(i).get(j);
                System.out.print(res + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void test02(){
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(5);
        node.right = new TreeNode(12);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(7);
        ArrayList<ArrayList<Integer>> arrayLists = NiuKe.FindPath(node, 22);
        for (int i = 0; i < arrayLists.size(); i++) {
            for(int j = 0;j < arrayLists.get(i).size();j++){
                int res = arrayLists.get(i).get(j);
                System.out.print(res + " ");
            }
            System.out.println();
        }
    }

}