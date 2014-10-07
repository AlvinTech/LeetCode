/**  Remove Duplicates from Sorted List
 * 2014-4-11
 * @author Alvin
 *
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
 */
package com.alvin.java;
public class Remove_Duplicates_from_Sorted_List {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode root = head;
        while(root.next != null){
            if(root.val == root.next.val)
                root.next = root.next.next;
            else
                root = root.next;
        }
        return head;
    }

    public static  void printList(ListNode list){
        while(list!= null){
            System.out.print(list.val+" ");
            list = list.next;
        }
    }
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(2);
        root.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        printList(new Remove_Duplicates_from_Sorted_List().deleteDuplicates(root));

    }

}
