package v1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 2014-9-4
 * @author Alvin
 * 
 */

public class Word_Ladder {

    public int ladderLength(String start, String end, Set<String> dict) {
    	
    	int size = dict.size();
    	
    	String[] array =  (String[]) dict.toArray(new String[size+2]);
    	array[size] = end;
    	array[size+1]= start;
    	size = size +2;
    	boolean [][] graph = new boolean[size][size];
    	init(graph,size,array);
    	int [][] dis = new int[size][size];
    	dijkstra(dis,graph,size-1); 	
        return dis[0][size-2] ;
    }
    public void dijkstra(int[][] dis,boolean[][] graph,int start){
    	for(int i=0;i<graph[0].length;i++)
			for(int j=0;j <graph[0].length;j++){
				if(i ==j)
					dis[i][j] = 0;
				else
				dis[i][j] = Integer.MAX_VALUE;
			}

    	Deque<Integer> q = new LinkedBlockingDeque<Integer>();
    	Deque<Integer> qstep = new LinkedBlockingDeque<Integer>();
    	q.add(start);
    	qstep.add(1);
    	List<Integer>list = new ArrayList<Integer>();
    	
    	while(!q.isEmpty()){

    		int index = q.pop();
    		int step = qstep.pop() ;
    		list.add(index);
    		dis[0][index] = step;
    		for(int i = 0;i< graph[0].length;i++){
    			if(graph[index][i]){
    				if(!list.contains(i)){
    					q.add(i);
    					qstep.add(step+1);
    				}
    			}
    		}
    	}
 
    }
    private void init(boolean[][] graph, int size, String[] array) {
    	boolean flag = false;
		for(int i=0;i<size;i++)
			for(int j=0;j <= i;j++){
				flag = false;
				if(stepChange(array[i],array[j]))
					flag = true;
				graph[i][j] =flag;
				graph[j][i] = flag;				
			}
		
	}
	public boolean stepChange(String word1, String word2){
    	int num = 0;
    	if(word1.length() !=  word2.length())
    		return false;
    	for(int i=0;i< word1.length();i++){
    		if(word1.charAt(i) != word2.charAt(i))
    			num++;
    	}
    	if(num == 1)
    		return true;
    	else
    		return false;
    }
	public void printGraph(boolean[][] graph){
		for(int i=0;i < graph[0].length;i++)
			System.out.println(Arrays.toString(graph[i]));
	}
	public void printArray(int[][] graph){
		for(int i=0;i < graph[0].length;i++)
			System.out.println(Arrays.toString(graph[i]));
	}
	public static void main(String[] args) {
		Set<String> dict =new HashSet<String>();
		dict.add("lest");
		dict.add("leet");
		dict.add("lose");
		dict.add("code");
		dict.add("lode");
		dict.add("robe");
		dict.add("lost");
		System.out.println(new Word_Ladder().ladderLength("leet","code",dict));
	}

}
