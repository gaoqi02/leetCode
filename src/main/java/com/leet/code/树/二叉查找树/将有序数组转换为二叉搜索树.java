package com.leet.code.树.二叉查找树;

import com.leet.code.树.TreeNode;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * @author gaoqi
 * @date 2020/1/2.
 */
public class 将有序数组转换为二叉搜索树 {

    // 按照二分的思想。中点作为根节点。
    //中点左边的数作为左子树，中点右边的数作为右子树。
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return mid(nums, 0, nums.length - 1);
    }

    public TreeNode mid(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        int midVal = nums[mid];

        TreeNode node = new TreeNode(midVal);
        node.left = mid(nums, start, mid - 1);
        node.right = mid(nums, mid + 1, end);
        return node;
    }


    private TreeNode help(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = help(nums, start, mid - 1);
        node.right = help(nums, mid + 1, end);
        return node;
    }


}
