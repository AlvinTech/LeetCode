package com.alvin.java;

/*
Minimum Depth of Binary Tree 
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path
 from the root node down to the nearest leaf node.
*/
public class Minimum_Depth_of_Binary_Tree {
    int  minDeep = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        deepTree(root,1);
        return minDeep;
    }

    public void deepTree(TreeNode node,int deep){
        if(node.left == null && node.right == null){
            minDeep = Math.min(minDeep,deep);
        }
        if(deep >= minDeep)
            return;
        if(node.left != null)
            deepTree(node.left,deep+1);
        if(node.right != null)
            deepTree(node.right,deep+1);
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(1);
        TreeNode d = new TreeNode(1);
        root.left = a;
        root.right = b;
        b.left = c;
        b.right= d;


        System.out.println(new Minimum_Depth_of_Binary_Tree().minDepth(root));
    }
}