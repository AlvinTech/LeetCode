/**   Given a singly linked list
 *L: L0→L1→…→Ln-1→Ln,
 reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 You must do this in-place without altering the nodes' values.
 For example,
 Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * Created with IntelliJ IDEA.
 * User: Alvin
 * Date: 14-9-15
 * Time: 下午5:23
 */
package com.alvin.java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class Reorder_List {
    public void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        Queue<ListNode> queue = new LinkedList<ListNode>();
        ListNode node = head;
        int size = 0;
        while(node != null){
            size++;
            stack.add(node);
            queue.add(node);
            node = node.next;
        }
        int i =0 ;
        node = new ListNode(-1);
        while(i < size/2){
            node.next = queue.poll();
            node = node.next;
            node.next = stack.pop();
            node = node.next;
        }
        if(size % 2 == 1){
            node.next =queue.poll();
            node = node.next;
        }
        node.next = null;
    }

}
