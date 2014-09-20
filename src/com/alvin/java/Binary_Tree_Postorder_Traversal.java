package com.alvin.java;

import java.util.ArrayList;

/* Binary Tree Postorder Traversal
Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
* */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Binary_Tree_Postorder_Traversal {
   public ArrayList<Integer> postorderTraversal(TreeNode root) {
       ArrayList<Integer> list =  new ArrayList() ;
       Traversal(root,list);
       return list;

   }
   private void Traversal(TreeNode root,ArrayList<Integer> list) {
       if(root != null){
           Traversal(root.left,list);
           Traversal(root.right,list);

           list.add(root.val);
       }
   }
}
