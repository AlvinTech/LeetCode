/** Path Sum II
 Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \    / \
 7    2  5   1
 return
 [
 [5,4,11,2],
 [5,8,4,5]
 ]
 *
 */
package com.alvin.java;
import java.util.ArrayList;
import java.util.List;

public class Path_Sum_II {
    private List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> list = new ArrayList<Integer>();
    public List<List<Integer>> pathSum(TreeNode root, int sum){
        if(root == null)
            return result;
        list.add(root.val);
        if(root.left == null && root.right == null && root.val == sum){
           result.add(new ArrayList<Integer>(list));
        }
        pathSum(root.left,sum -  root.val);
        pathSum(root.right, sum - root.val);
        list.remove(list.size()-1);
        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode p1 = new TreeNode(1);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(3);
        TreeNode p4 = new TreeNode(4);
        TreeNode p5 = new TreeNode(5);
        TreeNode p6 = new TreeNode(6);
        root.left = p1;
        root.right = p2;
        p1.left = p3;
        p2.left = p4;
        p2.right = p5;
        new Path_Sum_II().pathSum(root,4);
        System.out.println(p2.val);
    }

}
