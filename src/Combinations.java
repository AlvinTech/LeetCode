/**
 * 2014-4-28
 * @author Alvin
 * 
 */
import java.util.*;
public class Combinations {

	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		
	        return getCombine(1,n,k);
	}
	
	// 每次迭代生成一组数据 一条
	public ArrayList<ArrayList<Integer>> getCombine(int sta,int n,int k){
	     ArrayList<ArrayList<Integer>>  result = new  ArrayList<ArrayList<Integer>> ();
		
		if(k > 0){
			for(int i =sta; i<= n-k+1;i++){
				ArrayList<ArrayList<Integer>> temp = getCombine(i+1,n,k-1);
				if(temp.size() ==0){
					ArrayList<Integer> t = new ArrayList<Integer>();
					t.add(i);
					result.add(t);
				}
				else{
					for(int j =0; j< temp.size();j++){
						temp.get(j).add(0, i);
						result.add(temp.get(j));
					}
				}
				
			}
		}
		
		return result;	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ArrayList<ArrayList<Integer>>  result =new Combinations().combine(4, 3);
		int i=0;
		System.out.println(i);
	}


}
