package v1;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LRUCache2Map {
	
	private int capacity;
	private ListNode head;
	public Map<Integer ,Integer> map=new HashMap();
	private int lastKey;
	
  public class ListNode{
	  public int key;
	  ListNode next;
	
	  ListNode(int  key) {
          this.key = key;
          next = null;
    }
	  
  }
	 public LRUCache2Map(int capacity) {
	        this.capacity = capacity;
	        head = null;
	       
	    }
	    
	    public int get(int key) {
	    	if( map.get(key )!=null){
	    		reset(key);
	    		return map.get(key );
	    	}
	    	
	    	return -1;
	        
	    }
	    public void reset(int key){
	    	 ListNode list = head;
	    	 ListNode pre = head;
	    	 while(list !=null){
	    		  lastKey = list.key;
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
	    	 
	    }
	    public void set(int key, int value) {
	    	if(map.get(key) != null){
	    		map.put(key, value);
	    		reset(key);
	    	}
	    	else{
	    		if(map.size() <capacity){
	    			map.put(key, value);
	    			ListNode node = new ListNode(key);
	    			System.out.println(value);
	    			node.next = head;
	    			head = node;
	    		}else
	    			reset(lastKey);
	    			head.key = key;
	    			map.put(key, value);
	    			map.remove(lastKey);
	    	}
				
	    }
	   
	public static void main(String[] args) {
		
		LRUCache2Map l= new LRUCache2Map(3);
		System.out.println(l.get(2));
		l.set(1, 1);
		l.set(2, 2);
		l.set(3, 3);
		l.set(4, 4);
		System.out.println(l.get(1));
	
 
	}

}
