/* Symmetric Tree
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.

*/

//class TreeNode{
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x ){val = x;}
//}
package com.alvin.java;
public class Symmetric_Tree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return isSymmetricLevel(root.left,root.right);
    }
    public boolean isSymmetricLevel(TreeNode left,TreeNode right){
        if(left == null && right == null)
            return true;
        if(left == null || right == null)
            return false;
        if(left.val != right.val)
            return false;
        return (isSymmetricLevel(left.left, right.right) && isSymmetricLevel(left.right,right.left));
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(4);
        root.left = node1;
        //root.right = node2;
        //node2.left = node3;

        System.out.println(new Symmetric_Tree().isSymmetric(root) );
    }

}