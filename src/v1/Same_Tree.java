package v1;
/**
 * 2014-3-4
 * @author Alvin
 * Given two binary trees, write a function to check if they are equal or not.
   Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */

public class Same_Tree {

	 public boolean isSameTree(TreeNode p, TreeNode q) {
	        return isSame(p,q);
	    }
	 public boolean isSame(TreeNode p, TreeNode q){
		 if(p== null && q == null)
			 return true;     // 同为空得时候相等
		 else if(p !=null && q!= null){
			  return (p.val == q.val)&&isSame(p.left,q.left) && isSame(p.right,q.right); // 节点相等，左右子树相等 才能放回ture
		 }
		 return false;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
