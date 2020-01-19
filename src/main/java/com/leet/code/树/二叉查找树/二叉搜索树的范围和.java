package com.leet.code.树.二叉查找树;

import com.leet.code.树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
 * 二叉搜索树保证具有唯一的值。
 * <p>
 * 输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
 * 输出：32
 * 示例 2：
 * <p>
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * 输出：23
 *
 * @author gaoqi
 * @date 2019/12/31.
 */
public class 二叉搜索树的范围和 {

    int sum = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        dst(root, L, R);
        return sum;
    }

    private int dst(TreeNode root, int l, int r) {
        if (root == null) {
            return sum;
        }
        if (root.val >= l && root.val <= r) {
            sum += root.val;
        }
        if (root.val >= l) {
            dst(root.left, l, r);
        }
        if (root.val <= r) {
            dst(root.right, l, r);
        }
        return sum;
    }


}
