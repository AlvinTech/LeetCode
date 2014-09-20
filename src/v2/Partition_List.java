/**   Partition List
 * 2014-7-22
 * @author Alvin
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
 */

public class Partition_List {
    public ListNode partition(ListNode head, int x) {
        ListNode small = null;
        ListNode smallStep = null;
        ListNode bigStep = null;
        ListNode big = null;
        while(head != null){
            if(head.val < x){
                if(smallStep == null){
                    small = head;
                    smallStep = small;
                }else{
                    smallStep.next = head;
                    smallStep  = smallStep.next;
                }
            }else{
                if(bigStep == null){
                    big = head;
                    bigStep = big;
                }else{
                    bigStep.next = head;
                    bigStep  = bigStep.next;
                }
            }

            head = head.next;
        }
        if(big != null)
            bigStep.next = null;
        if(small == null){

            return big;
        }else{
            smallStep.next = big;
            return small;
        }
    }
    public static void main(String[] args) {
        // 1->4->3->2->5->2
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;


        new Partition_List().partition(n1, 3);
    }

}
