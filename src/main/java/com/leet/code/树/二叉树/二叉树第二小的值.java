package com.leet.code.树.二叉树;

import com.leet.code.树.TreeNode;

/**
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。
 * 如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。 
 *
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 *
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   2   5
 *      / \
 *     5   7
 *
 * 输出: 5
 * 说明: 最小的值是 2 ，第二小的值是 5 。
 *
 * 左子树和右子树最小值
 *
 * @author gaoqi
 * @date 2020/2/18.
 */
public class 二叉树第二小的值 {

    public int findSecondMinimumValue(TreeNode root) {
        int val = help(root, root.val);
        return val;
    }

    private int help(TreeNode root, int min) {
        if (root == null) {
            return -1;
        }

        if (root.val > min) {
            return root.val;
        }
        int left = help(root.left, min);
        int right = help(root.right, min);
        if (left == -1) return right;
        if (right == -1) return left;
        return Math.min(left, right);
    }

}
