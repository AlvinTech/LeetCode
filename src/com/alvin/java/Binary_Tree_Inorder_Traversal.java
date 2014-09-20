package com.alvin.java; /** Binary Tree Inorder Traversal
 Given a binary tree, return the inorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},
 1
 \
 2
 /
 3
 return [1,3,2].

 Note: Recursive solution is trivial, could you do it iteratively?


 */
import java.util.List;
import java.util.Vector;

public class Binary_Tree_Inorder_Traversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        Vector<Integer> v = new Vector<Integer>();
        Traversal(root,v);
        return v;
    }

    public void Traversal(TreeNode root, Vector<Integer> v){
        if(root == null)
            return;
        else{
            Traversal(root.left,v);
            v.add(root.val);
            Traversal(root.right,v);
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}

