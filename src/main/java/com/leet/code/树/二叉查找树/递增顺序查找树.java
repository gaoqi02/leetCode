package com.leet.code.树.二叉查找树;

import com.leet.code.树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 给定一个树，按中序遍历重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 示例 ：
 输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
 5
 / \
 3    6
 / \    \
 2   4    8
  /        /
 1        7

 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 1
   \
    2
     \
      3
       \
        4
         \
          5
           \
            6
             \
              7
               \
                8
  

 * @date 2020/1/3.
 */
public class 递增顺序查找树 {

    TreeNode res;
    public TreeNode increasingBST(TreeNode root) {
        res = new TreeNode(0);
        TreeNode t = res;
        helper(root);
        return t.right;
    }
    public void helper(TreeNode root) {
        if(root == null) {
            return;
        }
        helper(root.left);
        TreeNode n = new TreeNode(root.val);
        res.right = n;
        res = n;
        helper(root.right);
    }

}
