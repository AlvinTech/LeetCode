/*
Binary Tree Level Order Traversal II 
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public class Binary_Tree_Level_Order_Traversal_II{
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        levelNode(result,root,0);
        Collections.reverse(result);
        return result;
    }

    public void levelNode(List<List<Integer>> result,TreeNode node,int level){
        if(node == null)
            return ;
        if(level == result.size())
            result.add(new ArrayList());
        result.get(level).add(node.val);
        levelNode(result,node.left,level+1);
        levelNode(result,node.right,level+1);
    }
    public static void main(String[] args){
        System.out.println("Hello world");
    }

}