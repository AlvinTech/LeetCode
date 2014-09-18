/*
Linked List Cycle II 
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Follow up:
Can you solve it without using extra space?


假设 相遇时 走了k步。
-> 2k - k = nr  : r 表示环的长度
-> k = nr       :假设从表头开始到环的起始点的距离为s
-> k + s = nr +s 
根据上面的公式可以看出  如果冲k点出发走s步，他们必定相交在 环的起点处（s+nr）。
*/

public class Linked_List_Cycle_II{
    public ListNode detectCycle(ListNode head) {
        ListNode oneStep = head;
        ListNode twoStep = head;

        while(oneStep != null && twoStep != null &&  twoStep.next != null){
            oneStep = oneStep.next;
            twoStep = twoStep.next.next;
            if(oneStep ==twoStep)
                break;
        }

        if(oneStep != null || twoStep != null || twoStep.next == null)
            return null;
        oneStep = head;
        while(oneStep != twoStep){
            twoStep = twoStep.next;
            oneStep= oneStep.next;
        }
        return oneStep;
    }
    public static void main(String[] args) {
        System.out.println("Hello world");
    }
} 