package com.leet.code.树.多叉树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 *
 * 返回其后序遍历: [5,6,3,2,4,1].
 *              1
 *      3       2       4
 *   5    6
 *
 * @author gaoqi
 * @date 2020/1/2.
 */
public class N叉树的后序遍历 {

    private List<Integer> list = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        if (root.children != null) {
            for (Node node : root.children) {
                postorder(node);
            }
        }
        list.add(root.val);
        return list;
    }
}
