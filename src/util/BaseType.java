package util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

public class BaseType {
	
	private static Random random = new Random();

	/**
	 * @param args
	 */
	/***
	 * 一维数组初始化
	 * @return
	 */
	public static int[] getArray(){
		int[] array;
		int length = 5;
		array = new int[length];
		Random random = new Random();
		for(int i = 0; i< length ; i++){
			array[i] = random.nextInt(100);
		}
		
		return array;
	}
	
	
	/***
	 * 二维数组初始化
	 * @return
	 */
	public  static int[][] getArray2(){
		int[][] array ;
		int row = 5;
		int col = 6;
		array = new int[row][];
		for(int i=0; i< row;i++){
			array[i] = new int[col];
		}
		
		Random random = new Random();
		for(int i=0; i<row ;i++)
			for(int j =0; j<col ;j++){
				array[i][j] = random.nextInt(100);
			}
		return array;
	}
	
	/***
	 * 
	 * 栈 初始化
	 * @param array
	 */
	public static Stack getStack(){
		 Stack  stack;
		 stack   = new Stack<Integer>();
		 int length = 5;
		 Random random = new Random();
		 for(int i =0 ;i<length ;i++){
			 stack.push(random.nextInt(100));
		 }
		 return stack;
	}
	
	/***
	 *  map  的初始哈和遍历。
	 * @return
	 */
	public static Map getMap(){
		Map<Integer,Integer> map ;
		map = new HashMap<Integer,Integer>();
		Random random  = new Random();
		for(int i =0; i< 5;i++){
			map.put(i, random.nextInt(1000));
		}
		return map;
	}
	
	/****
	 * 建议使用 offer 和poll 方法， 避免抛出异常
	 * add        增加一个元索                     如果队列已满，则抛出一个IIIegaISlabEepeplian异常
*remove   移除并返回队列头部的元素    如果队列为空，则抛出一个NoSuchElementException异常
element  返回队列头部的元素             如果队列为空，则抛出一个NoSuchElementException异常
offer       添加一个元素并返回true       如果队列已满，则返回false
poll         移除并返问队列头部的元素    如果队列为空，则返回null
peek       返回队列头部的元素             如果队列为空，则返回null
put         添加一个元素                      如果队列满，则阻塞
take        移除并返回队列头部的元素     如果队列为空，则阻塞
	 * @return
	 */
	public static Queue getQueue(){
		Queue<Integer> queue  = new LinkedList<Integer>();
		int length = 10;
		for(int i = 0;i < length;i++){
			queue.offer(random.nextInt(1000));
		}
		return queue;
	}
	
	public static Set getSet(){
		Set<Integer> set ;
		set  = new HashSet();
		int length = 100;
		System.out.println("----------Set初始化----------");
		for(int i = 0; i< length;i++){
			int var  = random.nextInt(50);
			set.add(var);
			System.out.print(" "+var);
		}
		System.out.println("----------Set初始化介绍----------");
		return set;
	}
	
	public static void printSet(Set set){
		System.out.println("----------Set输出----------");
		Iterator it  = set.iterator();
		while(it.hasNext()){
			System.out.print(" "+it.next());
		}

	}
	public static void printQueue(Queue queue){
		System.out.println("------------Queue输出如下：-----------------");
		while(!queue.isEmpty()){
			System.out.print(" "+queue.poll());
		}
		System.out.println();
	}
	public static void printKeyMap(Map<Integer,Integer> map){
		System.out.println("map_key_ 遍历Key值：iterator");
		Iterator<Integer> it  = map.keySet().iterator();
		while(it.hasNext()){
			System.out.print(" "+ it.next());
		}
		//for
		System.out.println();
		System.out.println("map_key_ 遍历Key值： for");
		for (Object key : map.keySet()) {
			System.out.print(" "+ key);
		}
	
		System.out.println();
	}
	public static void printValueMap(Map map){
		System.out.println("Map_Value_输出如下：--------------------------");
		Iterator<Integer> it = map.keySet().iterator();
		while(it.hasNext())
			System.out.print(" "+map.get(it.next()));
		
		System.out.println();
		
	}
	public static void printMap(Map<Integer,Integer>  map){
		System.out.println("-----------------Map输出如下：--------------------------");
		System.out.println("Iterator");
		Iterator<Entry<Integer, Integer>> it   = map.entrySet().iterator();
		Entry entry1;
		while(it.hasNext()){
			entry1  =  it.next();
			System.out.println("key:" +entry1.getKey()+"  value:"+ entry1.getValue());
		}
		
		System.out.println("for");
		for(Entry<Integer,Integer> entry : map.entrySet()){
			System.out.println("key:"+entry.getKey()+"   value:"+entry.getValue());
		}

	}
	
	public static void printStack(Stack stack){
		System.out.println("-----------------堆栈输出如下：--------------------------");
		while(!stack.isEmpty()){
			System.out.print(" "+stack.pop());
		}
		System.out.println();
	}
	public static void printArray(int[] array){
		System.out.println("-----------------一维数组输出如下：--------------------------");
		int length = array.length;
		for(int i =0; i<length; i++){
			System.out.print(" "+array[i]);
		}
		System.out.println();
		
	}
	
	
	public static void printArray(int[][] array){
		System.out.println("-----------------二维数组输出如下：--------------------------");
		int row = array.length;
		for(int i =0;i< row ;i++){
			int col = array[i].length;
			for(int j =0; j< col;j++){
				System.out.print(" " + array[i][j]);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printArray(getArray());
		printArray(getArray2());
		printStack(getStack());
		Map map = getMap();
		printMap(map);
		printKeyMap(map);
		printValueMap(map);
		printQueue(getQueue());
		printSet(getSet());
	}

}
