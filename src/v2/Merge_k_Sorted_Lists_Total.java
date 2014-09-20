/*
Merge k Sorted Lists
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
*/
import java.util.ArrayList;
import java.util.List;


public class Merge_k_Sorted_Lists_Total {
    public ListNode mergeKLists(List<ListNode> lists) {
        if(lists == null || lists.size() == 0)
            return null;
        return mergeKLists(lists.subList(0, lists.size()/2),lists.subList(lists.size()/2, lists.size()));
    }
    public ListNode mergeKLists(List<ListNode> lists1,List<ListNode> lists2) {
        int size1 = lists1.size();
        int size2 = lists2.size();
        if(size1 == 0 && size2 == 0)
            return null;
        if(size1 == 1 && size2 == 0)
            return lists1.get(0);
        if(size1 == 0 && size2 == 1)
            return lists2.get(0);
        if(size1 == 1 && size2 == 1)
            return merge2Lists(lists2.get(0),lists1.get(0));
        else
            return merge2Lists(mergeKLists(lists1.subList(0, size1/2),lists1.subList(size1/2, size1)),mergeKLists(lists2.subList(0, size2/2),lists2.subList(size2/2, size2)));
    }
    public static ListNode merge2Lists(ListNode node1,ListNode node2){
        ListNode head;
        if(node1 == null)
            return node2;
        if(node2 == null)
            return node1;
        if(node1.val < node2.val){
            head = node1;
            node1 = node1.next;
        }else{
            head = node2;
            node2 = node2.next;
        }
        ListNode step = head;
        while(node1!= null && node2 != null){
            if(node1.val < node2.val){
                step.next = node1;
                node1 = node1.next;
            }else{
                step.next = node2;
                node2 = node2.next;
            }
            step = step.next;
        }
        if(node1 == null)
            step.next = node2;
        else
            step.next = node1;
        return head;
    }
    public static void print(ListNode node){
        while(node != null){
            System.out.print(node.val +" ");
            node = node.next;
        }
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(-1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        //	node1.next = node2;
        //	node2.next = node3;
        //	node4.next = node5;
        List<ListNode>list = new ArrayList<ListNode>();;
        list.add(node2);
        list.add(null);
        list.add(node1);
        //	print(merge2Lists(node1, node4));
        print(new Merge_k_Sorted_Lists_Total().mergeKLists(list));

    }

}
