package com.leet.code.树.二叉树;

import com.leet.code.树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author gaoqi
 * @date 2020/7/9.
 */
public class Z字遍历 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node;
                //因为是走z字形，所有相邻两层的节点处理是相反的
                if (depth % 2 == 0) {
                    node = queue.pollLast();//获取链表最后一个节点
                    if (node.left != null) {
                        queue.offerFirst(node.left);
                    }
                    if (node.right != null) {
                        queue.offerFirst(node.right);
                    }

                } else {
                    node = queue.poll();//获取链表第一个节点
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                }
                tmp.add(node.val);
            }
            depth++;
            result.add(tmp);
        }
        return result;
    }
}
