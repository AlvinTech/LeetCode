/**
 * 2014-5-19
 * @author Alvin
 * 
 */
package v1;

public class Print {

	public static void print(ListNode listNode){
		while(listNode != null){
			System.out.println(listNode.val);
			listNode = listNode.next;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
