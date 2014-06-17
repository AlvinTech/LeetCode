/**
 * 2014-4-9
 * @author Alvin
 * 
 */

public class ConvertSortedArrayToBinarySearchTree {

	 public TreeNode sortedArrayToBST(int[] num) {
		 TreeNode root = findSubTree(0,num.length-1,num);
		 return root;
		 	
	    }
	public TreeNode findSubTree(int start,int end,int[] array){
		if(end - start < 0 ){
			return null;
		}
		else{
			TreeNode root = null;
			int mid = (start +end) /2;
			root = new TreeNode(array[mid]);
			root.left = findSubTree(start,mid-1,array);
			root.right = findSubTree(mid+1,end,array);
			return root;
		}
		
	}
	public static void main(String[] args) {
		int[] array = new int[10];
		for(int i=0;i<10;i++)
			array[i] = i;
		TreeNode root = new ConvertSortedArrayToBinarySearchTree().sortedArrayToBST(array);
		root =null;
	}

}
