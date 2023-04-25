package com.tree;

import javax.validation.constraints.Max;
import java.util.ArrayList;

public class Work {

    /*
                 1
                / \
               2   3
              / \   \
             4  5   6
            /
           7
     */
    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);
        TreeNode r6 = new TreeNode(6);
        TreeNode r7 = new TreeNode(7);

        r1.left = r2;
        r1.right = r3;
        r2.left = r4;
        r2.right = r5;
        r3.right = r6;
        r4.left = r7;

//        System.out.println(getNodeNumRec(r1));
//        System.out.println(getDepth(r1));
        System.out.println(levelTraversalRec(r1));
    }

    // 求二叉树中的节点个数
    public static int getNodeNumRec(TreeNode root) {
        if (root == null) return 0;
        return getNodeNumRec(root.left) + getNodeNumRec(root.right) + 1;
    }

    // 求二叉树的深度
    public static int getDepth(TreeNode root) {
        if (root == null) return 0;

        int left = getDepth(root.left);
        int right = getDepth(root.right);

        return Math.max(left, right) + 1;
    }

    // 分层遍历二叉树（按层次从上往下，从左往右）
    public static ArrayList<ArrayList<Integer>> levelTraversalRec(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        dfs(root, 0, ret);
        return ret;
    }

    public static void dfs(TreeNode root, int level, ArrayList<ArrayList<Integer>> ret) {
        if (root == null) return;
        if (level >= ret.size()) {
            ArrayList<Integer> list = new ArrayList<>();
            ret.add(list);
        }

        ret.get(level).add(root.val);
        dfs(root.left, level + 1, ret);
        dfs(root.right, level + 1, ret);
    }

    //将二叉查找树变为有序的双向链表
    public static void convertBST2DLLRec(TreeNode root) {

    }

    //求二叉树第K层的节点个数：getNodeNumKthLevelRec
    public static int getNodeNumKthLevelRec(TreeNode root, int k) {
        if (root == null || k < 1) return 0;
        if (k == 1) {
            return 1;
        }
        int numLeft = getNodeNumKthLevelRec(root.left, k - 1);
        int numRight = getNodeNumKthLevelRec(root.right, k - 1);

        return numLeft + numRight;
    }

    //求二叉树中叶子节点的个数：getNodeNumLeafRec
    public static int getNodeNumLeafRec(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null || root.right == null) return 1;
        return getNodeNumLeafRec(root.left) + getNodeNumLeafRec(root.right);
    }

    // 判断两棵二叉树是否相同的树
    public static boolean isSameTree(TreeNode r1, TreeNode r2) {
        // 如果两棵二叉树都为空，返回真
        if (r1 == null && r2 == null) {
            return true;
        } // 如果两棵二叉树一棵为空，另一棵不为空，返回假
        else if (r1 == null || r2 == null) {
            return false;
        }

        if (r1.val == r2.val) return true;

        boolean left = isSameTree(r1.left, r2.left);
        boolean right = isSameTree(r1.right, r2.right);
        return left && right;
    }

    // 判断二叉树是不是平衡二叉树：isAVLRec
    public static boolean isAVLRec(TreeNode root) {
        if (root == null) {           // 如果二叉树为空，返回真
            return true;
        }

        // 如果左子树和右子树高度相差大于1，则非平衡二叉树, getDepthRec()是前面实现过的求树高度的方法
        if (Math.abs(getDepth(root.left) - getDepth(root.right)) > 1) {
            return false;
        }

        // 递归判断左子树和右子树是否为平衡二叉树
        return isAVLRec(root.left) && isAVLRec(root.right);
    }

    // 求二叉树的镜像 递归解法 破坏了原来的树
    public static TreeNode mirrorRec(TreeNode root) {
        if (root == null) return null;
        TreeNode left = mirrorRec(root.left);
        TreeNode right = mirrorRec(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    // 新建一个节点
    public static TreeNode mirrorCopyRec(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode newNode = new TreeNode(root.val);
        newNode.left = mirrorCopyRec(root.right);
        newNode.right = mirrorCopyRec(root.left);

        return newNode;
    }

    /**
     * 求二叉树中两个节点的最低公共祖先节点
     * 递归解法：
     * （1）如果两个节点分别在根节点的左子树和右子树，则返回根节点
     * （2）如果两个节点都在左子树，则递归处理左子树；如果两个节点都在右子树，则递归处理右子树
     */
    public static TreeNode getLastCommonParentRec(TreeNode root, TreeNode n1, TreeNode n2) {
        if (findNodeRec(root.left, n1)) {               // 如果n1在树的左子树
            if (findNodeRec(root.right, n2)) {      // 如果n2在树的右子树
                return root;                                // 返回根节点
            } else {            // 如果n2也在树的左子树
                return getLastCommonParentRec(root.left, n1, n2); // 递归处理
            }
        } else {                // 如果n1在树的右子树
            if (findNodeRec(root.left, n2)) {           // 如果n2在左子树
                return root;
            } else {                 // 如果n2在右子树
                return getLastCommonParentRec(root.right, n1, n2); // 递归处理
            }
        }
    }

    private static boolean findNodeRec(TreeNode root, TreeNode node) {
        if (root == null || node == null) {
            return false;
        }
        if (root == node) return true;
        boolean left = findNodeRec(root.left, node);
        boolean right = findNodeRec(root.right, node);

        return left && right;
    }

    // 求二叉树中节点的最大距离
    public static Result getMaxDistanceRec(TreeNode root) {
        if (root == null) return new Result(0, 0);
        Result left = getMaxDistanceRec(root.left);
        Result right = getMaxDistanceRec(root.right);

        Result res = new Result();
        res.maxDepth = Math.max(left.maxDepth, right.maxDepth) + 1;        // 当前最大深度
        res.maxDistance = Math.max(left.maxDepth + right.maxDepth, Math.max(left.maxDistance, right.maxDistance));
        return res;
    }

    private static class Result {
        int maxDistance;
        int maxDepth;

        public Result() {
        }

        public Result(int maxDistance, int maxDepth) {
            this.maxDistance = maxDistance;
            this.maxDepth = maxDepth;
        }
    }
}
