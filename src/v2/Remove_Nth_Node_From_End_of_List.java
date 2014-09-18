/*
Remove Nth Node From End of List
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
*/
import java.util.Map;
import java.util.HashMap;
public class Remove_Nth_Node_From_End_of_List{
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer,ListNode> map = new HashMap<Integer,ListNode>();
        int i =1;
        ListNode step = head;
        while(step != null){
            map.put(i,step);
            i++;
            step = step.next;
        }
        if(i-n == 1)//delete head
            return map.get(2);
        else{
            step = map.get(i-n-1);
            if(step.next != null)
                step.next = step.next.next;
            else
                step.next = null;
        }
        return map.get(1);
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);

        ListNode node  = node1;
        for(int i=2;i< 10;i++){
            node.next = new ListNode(i);
            node = node.next;
        }
        node = node1;
        while(node != null){
            System.out.print("  " +node.val);
            node = node.next;
        }
        node = new Remove_Nth_Node_From_End_of_List().removeNthFromEnd(node1,9);
        System.out.println();
        while(node != null){
            System.out.print("  " +node.val);
            node = node.next;
        }
    }


}