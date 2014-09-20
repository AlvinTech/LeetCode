package com.alvin.java;

import java.util.ArrayList;

/* Binary Tree Preorder Traversal
Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?
* */
public class Binary_Tree_Preorder_Traversal {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list =  new ArrayList() ;
        Traversal(root,list);
        return list;
    }

    private void Traversal(TreeNode root,ArrayList<Integer> list) {
        if(root != null){
            list.add(root.val);
            Traversal(root.left,list);
            Traversal(root.right,list);


        }
    }
}
