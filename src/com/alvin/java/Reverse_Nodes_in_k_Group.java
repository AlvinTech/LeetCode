/**
 * 2014-7-19
 * @author Alvin
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
 */
package com.alvin.java;
import java.util.Stack;
public class Reverse_Nodes_in_k_Group {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = new ListNode(-1);
        ListNode node = newHead;
        node.next = head;        // 防止 {1} ，2 这种情况
        Stack<ListNode> s = new Stack<ListNode>();
        while(head != null){
            s.push(head);
            head = head.next;
            if(s.size() == k){
                while(!s.empty()){
                    node.next = s.pop();
                    node = node.next;
                }
                node.next = head;
            }
        }
        return newHead.next;
    }


    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        //n2.next = n3;
        //n3.next = n4;
        //	n4.next = n5;
        //	n5.next = n6;

       new Reverse_Nodes_in_k_Group().reverseKGroup(n1, 2);

    }

}
