package com.leet.code.树.二叉树;

//import com.sun.source.tree.BinaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 *  
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 *
 * @author gaoqi
 * @date 2020/3/31.
 */
public class 重构二叉树 {

    static HashMap<String, Integer> dic = new HashMap<>();
    static String[] po;

    public static TreeNode buildTree(String[] preorder, String[] inorder) {
        po = preorder;
        for (int i = 0; i < inorder.length; i++) {
            dic.put(inorder[i], i);
        }
        return recur(0, 0, inorder.length - 1);
    }

    static TreeNode recur(int preRoot, int inLeft, int inRight) {
        if (inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(po[preRoot]);
        int i = dic.get(po[preRoot]);
        root.left = recur(preRoot + 1, inLeft, i - 1);
        root.right = recur(preRoot + i - inLeft + 1, i + 1, inRight);
        return root;
    }

    public static void main(String[] args) {
        String[] pre = new String[]{"3", "9", "20", "15", "7"};
        String[] in = new String[]{"9", "13", "15", "20", "7"};
        TreeNode root = buildTree(pre, in);
        System.out.println(root);

    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        String val;

        public TreeNode(String val) {
            this.val = val;
        }
    }
}
