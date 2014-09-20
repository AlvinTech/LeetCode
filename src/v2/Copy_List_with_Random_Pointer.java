/*   Copy List with Random Pointer
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.


* */


import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Alvin
 * Date: 14-9-15
 * Time: 下午5:27
 * To change this template use File | Settings | File Templates.
 */
class RandomListNode {
         int label;
         RandomListNode next, random;
         RandomListNode(int x) { this.label = x; }
};
public class Copy_List_with_Random_Pointer {
    public Map<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
            return null;
        else{
            RandomListNode headNew = copyNext(head);;
            copyRandom(headNew,head);
            return headNew;
        }

    }
    private void copyRandom(RandomListNode headNew, RandomListNode head) {
        //System.out.println(Arrays.toString(map.keySet().toArray()));
        while(head != null){
            //		System.out.println(head.random);

            headNew.random = (RandomListNode) map.get(head.random);
            head = head.next;
            headNew = headNew.next;
        }
    }
    private void copyRandom1(RandomListNode headNew, RandomListNode head) {
        RandomListNode first = head;
        RandomListNode firstNew = headNew;
        RandomListNode step = head;
        RandomListNode step2 = head;
        RandomListNode index = headNew;
        RandomListNode index2 = headNew;
        while(step != null){
            if(step.random == null){
                index.random =null;
            }else{
                step2 = first;
                index2 = firstNew;
                while(step.random != step2){
                    step2 = step2.next;
                    index2 = index2.next;
                }
                index.random = index2;
            }
            step = step.next;
            index = index.next;
        }
    }
    private RandomListNode copyNext (RandomListNode head) {
        RandomListNode headNew  = new RandomListNode(head.label);
        RandomListNode step = head.next;
        RandomListNode index =headNew;
        map.put(head, index);
        RandomListNode node  = null;
        while(step != null){
            node = new RandomListNode(step.label);
            map.put(step, node);
            index.next = node;
            index = index.next;
            step = step.next;
        }
        return headNew;
    }
}
