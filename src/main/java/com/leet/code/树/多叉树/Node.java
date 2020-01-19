package com.leet.code.树.多叉树;

import java.util.List;

/**
 * @author gaoqi
 * @date 2020/1/2.
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
