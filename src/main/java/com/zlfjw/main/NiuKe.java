package com.zlfjw.main;

import com.zlfjw.constant.TreeNode;
import java.util.ArrayList;

public class NiuKe {
    private void find(TreeNode root, int target, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path) {
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
        this.find(root.left, target, result, new ArrayList<>(path));
        this.find(root.right, target, result, new ArrayList<>(path));
    }
}
