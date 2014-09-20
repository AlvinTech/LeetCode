

/**
 * Created with IntelliJ IDEA.
 * User: Alvin
 * Date: 14-9-18
 You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 */
import java.util.Stack;
public class Add_Two_Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        long result  = convert(l1) + convert(l2);

        // result = 10000000000l;

        Stack<Integer> s = new Stack<Integer>();
        do{
            s.push((int) (result%10));
            result /= 10;
        }while(result != 0);


        ListNode head = null;
        while( !s.isEmpty()){
            ListNode temp = new ListNode((int) s.pop());
            temp.next = head;
            head  = temp;
        }
        return head;
    }

    public long convert(ListNode list){
        long result=0;
        int index =0;
        while(list != null){
            result = (long) (list.val * Math.pow(10, index)+ result);
            index ++;
            list = list.next;
        }
        return result;

    }

}
