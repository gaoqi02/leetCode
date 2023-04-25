package com.leet.code.树.二叉树;

import com.leet.code.树.TreeNode;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * @author gaoqi
 * @date 2020/2/9.
 */
public class 自底向上的层次遍历 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        dfs(root, 0, lists);
        Collections.reverse(lists);
        return lists;
    }

    private void dfs(TreeNode root, int k, List<List<Integer>> lists) {
        if (root == null) {
            return;
        }

        if (lists.size() <= k) {
            lists.add(k, new ArrayList<Integer>());
        }

        lists.get(k).add(root.val);

        dfs(root.left, k + 1, lists);
        dfs(root.right, k + 1, lists);
    }

}
