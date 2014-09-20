package v1;
import util.ListNode;

/**
 * 2014-4-28
 * @author Alvin
 * 
 */

public class Merge_Two_Sorted_Lists {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null)
			return l2;
		else if(l2 == null){
			return l1;
		}
		else{
			ListNode list = new ListNode(-1);
			ListNode index = list;
			
			while (l1 != null && l2 != null) {
				if (l1.val > l2.val) {
					index.next = l2;
					l2 = l2.next;
				} else {
					index.next = l1;
					l1 = l1.next;
				}
				index = index.next;
			}
			
			if (l1 == null) {
				index.next = l2;
			} else if (l2 == null)
				index.next = l1;
			return list.next;
			
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Merge_Two_Sorted_Lists().mergeTwoLists(new ListNode(1), new ListNode(1));
	}

}
