/**  Swap Nodes in Pairs
 * 2014-5-19
 * @author Alvin
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list,
only nodes itself can be changed.
 */
package com.alvin.java;
public class Swap_Nodes_in_Pairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next ==null)
            return head;
        ListNode newHead = new ListNode(-1);
        ListNode step = newHead;
        ListNode oneStep = head;
        ListNode twoStep = head.next;
        while(oneStep != null && twoStep != null){
            step.next = twoStep;
            oneStep.next = twoStep.next;
            twoStep.next = oneStep;
            step = oneStep;
            oneStep = oneStep.next;
            twoStep = (oneStep == null)? null :oneStep.next;
        }
        return  newHead.next;
    }




    public static void main(String[] args) {
        ListNode head =new  ListNode(1);
        ListNode p1 = new ListNode(2);
        ListNode p2 = new ListNode(3);
        ListNode p3 = new ListNode(4);
        head.next = p1;
        p1.next = p2;
        p2.next =p3;
        head =new Swap_Nodes_in_Pairs().swapPairs(head);
    }

}
