/* Construct Binary Tree from Preorder and Inorder Traversal
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
*/
package com.alvin.java;
import java.util.Arrays;

public class Construct_Binary_Tree_from_Preorder_and_InorderI_Traversal{
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0)
            return null;

        int pos = indexOf(inorder,preorder[0]);
        TreeNode node = new TreeNode(preorder[0]);
        //have left subTree
        if(pos >0){
            node.left  = buildTree(Arrays.copyOfRange(preorder,1,pos+1),
                    Arrays.copyOfRange(inorder,0,pos));
        }else
            node.left = null;
        // hava right subTree
        if(pos < preorder.length){
            node.right = buildTree(Arrays.copyOfRange(preorder,pos+1,preorder.length),
                    Arrays.copyOfRange(inorder,pos+1,inorder.length));
        }else
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
        int[] array = {1,2,3,4,5,6,7,8,9};
        int[] pre ={1};
        int[] ino = {1};
        System.out.println(Arrays.toString(Arrays.copyOfRange(array,2,9)));
        System.out.println(new Construct_Binary_Tree_from_Preorder_and_InorderI_Traversal().
                buildTree(pre,ino));
    }
}