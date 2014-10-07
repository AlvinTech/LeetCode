 /**  Sum Root to Leaf Numbers
 Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

 An example is the root-to-leaf path 1->2->3 which represents the number 123.

 Find the total sum of all root-to-leaf numbers.

 For example,

 1
 / \
 2   3
 The root-to-leaf path 1->2 represents the number 12.
 The root-to-leaf path 1->3 represents the number 13.

 Return the sum = 12 + 13 = 25.
 */

/**
 * 2014-6-13
 * @author Alvin
 *
 */
package com.alvin.java;
import java.util.Vector;

public class Sum_Root_to_Leaf_Numbers {
    int total =0;
    public int sumNumbers(TreeNode root) {
        int result = 0 ;
        if(root == null)
            return result;
        String s ="";
        saveNumber(s,root);
        return total;
    }
    public void saveNumber(String s, TreeNode node){
        s += node.val;
        if(node.left == null && node.right ==null){
            total += Integer.parseInt(s);
        }
        else{
            if(node.left != null)
                saveNumber(s,node.left);
            if(node.right != null)
                saveNumber(s,node.right);
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(3);
        root.left = p2;
        root.right = p3;
        System.out.println(new Sum_Root_to_Leaf_Numbers().sumNumbers(root));

    }

}
