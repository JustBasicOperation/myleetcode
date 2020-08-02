package com.zlfjw.main;

import com.zlfjw.constant.ListNode;
import com.zlfjw.constant.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SwordFinger {

    //从尾到头遍历链表
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        backtrace(listNode,list);
        return list;
    }
    public void backtrace(ListNode root,List<Integer> list){
        if(root == null){
            return;
        }
        backtrace(root.next,list);
        list.add(root.val);
    }

    //重建二叉树
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if(pre.length == 0 || in.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        for(int i = 0;i < pre.length;i++){
            if(in[i] == pre[0]){
                //递归处理左子树
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),
                        Arrays.copyOfRange(in,0,i));
                //递归处理右子树
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),
                        Arrays.copyOfRange(in,i+1,in.length));
                break;
            }
        }
        return root;
    }
}
