package S1_10;

import java.util.Date;
import java.util.Random;

public class LRUCache {
	
	private int capacity;
	private ListNode head;
	
  public class ListNode{
	  public int value;
	  public int key;
	  public int count;
	  ListNode next;
	  ListNode(int  key,int value) {
          this.value = value;
          this.count = 0;
          this.key = key;
          next = null;
    }
	  
  }
	 public LRUCache(int capacity) {
	        this.capacity = capacity;
	        ListNode list = new ListNode(-1,-1);
	        head = list;
	        for(int i=0;i<capacity-1;i++){
	        	list.next = new ListNode(-1,-1);
	        	list = list.next;
	        }
	       
	    }
	    
	    public int get(int key) {
	    	 ListNode list = head;
	    	 int result = -1;
			for(int i=0;i<capacity;i++){
				if(list.key == key){
					 ListNode node = list;
					result = list.value;
					list.count ++;
				}
				else
					list = list.next;
			}
			
			
	    	return result;
	        
	    }
	    public void reset(int key){
	    	 ListNode list = head;
	    	 ListNode pre = head;
	    	 while(list !=null){
	    		 if(list.key != key){
	    			 pre = list;
	    			 list = list.next;
	    		 }
	    		 else{
	    			 if(pre != list){
	    				 pre.next = list.next;
	    				 list.next= head;
	    				 head = list;
	    			 }
	    		 }
	    	 }
	    	  list = head;
	    		for(int i=0;i<capacity-1;i++){
	    			list=list.next;
				}
	    		list=null;
	    }
	    public void set(int key, int value) {
	    	 ListNode list = head;
	    	 int i;
			 for( i=0;i<capacity;i++){
				if(list.key == key)
						list.value = value;
				else
					list = list.next;
			 }
			 if(i== capacity){
				 list = null;
				 list = head;
				 ListNode node = new ListNode(key,value);
				 node.next =list;
				 head = node;
			 }
			
				
	    }
	public static void main(String[] args) {
		
		Date d = new Date();
		LRUCache l = new LRUCache(1);
		l.set(2, 1);
		System.out.println(l.get(1));
	/*	System.out.println(l.get(1));
		
		System.out.println(d.getTime());
		Random r =new Random();
		for(int i=0;i<1-24;i++){
			int t = r.nextInt(2048);
			l.set(t, t);
		}
		Date d1 = new Date();
		System.out.println(d1.getTime()-d.getTime());
		int t = r.nextInt(2048);
		System.out.println(t);
		System.out.println(t);*/
	//	System.out.println(l.get(1));
 
	}

}
