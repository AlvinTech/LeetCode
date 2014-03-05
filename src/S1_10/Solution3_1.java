package S1_10;

public class Solution3_1 {

	 public ListNode sortList(ListNode head) {
		  
		 int[] list = ListToArray(head);
		  return  ArrayToList(QuickSort(list,0,list.length));
	        
	    }
	 
	 /**
	  * 思路：list 选一个关键值，默认第一个
	  * @param list
	  * @return
	  */
	 
	  private int[] QuickSort(int[] list,int sta,int end) {
		  if(end-sta <2)
		  	return list;
		  int i,j,key;
		  int index =sta;
		  i=sta;
		  j= end-1;
		  key = list[i];
		  while(i<j){
			  while(key<list[j] && i<j){
				  j--;
			  }
			  if(j>i){//交换
				  int temp = list[j];
				  list[j] = list[i];
				  list[i] =temp;
				  index = j;
				  i++;
			  }
			  
			  while(key >list[i]){
				  i++;
			  }
			  
			  if(i<j){
				  int temp = list[j];
				  list[j] = list[i];
				  list[i] =temp;
				  index = i;
				  j--;
			  }
			  
		  }
		  int right = index +1;
		  QuickSort(list,sta,index);
		  QuickSort(list,right,end);
		  
		return list;
	}
	  
	  
	  
	public int[] ListToArray(ListNode head){
		  int size = 0;
		  ListNode temp = head;
		  while(head!= null){
			  size++;
			  head =head.next;
		  }
		  int[] list = new int[size];
		  int i =0; 
		  while(temp!=null){
			  list[i] = temp.val;
			  i++;
			  temp = temp.next;
		  }
		  return list;
	  }
	  public ListNode ArrayToList(int[] list){
		  ListNode head =null;
		  ListNode temp = new ListNode(0);
		  head= temp;
		  for(int i=0;i<list.length;i++){
			  ListNode node =new ListNode(list[i]);	 
			  temp.next = node;
			  temp = node;
		  }
		  return head.next;
	  }
	  
	  public static void printList(int[] list){
		  for(int i=0;i<list.length;i++)
			  System.out.print(list[i]+" ");
		  System.out.println();
		  
	  }
	  public static  void printList(ListNode list){
		  while(list!= null){
			  System.out.print(list.val+" ");
			  list = list.next;
		  }
	  }
	
	public static void main(String[] args) {
		ListNode head = null;
		ListNode temp = new ListNode(0);
		head = temp;
		for(int i=5;i>0;i--){
			ListNode node = new ListNode(i);
			temp.next= node;
			temp = node;
		}
		Solution3_1 s = new Solution3_1() ;
		printList(s.sortList(head.next));
	}

}
