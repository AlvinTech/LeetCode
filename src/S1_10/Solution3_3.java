package S1_10;

import java.util.Random;

public class Solution3_3 {

	 public ListNode sortList(ListNode head) {
		  return  QuickSort(head);
	    }
	 private ListNode QuickSort(ListNode head) {
		 if(head == null || head.next == null)
			 return head;
		 ListNode key = head;
		 ListNode go = head;
		 
		 ListNode linkR = new ListNode(0);
		 ListNode linkL = new ListNode(0);
		 ListNode linkRgo = linkR;
		 ListNode linkLgo = linkL;
		 if(key.next != null){
			 go = key.next;
		 }
		 while(go!= null){
			 if(go.val> key.val){
				 linkRgo.next = go;
				 linkRgo = linkRgo.next;
			 }
			 else{
				 linkLgo.next = go;
				 linkLgo = linkLgo.next;
			 }
			 go=go.next; 	 
		 }
		 linkRgo.next=null;
		 linkLgo.next =null;
		 
		 ListNode temp = head;
		 ListNode left = QuickSort(linkL.next);	 
		 ListNode right = QuickSort(linkR.next);
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
		Solution3_3 s = new Solution3_3() ;
		printList(s.sortList(head.next));

	}

}
