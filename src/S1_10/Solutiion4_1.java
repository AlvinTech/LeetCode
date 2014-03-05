package S1_10;

import java.util.Random;

public class Solutiion4_1 {

	public ListNode insertionSortList(ListNode head) {
		if(head != null){
			ListNode headNew = new ListNode(head.val) ;
			head = head.next;
			while(head != null){
				ListNode index = headNew;
				ListNode pre = headNew;
				while(index != null &&index.val <head.val ){
					pre = index;
					index = index.next;
				}
				ListNode node = head.next;
				if(pre == index){
					//the first one
					headNew = head;
					head.next= index;
					head = node;
				
				}
				else{
					pre.next = head;
					head.next = index;
					head = node;
				}
				
			}
			return headNew;
		}
		else
		return head;
        
    }
	
	
	public static  void printList(ListNode list){
		  while(list!= null){
			  System.out.print(list.val+" ");
			  list = list.next;
		  }
		  System.out.println();
	  }
	public static void main(String[] args) {
		ListNode temp = new ListNode(0);
		ListNode head = null;
		head = temp;
		for(int i=10;i>0;i--){
			Random r = new Random();
			ListNode node = new ListNode(r.nextInt(500));
			temp.next= node;
			temp = node;
		}
		Solutiion4_1 s = new Solutiion4_1() ;
		printList(head.next);
		printList(s.insertionSortList(head.next));

	}

}
