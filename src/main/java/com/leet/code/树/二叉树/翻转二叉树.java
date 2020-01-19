package com.leet.code.树.二叉树;

import com.leet.code.树.TreeNode;

/**
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * @author gaoqi
 * @date 2020/1/2.
 */
public class 翻转二叉树 {

    private void switchNode(TreeNode root) {
        TreeNode tmpLeft = root.left;

        root.left = root.right;
        root.right = tmpLeft;

    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        invertTree(root.left);
        invertTree(root.right);
        switchNode(root);
        return root;
    }
}
