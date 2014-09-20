/* DP
Binary Tree Maximum Path Sum
Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
思路：
使用递归函数 放回子树的最大值（只能是单路线值，不存在同时包含父节点和左右子树）；
所以最大值 可能出现在 left ，left+ val，right , right+ val ,right+ val + left 值中的一个。
用全局变量保存 maxSum；
*/
//class TreeNode{
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int v){val = v;}
//}
public class Binary_Tree_Maximum_Path_Sum{
    int maxSum;
    int maxPathSum(TreeNode root) {
        if(root == null)
            return 0;
        maxSum = root.val;
        pathSum(root);
        return maxSum;
    }
    int pathSum(TreeNode node){
        if(node == null)
            return 0;
        int left = pathSum(node.left);
        left = left > 0 ? left : 0;
        int right = pathSum(node.right);
        right = right >0 ? right :0;
        maxSum = Math.max(maxSum,Math.max(node.val,Math.max(node.val+left,Math.max(node.val+right,node.val+ right+ left))));
        return node.val + Math.max(left,right);

    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        System.out.println(new Binary_Tree_Maximum_Path_Sum().maxPathSum(root));
    }

}