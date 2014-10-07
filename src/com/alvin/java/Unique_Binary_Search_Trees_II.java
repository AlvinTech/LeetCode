/*
Unique Binary Search Trees II 
Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.


*/
package com.alvin.java;
import java.util.ArrayList;
import java.util.List;

public class Unique_Binary_Search_Trees_II {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] result = new List[n+1];
        result[0] = new ArrayList<TreeNode>();
        result[0].add(null);
        for(int i = 1; i <= n; i++){
            result[i] = new ArrayList<TreeNode>();
            for(int j = 0;j < i; j++){
                for(TreeNode nodeLeft : result[j])
                    for(TreeNode nodeRight : result[i - 1 - j]){
                        TreeNode node = new TreeNode(j+1);
                        node.left = nodeLeft;
                        node.right = reValClone(nodeRight,j+1);
                        result[i].add(node);
                    }
            }
        }
        return result[n];
    }

    public TreeNode reValClone(TreeNode node,int offset){
        if(node == null)
            return null;
        TreeNode newNode = new TreeNode(node.val + offset);
        newNode.left = reValClone(node.left,offset);
        newNode.right = reValClone(node.right,offset);
        return newNode;
    }
    public static void main(String[] args) {
        System.out.println("Hello world");
    }
}