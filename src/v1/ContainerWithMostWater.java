/***
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 *  n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 *  Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * 给定n个非负数，每一个数代表一个坐标点。
 * n条以(i, ai) 和 (i, 0)为端点的垂直的直线；
 * 选择2条直线，和x坐标轴形成一个容器，使得这个容器能装得水最多。
 * 
 * 
 */
package v1;

import java.util.Random;

import util.Time;

public class ContainerWithMostWater {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	//	int[] height={1,2,3,4,5,6,7,8,9};
		int length = 4096;
		int [] height =  new int[length];
		Random r = new Random();
		for(int  i =0; i< length ;i++){
			height[i] = r.nextInt(10000);
			height[i] = 1;
			//System.out.println(height[i]);
		}
		Time t = new Time();
		t.start();
		System.out.println("mostWater:"+new ContainerWithMostWater().maxArea(height));
		System.out.println("高端玩家算法耗时 :"+t.end()+"ms");
		
		t.start();
		System.out.println("mostWater:"+new ContainerWithMostWater().maxArea1(height));
		System.out.println("我的算法耗时 :"+t.end()+"ms");
	}
	public int maxArea1(int[] height){
		
		int mostWater = 0;
		int length = height.length;
		for(int i = 0; i < length ;i++)
			for(int j= i; j < length;j++){
				int width = j - i;
				//int h = height[i]>height[j] ?height[j] :height[i]; 
				int h = Math.min(height[j], height[i]);
				if(width * h > mostWater){
					mostWater = width * h;
					//System.out.println("width:"+width +" H: "+h+" I: "+i+" J:"+j);
				}
			}
		return mostWater;
		
	}
	
	public int maxArea(int[] height) {
			int mostWater = 0;
			
			int length = height.length;
			int left  = 0;
			int right = length -1;
			while(left < right){
				int h = (height[left] < height[right])? height[left]: height[right];
				int var = (right - left) * h;
				mostWater = mostWater > var ? mostWater: var ;
				if(height[left] < height[right]){
					left ++;
				}
				else
					right--;
			}
			
		
		
			return mostWater;
	    }
	
	
	
	

}
