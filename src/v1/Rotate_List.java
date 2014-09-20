package v1;
/**
 * 2014-9-10
 * @author Alvin
 * 
 */

public class Rotate_List {
    public ListNode rotateRight(ListNode head, int n) {
	    if(n  == 0 || head == null)
    		return head;
    	int size =0;
    	ListNode step = head;
    	ListNode last = head;
    	while(step != null){
    		last = step;
    		size++;
    		step = step.next;
    	}
    	n =  n % size;
    	if(n  == 0)
    		return head;

    	step = head;
        ListNode newLast = head;
    	for(int i=0;i< size -n;i++){
            newLast = step;
    		step = step.next;
    	}
        newLast.next = null;
    	last.next = head;
    	return step;
    }
    public static void print(ListNode head){
    	while(head != null){
    		System.out.print( " " + head.val);
    		head = head.next;
    	}
    }
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		node1.next =  node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		print(new Rotate_List().rotateRight(node1,2));
		System.out.println("Hellow rold");
	}
}