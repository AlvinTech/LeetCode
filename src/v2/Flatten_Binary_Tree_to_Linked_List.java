/*
Flatten Binary Tree to Linked List 
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
*/
import java.util.ArrayList;
import java.util.List;
//class TreeNode{
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x){val = x;}
//}
public class Flatten_Binary_Tree_to_Linked_List{

    public void flatten(TreeNode root) {
        if(root == null)
            return;
        List<TreeNode> list = new ArrayList<TreeNode>();
        addTreeNode(list,root);
        TreeNode node = root;
        for(int i = 1 ;i < list.size();i++){
            node.left = null;
            node.right = list.get(i);
            node = node.right;
        }

    }
    public void addTreeNode(List<TreeNode> list, TreeNode node){
        if(node == null)
            return ;
        list.add(node);
        addTreeNode(list,node.left);
        addTreeNode(list,node.right);
    }
    public static void main(String[] args){
        int  array[] = {1,23,4,5};

    }

}