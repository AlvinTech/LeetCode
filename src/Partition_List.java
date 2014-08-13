import util.ListNode;
import util.Print;

/**
 * 2014-7-22
 * @author Alvin
 * 
 */

public class Partition_List {

    public ListNode partition(ListNode head, int x) {
    	ListNode small = null;
    	ListNode smallStep = null;
    	ListNode bigStep = null;
    	ListNode big = null;
    	while(head != null){
    		if(head.val < x){
    			if(smallStep == null){
    				small = head;
    				smallStep = small;
    			}else{
    				smallStep.next = head;
    				smallStep  = smallStep.next;
    			}
    		}else{
    			if(bigStep == null){
    				big = head;
    				bigStep = big;
    			}else{
    				bigStep.next = head;
    				bigStep  = bigStep.next;
    			}
    		}
    		
    		head = head.next;
    	}
    	bigStep.next = null;
    	if(small == null){
    		
    		return big;
    	}else{
    		smallStep.next = big;
    		return small;
    	}
    }
	public static void main(String[] args) {
		// 1->4->3->2->5->2
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(2);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		
		
		
		Print.print(new Partition_List().partition(n1, 3));
	}

}
