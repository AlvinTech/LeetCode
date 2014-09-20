package v1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 2014-9-9
 * @author Alvin
 * 
 */
class UndirectedGraphNode {
      int label;
      List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 };
public class Clone_Graph {
	
//    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) { 
//    	Map<Integer,UndirectedGraphNode> map  = new HashMap<Integer,UndirectedGraphNode>();
//        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
//        queue.offer(node);
//    	UndirectedGraphNode curNode;
//    	while(!queue.isEmpty()){
//    		curNode = queue.poll();
//    		if(!map.containsKey(curNode.label)){
//    			map.put(curNode.label, new UndirectedGraphNode(curNode.label)) ;
//    			}
//    		if(null != curNode.neighbors){
//    			for(UndirectedGraphNode neighbor : curNode.neighbors){
//    				if(!map.containsKey(neighbor.label)){
//    					queue.offer(neighbor);
//    	    			map.put(neighbor.label, new UndirectedGraphNode(neighbor.label)) ;
//    				}
//    				map.get(curNode.label).neighbors.add(map.get(neighbor.label));
//    			}
//    		}
//    	}
//		return map.get(node.label);
//        
//    }	
	Map<Integer,UndirectedGraphNode> map  = new HashMap<Integer,UndirectedGraphNode>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {   	
 	if(node == null)
 		return null;    	
 	UndirectedGraphNode newNode;
 	if(!map.containsKey(node.label)){
 		newNode = new UndirectedGraphNode(node.label);
 		map.put(node.label,newNode );
 		
 	}else
 		newNode = map.get(node.label);
 	List<UndirectedGraphNode> newList = newNode.neighbors;
 	List<UndirectedGraphNode> list = node.neighbors;
 	for(int i =0;i< list.size();i++){
 	    if(map.containsKey(list.get(i).label)){
 	       newList.add(map.get(list.get(i).label)); 
 	    }
 		else if(list.get(i).label != node.label )
	    		newList.add(cloneGraph(list.get(i)));
 		else
 			newList.add(newNode);
 	}
		return newNode;
     
 }
	public static void main(String[] args) {
		UndirectedGraphNode node = new UndirectedGraphNode(-1);
		UndirectedGraphNode node1 = new UndirectedGraphNode(1);
		List<UndirectedGraphNode> list = node.neighbors;
		list.add(node1);
		
		UndirectedGraphNode root = new Clone_Graph().cloneGraph(node);	
			System.out.println(root);
	}	
}
