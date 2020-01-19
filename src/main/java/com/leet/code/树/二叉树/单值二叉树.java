package com.leet.code.树.二叉树;

import com.leet.code.树.TreeNode;

/**
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 *
 * @author gaoqi
 * @date 2020/1/3.
 */
public class 单值二叉树 {

    private static int code = 0;

    // 对比左子树和右子树
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = (root.left == null || (root.val == root.left.val && isUnivalTree(root.left)));
        boolean right = (root.right == null || (root.val == root.right.val && isUnivalTree(root.right)));

        return left && right;
    }

}
