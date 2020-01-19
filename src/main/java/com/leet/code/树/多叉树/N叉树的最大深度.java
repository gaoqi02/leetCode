package com.leet.code.树.多叉树;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 N 叉树，找到其最大深度。
 *
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 *
 * @author gaoqi
 * @date 2020/1/3.
 */
public class N叉树的最大深度 {

    public int maxDepth(Node root) {
        if (root == null) {
            return 1;
        }
        if (root.children == null) {
            return 1;
        }
        int max = 0;
        for (Node node : root.children) {
            int depth = maxDepth(node);
            max = Math.max(max, depth);
        }

        return max + 1;
    }

}
