/**
Construct Binary Tree from Inorder and Postorder Traversal 
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
*/
package com.alvin.java;
import java.util.Arrays;

public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int length = inorder.length;
        if(length ==0)
            return null;
        int pos = indexOf(inorder,postorder[length-1]);
        TreeNode node = new TreeNode(postorder[length-1]);
        if(pos >0)
            node.left = buildTree(Arrays.copyOfRange(inorder,0,pos),
                    Arrays.copyOfRange(postorder,0,pos));
        else
            node.left = null;
        if(pos < length)
            node.right = buildTree(Arrays.copyOfRange(inorder,pos+1,length),
                    Arrays.copyOfRange(postorder,pos,length-1));
        else
            node.right = null;
        return node;
    }

    public int  indexOf(int[]  array, int x){
        for (int i =0 ; i < array.length ;i++ ) {
            if(array[i] == x)
                return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

}