/*
Remove Nth Node From End of List
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
*/
package com.alvin.java;
import java.util.HashMap;
import java.util.Map;

public class Remove_Nth_Node_From_End_of_List {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n == 0)
            return head;
        int length = 0;
        ListNode node = head;
        while(node != null){
            length++;
            node = node.next;
        }
        if(n == length)
            return head.next;
        int k = length - n -1;
        node = head;
        while(k > 0){
            k--;
            node = node.next;
        }
        node.next = node.next.next;
        return head;
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);

        ListNode node  = node1;
        for(int i=2;i< 10;i++){
            node.next = new ListNode(i);
            node = node.next;
        }
        node = node1;
        while(node != null){
            System.out.print("  " +node.val);
            node = node.next;
        }
        node = new Remove_Nth_Node_From_End_of_List().removeNthFromEnd(node1,9);
        System.out.println();
        while(node != null){
            System.out.print("  " +node.val);
            node = node.next;
        }
    }


}