package com.leet.code.树.二叉树;

import com.leet.code.树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 输出: [3, 14.5, 11]
 * 解释:
 * 第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
 *
 * @author gaoqi
 * @date 2020/2/21.
 */
public class 二叉树的层平均值637 {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> sum = new ArrayList<>();
        List<Double> cnt = new ArrayList<>();
        List<Double> avgAr = new ArrayList<>();
        avg(root, 0, sum, cnt);
        for (int i = 0; i <= sum.size(); i++) {
            avgAr.add(sum.get(i) / cnt.get(i));
        }
        return avgAr;
    }

    private void avg(TreeNode root, int k, List<Double> sum, List<Double> cnt) {
        if (root == null) {
            return;
        }
        if (k < sum.size()) {
            sum.set(k, sum.get(k) + root.val);
            cnt.set(k, cnt.get(k) + 1);
        } else {
            sum.add(k, root.val * 1.0);
            cnt.add(k, 1.0);
        }
        avg(root.left, k + 1, sum, cnt);
        avg(root.right, k + 1, sum, cnt);
    }
}
