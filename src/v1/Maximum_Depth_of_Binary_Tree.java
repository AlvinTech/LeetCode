package v1;
/**
 * 2014-3-4
 * @author Alvin
 * 
 * Given a binary tree, find its maximum depth.
   The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */

public class Maximum_Depth_of_Binary_Tree {

	public int maxDepth(TreeNode root) {
        return depth(root,0);
    }
	
	public int depth(TreeNode node ,int height){
		
		if(node == null)
			return 0;
		else {
			int heightLeft  = depth(node.left,height)+1;  //返回 左子树的高度
			int heightRight = depth(node.right,height)+1;//返回 右子树的高度
			if(heightLeft > heightRight)     // 返回最优解
				return heightLeft;   
			else
				return heightRight;
		}
			
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

/**思路：
 *    采用递归调用，确保每一次递归返回的答案都是最优解。
 */
