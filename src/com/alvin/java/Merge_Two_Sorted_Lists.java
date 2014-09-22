package com.alvin.java;

/**
 * Created with IntelliJ IDEA.
 * User: Alvin
 * Date: 14-9-18
 * Time: 下午3:01
 * To change this template use File | Settings | File Templates.
 */
public class Merge_Two_Sorted_Lists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        else if(l2 == null){
            return l1;
        }

        ListNode head = new ListNode(-1);
        ListNode index = head;
        while(l1 != null && l2 != null){
            if(l1.val > l2.val){
                index.next = l2;
                l2 = l2.next;
            }else{
                index.next = l1;
                l1 = l1.next;
            }
            index = index.next;
        }
        if(l1 == null)
            index.next = l2;
        else
            index.next = l1;
        return head.next;
    }
}
