import util.ListNode;

/**
 * 2014-3-11
 * @author Alvin
 * Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?

思路： 跑得慢的被跑得快在结束前追上了：说明存在回路。
 */

public class Linked_List_Cycle {

	  public boolean hasCycle(ListNode head) {
			  ListNode slow = head;
			  ListNode fast = head;
			  while( slow != null  &&fast!= null && fast.next!= null){
				  slow = slow.next;
				  fast = fast.next.next;
				  if(slow == fast)
					  return true;
			  }
		  
	        return false;
	    }
	  
	public boolean cycle(ListNode head)
	{
		if(head== null || head.next== null)
			return false;
		else
		{
			ListNode root = head;
			ListNode index = head.next;
			
			int step = 0;
			while(index!= null){
				int i=0;
				ListNode go =head;
				while(i<=step){
					if(index == go)
						return true;
					else
						go = go.next;
					i++;
				}
				step++;
				index= index.next;
			}
			return false;
		}
				
	}

	
	public static void main(String[] args) {
	
		ListNode root=new ListNode(1);
		ListNode p = new ListNode(2);
		ListNode p1 = new ListNode(3);
		ListNode p2 = new ListNode(4);
		ListNode p3 = new ListNode(5);
		root.next = p;
		//p.next = p1;
	//	p1.next = p;
		//p2.next =p2;
		Linked_List_Cycle cycle = new Linked_List_Cycle();
		System.out.println(cycle.hasCycle(root));
	}

}
