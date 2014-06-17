/**
 * 2014-6-13
 * @author Alvin
 * 
 */
import java.util.Vector;
public class Sum_Root_to_Leaf_Numbers {

	private Vector<Integer> vector = new Vector<Integer>();
	public int sumNumbers(TreeNode root) {
	     int result = 0 ;
	     if(root == null)
	    	 return result;
	    
	     String s ="";
	     saveNumber(s,root);
	     for(int i=0;i<vector.size();i++){
	    	 result += vector.get(i);
	     }
	     return result;
	}
	public void saveNumber(String s, TreeNode node){
		s += node.val;
		if(node.left == null && node.right ==null){
			vector.add(Integer.parseInt(s));
		}
		else{
			
			if(node.left != null)
				 saveNumber(s,node.left);
			if(node.right != null)
				 saveNumber(s,node.right);
		}
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode p2 = new TreeNode(2);
		TreeNode p3 = new TreeNode(3);
		root.left = p2;
		root.right = p3;
		System.out.println(new Sum_Root_to_Leaf_Numbers().sumNumbers(root));
		
	}

}
