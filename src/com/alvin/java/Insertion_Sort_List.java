/**    Insertion Sort List
* Sort a linked list using insertion sort.
* */
package com.alvin.java;
public class Insertion_Sort_List {
    public ListNode insertionSortList(ListNode head) {
        if(head == null)
            return head;
        ListNode newHead  = head;
        head = head.next;
        newHead.next = null;
        while(head != null){
            ListNode cur = newHead;
            ListNode pre = newHead;
            while(cur != null && head.val > cur.val){
                pre = cur;
                cur = cur.next;
            }
            ListNode node = head.next;
            if(cur == pre){
                newHead = head;
                newHead.next = pre;
            }else{
                pre.next = head;
                head.next = cur;
            }
            head = node;
        }
        return newHead;
    }
}
