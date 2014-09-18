/** Reverse Linked List II
 Reverse a linked list from position m to n. Do it in-place and in one-pass.

 For example:
 Given 1->2->3->4->5->NULL, m = 2 and n = 4,

 return 1->4->3->2->5->NULL.

 Note:
 Given m, n satisfy the following condition:
 1 ≤ m ≤ n ≤ length of list.
 * */
import java.util.Stack;
public class Reverse_Linked_List_II {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n)
            return head;
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode headNew = null;
        ListNode step = null;
        ListNode index = head;
        ListNode left = null;

        for(int i=1;index != null;i++){
            if(i<= n && i>=m){
                stack.add(index);
            }else if(i<m){
                if(headNew == null){
                    headNew = index;
                    step = headNew;
                }
                else{
                    step.next = index;
                    step = step.next;
                }
            }
            index = index.next;
        }
        left = stack.peek().next;
        if(headNew == null){
            headNew = stack.peek();
            step = headNew;
        }
        while(!stack.empty()){
            step.next = stack.pop();
            step = step.next;
        }
        if(step != null)
            step.next = left;
        return headNew;

    }
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        new Reverse_Linked_List_II().reverseBetween(n1, 2, 4);
    }

}
