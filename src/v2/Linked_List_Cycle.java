/**
 * Created with IntelliJ IDEA.
 * User: Alvin
 * Date: 14-9-15
 * Time: 下午5:25
 * To change this template use File | Settings | File Templates.
 */
public class Linked_List_Cycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while( slow != null &&fast!= null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }

        return false;
    }
}
