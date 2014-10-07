/* Sort List
* Sort a linked list in O(n log n) time using constant space complexity.
* */

//Definition for singly-linked list.
//  class ListNode {
//      int val;
//      ListNode next;
//      ListNode(int x) {
//          val = x;
//          next = null;
//      }
//  }
package com.alvin.java;
public class Sort_List {

    public ListNode sortList(ListNode head) {
        int length = 0;
        ListNode node = head;
        while(node != null){
            length++;
            node = node.next;
        }
        if(length > 1){
            ListNode left = head;
            ListNode right;
            node = head;
            for (int i = 0 ; i< length /2 -1; i++){
                node = node.next;
            }
            right = node.next;
            node.next  = null;
            left = sortList(left);
            right = sortList(right);
            head = merge(left,right);
            return head;
        }
        return head;
    }
    public ListNode merge(ListNode left,ListNode right){
        ListNode head = new ListNode(-1);
        ListNode node = head;
        while(left != null && right != null){
            if(left.val < right.val){
                node.next = left;
                left = left.next;
            }
            else{
                node.next = right;
                right = right.next;
            }
            node = node.next;
        }
        if(left == null)
            node.next = right;
        else
            node.next = left;
        return head.next;
    }

    public static void printList(ListNode list) {
        while (list != null) {
            System.out.print(list.val + " ");
            list = list.next;
        }
    }

    public static void main(String[] args) {
        Sort_List s = new Sort_List();
        // int[] list= {5,4,3,2,1};
        // s.Merge(list);

        ListNode head = null;
        ListNode temp = new ListNode(0);
        head = temp;
        for (int i = 5; i > 0; i--) {
            ListNode node = new ListNode(i);
            temp.next = node;
            temp = node;
        }
//        s.listMergeSort(head.next);
         printList(s.sortList(head.next));
    }
}
