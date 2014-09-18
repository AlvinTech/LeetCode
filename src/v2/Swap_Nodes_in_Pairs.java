/**  Swap Nodes in Pairs
 * 2014-5-19
 * @author Alvin
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list,
only nodes itself can be changed.
 */

public class Swap_Nodes_in_Pairs {

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next ==null){
            return head;
        }else{
            ListNode p1 = head;
            ListNode index = null;
            ListNode p2 = p1.next;
            head = p2;
            while(p1 != null && p2 != null){
                //swap p1 p1
                if(index == null){
                    index = p2;
                }else
                    index.next = p2;
                p1.next = p2.next;
                index = p1;
                p2.next = p1;

                p1 = p1.next;
                if(p1 != null)
                    p2 = p1.next;
            }
            return head;
        }
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
