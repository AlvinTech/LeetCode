import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;



public class Populating_Next_Right_Pointers_in_Each_NodeII {
    public void connect(TreeLinkNode root) {
    	if(root ==  null)
    		return ;
    	root.next = null;
    	Queue<TreeLinkNode> queue = new LinkedBlockingQueue<TreeLinkNode>();
    	queue.add(root);
    	getNext(queue);
    }
    public void getNext(Queue<TreeLinkNode> queue){
    	TreeLinkNode node = null;
    	Queue<TreeLinkNode> nextQ = new LinkedBlockingQueue<TreeLinkNode>();
    	while(!queue.isEmpty()){
    		if(node != null && node.left != null){
    			node.right.next = queue.element().left;
    			//System.out.println(node.right.val +"    "+queue.element().left.val);
    		}
    		node = queue.remove();
    	
    		if(node.left != null){
    			nextQ.add(node.left);
    			nextQ.add(node.right);
    			node.left.next = node.right;
    		//	System.out.println(node.left.val +"    "+ node.right.val);
    		}
    	}
    	if(!nextQ.isEmpty())
    		getNext(nextQ);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//TreeLinkNode root = new TreeLinkNode(0);
		TreeLinkNode p1 = new TreeLinkNode(1);
		TreeLinkNode p2 = new TreeLinkNode(2);
		TreeLinkNode p3 = new TreeLinkNode(3);
		TreeLinkNode p4 = new TreeLinkNode(4);
		TreeLinkNode p5 = new TreeLinkNode(5);
		TreeLinkNode p6 = new TreeLinkNode(6);
		TreeLinkNode p7 = new TreeLinkNode(7);
		p1.left = p2;
		p1.right = p3;
		p2.left = p4;
		p2.right = p5;
		p3.left = p6;
		p3.right = p7;
		new Populating_Next_Right_Pointers_in_Each_NodeII().connect(p1);
	}

}
