package v1;
import java.util.List;
import java.util.Vector;

/**
 * 2014-7-3
 * @author Alvin
 * 
 */

public class Binary_Tree_Inorder_Traversal {

	public List<Integer> inorderTraversal(TreeNode root) {
		Vector<Integer> v = new Vector<Integer>();
		Traversal(root,v);
		return v;
	}
	
	public void Traversal(TreeNode root, Vector<Integer> v){
		if(root == null)
			return;
		else{
			Traversal(root.left,v);
			v.add(root.val);
			Traversal(root.right,v);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
