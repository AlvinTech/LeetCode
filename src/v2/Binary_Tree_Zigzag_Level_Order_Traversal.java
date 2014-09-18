/*
Binary Tree Zigzag Level Order Traversal 
My Submissions
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
*/
import java.util.List;
import java.util.ArrayList;
public class Binary_Tree_Zigzag_Level_Order_Traversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<TreeNode> list = new ArrayList<TreeNode>();
        if(root == null)
            return result;
        list.add(root);
        boolean flag =  true;
        while(list.size() != 0){
            List<Integer> intList = new ArrayList<Integer>();
            List<TreeNode> nextList = new ArrayList<TreeNode>();
            for (int i=0;i < list.size() ;i++ ) {
                int index = list.size()-1-i;
                if(flag)
                    index = i;
                TreeNode node = list.get(i);
                intList.add(list.get(index).val);
                if(node.left != null)
                    nextList.add(node.left);
                if(node.right != null)
                    nextList.add(node.right);
            }
            list = nextList;
            result.add(intList);
            flag = !flag;
        }
        return result;
    }
    public static void main(String[] args) {
        // TreeNode root =  BuildTree.buildTree();
        TreeNode root =  new TreeNode(1);
        List<List<Integer>> result = new Binary_Tree_Zigzag_Level_Order_Traversal().zigzagLevelOrder(root);
        for (int i=0; i< result.size();i++ ) {
            System.out.println(result.get(i));
        }
        System.out.println("Hello world");
    }
}
