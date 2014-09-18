package v1;
/**
 * 2014-9-6
 * @author Alvin
 * 
 */

/*
util
*/
import java.util.List;
import java.util.ArrayList;
public class BuildTree{
	public static TreeNode buildTree(){
		int val = 1;
		TreeNode root = new TreeNode(val++);
		List<TreeNode> list  = new ArrayList<TreeNode>();
		list.add(root);
		while(val < 16){
			List<TreeNode> nextList  = new ArrayList<TreeNode>();
			for (int i =0;i < list.size() ;i++ ) {
				TreeNode node = list.get(i);
				TreeNode left = new TreeNode(val++);
				TreeNode right = new TreeNode(val++);
				node.left = left;
				node.right = right;
				nextList.add(left);
				nextList.add(right);
			}
			list = nextList;
		}
		return root;
	}
	public static void printTree(TreeNode root){
		if(root != null){
			System.out.println(root.val);
			printTree(root.left);
			printTree(root.right);
		}
	}
	public static void main(String[] args) {
		BuildTree.printTree(BuildTree.buildTree());
		int[] num ={1,2,3,4};
		List<Integer> list = new ArrayList<Integer>();
		num = list.toArray(new int[5]);
	}
}