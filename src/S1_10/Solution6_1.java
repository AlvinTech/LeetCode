package S1_10;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

import util.Time;

public class Solution6_1 {

	public void reorderList(ListNode head) {
		// reorder(head);
		//reorderNew(head);
		stackAndQueue(head);
	}

	public void reorder(ListNode head) {
		ListNode index = head;
		ListNode headNew = head;

		while (head != null) {
			ListNode pre = head;
			ListNode node = head;
			while (node.next != null) {
				pre = node;
				node = node.next;

			}
			if (pre != node) {
				pre.next = null;

				node.next = index.next;
				index.next = node;
				head = node.next;
				index = head;
			} else
				head = null;

		}
		head = headNew;
	}

	public void reorderNew(ListNode head) {
		int size = 0;
		ListNode node = head;
		while (head != null) {
			size++;
			head = head.next;
		}
		if (size > 2) {
			int i, j;
			int halfsize = size / 2;
			ListNode half = null;
			head = node;
			ListNode left = head;
			ListNode right = head;

			for (i = 0; i < halfsize - 1; i++) {
				node = node.next;
			}
			if (size % 2 == 1) {
				half = node.next;

				right = half.next;
				half.next = null;
			} else
				right = node.next;
			node.next = null;

			node = head;
			ListNode end = head;
			for (i = 0; i < halfsize; i++) {
				node = head;
				for (j = 0; j < halfsize - 1 - i; j++) {
					node = node.next;
				}
				if (i == 0) {
					end = right;
				}
				ListNode temp = right.next;
				right.next = node.next;
				node.next = right;

				right = temp;

			}
			end.next = half;
		}

	}

	public void stackAndQueue(ListNode head){
		Stack<ListNode> stack =new Stack(); 
		Queue<ListNode> queue =new LinkedList<ListNode>(); 
		ListNode node = head;
		int size = 0;
		while(node != null){
			size++;
			node= node.next;
			
		}
		if(size > 2){
			node = head;
			for(int i=0;i<size;i++){
				if(i<(size+1)/2){
					queue.add(node);
				}
				else{
					stack.push(node);
				}
				node = node.next;
			}
			ListNode index= queue.poll();
			head = index;
			
			for(int j=0;j <  size/2;j++){
				
				index.next = stack.pop();
				index = index.next;
				index.next = queue.poll();
				if(index.next !=null){
					index = index.next;
				}
			}
			//index.next = queue.poll();
			index.next =null;
		//	index.next.next = null;
		}
		
	
		
	}
	public static void printList(ListNode list) {
		while (list != null) {
			System.out.print(list.val + " ");
			list = list.next;
		}
	}

	public static void main(String[] args) {
		Time t = new Time();
		t.start();
		ListNode head = null;
		ListNode temp = new ListNode(0);
		head = temp;
		Random r = new Random();
		for (int i = 1; i < 4; i++) {
			ListNode node = new ListNode(i);
			temp.next = node;
			temp = node;
		}
		Solution6_1 s = new Solution6_1();
		// printList(head.next);
		s.reorderList(head.next);
		printList(head.next);
		System.out.println();
		System.out.println(t.end());
	}

}
