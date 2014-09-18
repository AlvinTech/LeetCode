package v1;
/**
 * 2014-9-2
 * @author Alvin
 * 
 */
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
public class Recover_Binary_Search_Tree{
	private Map<Integer,TreeNode> map = new HashMap<Integer,TreeNode>();
	boolean flag = false;
	public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        searchTree(list,root);
       
 
        int temp = map.get(1).val;
        map.get(1).val = map.get(2).val;
        map.get(2).val = temp;
     

    }
    public void searchTree(List<TreeNode>list, TreeNode node){
    	if(node == null)
    		return ;   
    	searchTree(list,node.left);
    	if(!map.containsKey(3))
    		map.put(3, node);
   	
    	if(node.val < map.get(3).val){
    		if(!flag){
    			flag = true;
    			map.put(1, map.get(3));
    			map.put(2, node);
    		}else
    			map.put(2, node);
    	}
    	searchTree(list,node.right);
    }
	public static void main(String[] args){
		TreeNode root = new TreeNode(0);
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(1);
		TreeNode c = new TreeNode(1);
		TreeNode d = new TreeNode(1);
		root.left= a;
		//a.left = b;
		new Recover_Binary_Search_Tree().recoverTree(root);
		
	} 
}