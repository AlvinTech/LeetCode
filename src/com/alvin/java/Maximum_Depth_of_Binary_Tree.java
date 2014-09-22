
/** Maximum Depth of Binary Tree
 * 2014-3-4
 * @author Alvin
 * Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 思路：
 *    采用递归调用，确保每一次递归返回的答案都是最优解。
 */

package com.alvin.java;

public class Maximum_Depth_of_Binary_Tree {

    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int heightLeft  = maxDepth(root.left)+1;  //返回 左子树的高度
        int heightRight = maxDepth(root.right)+1;//返回 右子树的高度
        return (heightLeft > heightRight)? heightLeft : heightRight;
    }



    public static void main(String[] args) {
        Maximum_Depth_of_Binary_Tree solution = new Maximum_Depth_of_Binary_Tree();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1) ;
        root.right = new TreeNode(1) ;
        root.right.right  = new TreeNode(2) ;
        System.out.println(solution.maxDepth(root));

    }

}
