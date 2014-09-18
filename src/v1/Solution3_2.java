package v1;

import java.util.Random;

public class Solution3_2 {

	 public ListNode sortList(ListNode head) {
		  
		 
		  return  QuickSort(head);
	        
	    }
	 
	 
	 
	 
	 
	 
	 
	 
	 private ListNode QuickSort(ListNode head) {
		 if(head == null || head.next == null)
			 return head;
		 ListNode now = head;
		 ListNode pre = head;
		 ListNode next = head ;
		 ListNode key = head;
		 ListNode go = head;
		 if(key.next != null){
			 go = key.next;
		 }
		 while(true){
			 
			 if(key.val > go.val){
				 if(go.next != null){
					 next.next = go.next;
				 }
				 else
					 next.next =null;
					 
				 go.next = head;
				 head = go;
				 if(next.next != null)
					 go = next.next;
				 else
					 break;
				 
				 
			 }
			 else if(go.next != null){
				 next = go;
				 go = go.next;
			 }
			 else
				 break;
			 
			  
			 
		 }
		 
		 ListNode temp = head;
		
		
		 if(temp !=null&&temp.val!=key.val){
			 while( temp.next != null&& temp.next.val!=key.val ){
				 temp = temp.next;
			 }
			 temp.next = null;
			
		 }
		 else{
			 head =null;
			 
		 }
		 ListNode left = QuickSort(head);	 
		 ListNode right = QuickSort(key.next);
		
		 if(left!=null){
			 temp = left;
		 	 while(temp.next!=null){
		 		temp = temp.next;
		 	 }
		 	 temp.next = key;
		 	 key.next = right;
		 	 head = left;
		 }
		 else
		 {
			 key.next = right;
			 head = key;
			 }
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
		ListNode head = null;
		ListNode temp = new ListNode(0);
		head = temp;
		
		ListNode node1 = new ListNode(5);
		ListNode node2 = new ListNode(6);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(1);
		ListNode node5 = new ListNode(7);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		for(int i=500;i>0;i--){
			Random r = new Random();
			ListNode node = new ListNode(r.nextInt(500));
			temp.next= node;
			temp = node;
		}
		//printList(node1);
		Solution3_2 s = new Solution3_2() ;
		printList(s.sortList(head.next));

	}

}
