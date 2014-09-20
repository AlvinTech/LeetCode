package v1;

import java.util.Stack;

import util.ListNode;

public class AddTwoNumbers {

	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	       
		 long result  = convert(l1) + convert(l2);
		 
		// result = 10000000000l;
		 System.out.println(result);
		 Stack<Integer> s = new Stack<Integer>();
		 do{
			 s.push((int) (result%10));
			 result /= 10;
		 }while(result != 0);
		 
		 
	        ListNode head = null;
	        while( !s.isEmpty()){
	        	ListNode temp = new ListNode((int) s.pop());
	        	temp.next = head;
	        	head  = temp;
	        }
	        return head;
	    }
	 
	 public long convert(ListNode list){
		 long result=0;
		 int index =0;
		 while(list != null){
			 result = (long) (list.val * Math.pow(10, index)+ result);
			 index ++;
			 list = list.next;
		 }
		 return result;
		 
	 }
	 
	public static void main(String[] args) {
		ListNode l1 = new ListNode(9);
		ListNode l2 = new ListNode(1);
		ListNode h1 = l1 ;
		ListNode h2 = l2 ;
	//	System.out.println(-8%10);
		for(int i=9;i>0;i--){
		
			l2.next = new ListNode(9);
		
			l2 = l2.next;
			
		}
		//printList(h1.next);
		System.out.println(new AddTwoNumbers().convert(h2));
		
		
	//	printList(new AddTwoNumbers().addTwoNumbers(h1, h2));
		
		
	}
	  public static  void printList(ListNode list){
		  while(list!= null){
			  System.out.print(list.val+" ");
			  list = list.next;
		  }
		  System.out.println();
	  }

}
