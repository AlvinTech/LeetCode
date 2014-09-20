/**  Validate Binary Search Tree
 Given a binary tree, determine if it is a valid binary search tree (BST).

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.
 confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 * */
import java.util.ArrayList;
import java.util.List;
public class Validate_Binary_Search_Tree {

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        List<Integer> list = new ArrayList<Integer>();
        toArray(root, list);

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1))
                return false;
        }
        return true;
    }

    public void toArray(TreeNode node, List<Integer> list) {
        if (node != null) {
            if (node.left != null)
                toArray(node.left, list);
            list.add(node.val);
            if (node.right != null)
                toArray(node.right, list);
        }
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(6);

        root.left = node2;
        node2.left = node1;
        root.right = node3;
        node3.left = node4;
        System.out.println(new Validate_Binary_Search_Tree().isValidBST(root));

    }

}
