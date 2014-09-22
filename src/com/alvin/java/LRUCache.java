/*      LRU Cache
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
* */
package com.alvin.java;
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
}
