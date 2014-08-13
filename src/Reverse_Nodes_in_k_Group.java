import java.util.Stack;

import util.ListNode;
import util.Print;

/**
 * 2014-7-19
 * @author Alvin
 * 
 */

public class Reverse_Nodes_in_k_Group {

	
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode newHead = head;
		ListNode node = null;
		ListNode pre = null;
		boolean flag = false;
		while (true) {
			Stack<ListNode> s = new Stack<ListNode>();
			for (int i = 0; i < k; i++) {
				if (head == null)
					return newHead;
				s.add(head);
				head = head.next;
			}
			
		    node = s.pop();
		    if(pre != null)
		    	pre.next = node;
			if (!flag) {
				newHead = node;
				flag = true;
			}
			for (int i = 1; i < k; i++) {
				node.next = s.pop();
				node = node.next;
			}
			node.next = head;
			pre = node;
		}
	}
	 
	public boolean reverse(ListNode pre,ListNode head, int k,ListNode temp){
		ListNode node = head;
		Stack<ListNode> s= new Stack<ListNode>();
		for(int i =0 ;i< k ;i++){
			if(node == null)
				return false;
			s.add(node);
			node = node.next;
		}
		head = s.pop();
		temp = head;
		node = head;
		ListNode aft = node.next;
		
		for(int i =1 ;i< k ;i++){
			node.next = s.pop();
			node =node.next;
		}
		node.next = aft;
		if(pre != null)
			pre.next = head;
		return true;
		
	}
    public ListNode reverseKGroup1(ListNode head, int k) {
    	if(head == null || head.next ==null || k <=1 )
    		return head;
 
    	ListNode newHead = head;
    	ListNode pre  = null;
    	ListNode aft = head;
    	ListNode cur = head;
    	
    	while(aft!=null && aft.next != null  && k >1){
    		if(head.next == null){
    			head = newHead;
    		}
    		aft = head.next;
    		head.next = aft.next;
    		aft.next = newHead;
    		newHead = aft;
    		k--;
    	}
    	return newHead;
        
    }
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
	//	n4.next = n5;
	//	n5.next = n6;
		
		Print.print(new Reverse_Nodes_in_k_Group().reverseKGroup(n1, 2));

	}

}
