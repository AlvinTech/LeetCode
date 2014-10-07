
/*
Remove Duplicates from Sorted List 
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
*/
//class ListNode{
//    int val;
//    ListNode next;
//    ListNode (int x){val = x ; next = null;}
//}
package com.alvin.java;
public class Remove_Duplicates_from_Sorted_List_II {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode headNew = new ListNode(-1);
        headNew.next = head;
        if(head == null || head.next == null)
            return head;
        ListNode pre = headNew;
        ListNode index = pre.next;
        boolean  isDuplicates = false;
        while(index.next != null){
              if(index.val == index.next.val){
                  isDuplicates = true;
                  index.next = index.next.next;
              }else{
                  if(isDuplicates){
                      pre.next = index.next;      //delete index
                      isDuplicates = false;       //reset isDuplicates
                      index = index.next;         // move to next  but can not move pre
                  }else{
                      index = index.next;
                      pre = pre.next;
                  }

              }
        }
        if(isDuplicates){
            pre.next = null;
        }
        return headNew.next;
    }
    public static void print(ListNode root){
        ListNode step = root;
        while(step != null){
            System.out.print(  +step.val);
            step = step.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
//        ListNode node4 = new ListNode(1);
        root.next = node1;
        node1.next = node2;
        node2.next = node3;
        print(new Remove_Duplicates_from_Sorted_List_II().deleteDuplicates(root));

    }
}