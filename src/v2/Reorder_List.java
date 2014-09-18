import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Alvin
 * Date: 14-9-15
 * Time: 下午5:23
 * To change this template use File | Settings | File Templates.
 */
public class Reorder_List {
    public void reorderList(ListNode head) {
        stackAndQueue(head);
    }
    public void stackAndQueue(ListNode head){
        Stack<ListNode> stack =new Stack();
        Queue<ListNode> queue =new LinkedList<ListNode>();
        ListNode node = head;
        int size = 0;
        while(node != null){
            size++;
            node= node.next;

        }
        if(size > 2){
            node = head;
            for(int i=0;i<size;i++){
                if(i<(size+1)/2){
                    queue.add(node);
                }
                else{
                    stack.push(node);
                }
                node = node.next;
            }
            ListNode index= queue.poll();
            head = index;

            for(int j=0;j <  size/2;j++){

                index.next = stack.pop();
                index = index.next;
                index.next = queue.poll();
                if(index.next !=null){
                    index = index.next;
                }
            }
            //index.next = queue.poll();
            index.next =null;
            //	index.next.next = null;
        }
    }
}
