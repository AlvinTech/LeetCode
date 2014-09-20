package v1;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2014-6-5
 * @author Alvin
 * 
 */

/**
 * 思路： 先拷贝链表next域；
 *       再次循环拷贝random域
 * 结果：      超时
 * 
 *       
 *改进：  用空间换时间，用map来实现和保存。
 *       
 * @author Alvin
 *
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
	public static void main(String[] args) {
		RandomListNode head = new RandomListNode(0);
		RandomListNode p1 = new RandomListNode(1);
		RandomListNode p2 = new RandomListNode(2);
		RandomListNode p3 = new RandomListNode(3);
		RandomListNode p4 = new RandomListNode(4);
		head.next = p1;
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		
		head.random = p4;
		p2.random = p3;
		print(new Copy_List_with_Random_Pointer().copyRandomList(head));
		System.out.println(11647.0/51709);

	}
	
	public static void print(RandomListNode head){
		while(head != null){
			if(head.random != null)
				System.out.print(head.random.label +"   ");
			else
				System.out.print(" nil ");
			head = head.next;
		}
	}

}
