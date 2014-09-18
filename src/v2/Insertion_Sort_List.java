/*    nsertion Sort List
*Sort a linked list using insertion sort.
* */
public class Insertion_Sort_List {
    public ListNode insertionSortList(ListNode head) {
        if(head != null){
            ListNode headNew = new ListNode(head.val) ;
            head = head.next;
            while(head != null){
                ListNode index = headNew;
                ListNode pre = headNew;
                while(index != null &&index.val <head.val ){
                    pre = index;
                    index = index.next;
                }
                ListNode node = head.next;
                if(pre == index){
                    //the first one
                    headNew = head;
                    head.next= index;
                    head = node;

                }
                else{
                    pre.next = head;
                    head.next = index;
                    head = node;
                }

            }
            return headNew;
        }
        else
            return head;
    }
}
