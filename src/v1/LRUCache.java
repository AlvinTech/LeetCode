package v1;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	class Node{
		int key;
		int value;
		Node pre;
		Node next;
		public  Node(int key,int value, Node p,Node n){this.key = key; this.value = value; pre = p; next= n;}
	}
	class Dlist{
		Node first;
		Node last;
		int size;
		int count;
		public Dlist(int c){
			size = c;
		}
	}
	Map<Integer,Node> map ;
	Dlist list ;
	public LRUCache(int capacity){
		list = new Dlist(capacity);
		map = new HashMap<Integer,Node>();
	}
	public int get(int key){
		if(map.containsKey(key)){
			Node n = map.get(key);
			if(n.pre != null){
				if(list.last == n)
					list.last = n.pre;
				n.pre.next = n.next;
				if(n.next != null)
					n.next.pre = n.pre;
				n.pre= null;
				list.first.pre = n;
				n.next = list.first;
				list.first = n;
			}
			return n.value;
		}
		else{
			return -1;
		}
	}
	public void set(int key,int value){
		Node n ;
		if(!map.containsKey(key)){
			n = new Node(key,value,null,null);
			if(list.size != list.count){
				n.next = list.first;
				if(list.count != 0){
					list.first.pre = n;
				}else{
					list.last = n;
				}
				list.first = n;
				list.count++;
			}else{
				if(list.count != 1){
					map.remove(list.last.key);
					list.last.pre.next = null;
					list.last =list.last.pre;
					list.first.pre = n;
					n.next = list.first;
					list.first = n;
				}else{
					map.remove(list.first.key);
					list.first = n;
					list.last = n;
				}
			}
			map.put(key, n);
		}else{
			n = map.get(key);
			n.value = value;
			if(n.pre != null){
				if(list.last == n){
					list.last = n.pre;
				}
				n.pre.next = n.next;
				if(n.next !=  null)
					n.next.pre = n.pre;
				n.pre = null;
				n.next = list.first;
				list.first.pre = n;
				list.first = n;
			}
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
