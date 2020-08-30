package com.zlfjw.main;

import com.zlfjw.constant.ListNode;
import com.zlfjw.constant.RandomListNode;
import com.zlfjw.constant.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class NiuKe {
    public static void FindPath(TreeNode root, int target, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path) {
        // 0，当节点为空，return
        if (root == null) {
            return;
        }

        path.add(root.val);
        target -= root.val;

        // 1，当目标值小于0，return
        if(target < 0){
            return;
        }

        // 2，当目标值为0 并且 节点下无其他节点, 保存并返回
        if(target == 0 && root.left == null && root.right == null){
            result.add(path);
            return;
        }

        // 继续遍历左右节点
        // 这里new path是因为左右都会在下次递归path.add(root.val);
        FindPath(root.left, target, result, new ArrayList<>(path));
        FindPath(root.right, target, result, new ArrayList<>(path));
    }

    /**
     * 深拷贝链表
     * @param pHead  pHead
     * @return return
     */
    public static RandomListNode Clone(RandomListNode pHead){
        RandomListNode node = new RandomListNode(pHead.label);
        RandomListNode cur = node;
        while(pHead != null){
            if(pHead.next != null){
                cur.next = new RandomListNode(pHead.next.label);
            }
            if(pHead.random != null){
                cur.random = new RandomListNode(pHead.random.label);
            }

            cur = cur.next;
            pHead = pHead.next;
        }
        return node;
    }

    public static ArrayList<String> Permutation(String str) {
        StringBuffer path = new StringBuffer();
        TreeSet<String> res = new TreeSet<>();
        ArrayList<String> result = new ArrayList<>();
        boolean[] used = new boolean[str.length()];
        backtrace(str,path,res,used);
        result.addAll(res);
        return result;
    }

    private static void backtrace(String str, StringBuffer path, TreeSet<String> res, boolean[] used) {
        if(path.length() == str.length()){
            res.add(path.toString());
            return;
        }
        for(int i = 0;i < str.length();i++){
            if(used[i]){
                continue;
            }
            path.append(str.charAt(i));
            used[i] = true;
            backtrace(str,path,res, used);
            path.deleteCharAt(path.length()-1);
            used[i] = false;
        }
    }

    //从尾到头遍历链表
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        backtrace(listNode,list);
        return list;
    }
    public void backtrace(ListNode root, List<Integer> list){
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
