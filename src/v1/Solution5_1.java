package v1;

import java.util.ArrayList;

public class Solution5_1 {

	 public ArrayList<Integer> postorderTraversal(TreeNode root) {
		 ArrayList<Integer> list =  new ArrayList() ;
		 Traversal(root,list);
		return list;
	        
	    }
	private void Traversal(TreeNode root,ArrayList<Integer> list) {
		if(root != null){
			Traversal(root.left,list);
			Traversal(root.right,list);
			System.out.println(root.val);
			list.add(root.val);
		}
	}
	
	static void print(ArrayList<Integer> list){
		for(int i =0;i<list.size();i++)
			System.out.print(" " + list.get(i));
		System.out.println();
	}
	public static void main(String[] args) {
		TreeNode root  = new TreeNode(1);
		root.left = null;
		TreeNode right  = new TreeNode(2);
		right.left =new TreeNode(3);
		right.right = null;
		root.right = right;
		
		Solution5_1 s = new   Solution5_1();
		print(s.postorderTraversal(root));
	}

}
