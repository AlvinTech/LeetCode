/**
 * 2014-5-30
 * @author Alvin
 * 
 */
import java.util.*;
public class PathSumII {

	private List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	if(root == null)
    		return result;
    	List<Integer> list = new ArrayList<Integer>();
    	TotalSum(root,sum,list);
        return result;
    }
    
   public  void TotalSum(TreeNode node, int sum, List<Integer> list){
	   List<Integer> array = new ArrayList<Integer>(list);
	   array.add(node.val);
	   if(node.left == null && node.right ==null){
		   if(getSum(array) ==sum){
			   result.add(array);
		   }
	   }
	   else{
		   if(node.left != null)
			   TotalSum(node.left,sum,array);
		   if(node.right != null)
			   TotalSum(node.right,sum,array);
	   }
    }
	
   private int getSum(List<Integer> list) {
	   int val =0;
	   for(int i=0;i< list.size();i++)
		   val += list.get(i);
	   return val;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		TreeNode p1 = new TreeNode(1);
		TreeNode p2 = new TreeNode(2);
		TreeNode p3 = new TreeNode(3);
		TreeNode p4 = new TreeNode(4);
		TreeNode p5 = new TreeNode(5);
		TreeNode p6 = new TreeNode(6);
		root.left = p1;
		root.right = p2;
		p1.left = p3;
		p2.left = p4;
		p2.right = p5;
		new PathSumII().pathSum(root,4);
		System.out.println(p2.val);
	}

}
