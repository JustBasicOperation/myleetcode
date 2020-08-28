package com.zlfjw.main;

import com.zlfjw.constant.RandomListNode;
import com.zlfjw.constant.TreeNode;
import java.util.ArrayList;

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
}
