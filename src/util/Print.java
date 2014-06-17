/**
 * 2014-5-19
 * @author Alvin
 * 
 */
package util;

public class Print {

	public static void print(ListNode head){
		while(head != null){
			System.out.println(head.val);
			head = head.next;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
