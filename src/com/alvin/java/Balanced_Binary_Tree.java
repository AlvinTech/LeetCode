package com.alvin.java;

/**   Balanced Binary Tree
 Given a binary tree, determine if it is height-balanced.

 For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two
 subtrees of every node never differ by more than 1.
 */
public class Balanced_Binary_Tree {

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        else {
            int deepLeft = deep(root.left) + 1;
            int deepRight = deep(root.right) + 1;
            if (deepLeft < 0 || deepRight < 0)
                return false;
            else if (Math.abs(deepRight - deepLeft) > 1)
                return false;
            else
                return true;

        }

    }

    private int deep(TreeNode root) {
        if (root == null)
            return 0;
        else {
            int deepLeft = deep(root.left) + 1;
            int deepRight = deep(root.right) + 1;
            if (Math.abs(deepRight - deepLeft) > 1)
                return -10;
            else
                return deepLeft > deepRight ? deepLeft : deepRight;
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode p1 = new TreeNode(1);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(3);
        TreeNode p4 = new TreeNode(4);
        TreeNode p5 = new TreeNode(5);
        TreeNode p6 = new TreeNode(6);
        TreeNode p7 = new TreeNode(7);
        root.left = p1;
        root.right = p2;
        p1.left = p3;
        p3.left = p5;
        p2.right = p4;
        p4.right = p6;
        // p4.left =p5;

        System.out.println(new Balanced_Binary_Tree().isBalanced(root));

    }
}
