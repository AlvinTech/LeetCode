/** Binary Tree Level Order Traversal
 Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

 For example:
 Given binary tree {3,9,20,#,#,15,7},
 3
 / \
 9  20
 /  \
 15   7
 return its level order traversal as:
 [
 [3],
 [9,20],
 [15,7]
 ]
 confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 解题思路 广度优先收索
Binary Tree Level Order Traversal 二叉树的层遍历
*/
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
//class TreeNode{
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x){val = x;}
//}
public class Binary_Tree_Level_Order_Traversal{
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<TreeNode> levelNode = new ArrayList<TreeNode>();
        if(root == null)
            return result;
        else
            levelNode.add(root);

        order(result,levelNode);
        return result;
    }

    public void order(List<List<Integer>> result, List<TreeNode> levelNode){
        if(levelNode.size()== 0)
            return;

        List<TreeNode> newLevelNode = new ArrayList<TreeNode>();
        List<Integer> levelVal = new ArrayList<Integer>();
        TreeNode temp = null;
        for (int i = 0;i < levelNode.size() ;i++ ) {
            temp = levelNode.get(i);
            levelVal.add(temp.val);
            if(temp.left != null)
                newLevelNode.add(temp.left);
            if(temp.right != null)
                newLevelNode.add(temp.right);
        }
        result.add(levelVal);
        order(result,newLevelNode);

    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        List<List<Integer>> result = new Binary_Tree_Level_Order_Traversal().levelOrder(null);
        for(int i = 0 ; i < result.size();i++){
            System.out.println(Arrays.toString(result.get(i).toArray()));
        }
        System.out.println("Hello World!");
    }
}