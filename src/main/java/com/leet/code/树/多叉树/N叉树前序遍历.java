package com.leet.code.树.多叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaoqi
 * @date 2020/1/2.
 */
public class N叉树前序遍历 {

    List<Integer> list = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root == null) {
            return list;
        }
        list.add(root.val);
        for (Node node : root.children) {
            preorder(node);
        }
        return list;
    }

}
