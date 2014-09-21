/**   Copy List with Random Pointer
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.


* */

package com.alvin.java;
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
        while(head != null){
            headNew.random = (RandomListNode) map.get(head.random);
            head = head.next;
            headNew = headNew.next;
        }
    }
    private RandomListNode copyNext (RandomListNode head) {
        RandomListNode headNew  = new RandomListNode(head.label);
        RandomListNode node1 = head.next;
        RandomListNode node2 = headNew;
        map.put(head, headNew);
        RandomListNode node  = null;
        while(node1 != null){
            node = new RandomListNode(node1.label);
            map.put(node1, node);
            node2.next = node;
            node2 = node2.next;
            node1 = node1.next;
        }
        return headNew;
    }
}
