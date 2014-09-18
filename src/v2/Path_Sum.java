/**
 Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \      \
 7    2      1
 return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class Path_Sum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null )
            return false;
        else{
            boolean right = false, left = false;
            if(root.right == null && root.left == null && root.val == sum){
                return true;
            }
            if(root.right != null)
                right  = hasPathSum(root.right,sum -root.val);
            if(root.left != null)
                left = hasPathSum(root.left,sum- root.val);
            return left||right;
        }

    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode r = new TreeNode(-2);
        TreeNode l = new TreeNode(3);
        root.left = r;
        root.right =l;
        System.out.println(new Path_Sum().hasPathSum(root, -1) );

    }
}
