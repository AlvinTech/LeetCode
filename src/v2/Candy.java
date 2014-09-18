/*
Candy
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
public class Candy{
    public int candy(int[] ratings) {
        List<Integer> list = new ArrayList<Integer>();
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0; i< ratings.length;i++){
            list.add(ratings[i]);
        }
        Collections.sort(list);
        int sum =0;
        int step = 1;
        for(int i =1;i<list.size();i++){
            sum += step;
            if(list.get(i)!= list.get(i-1)){
                step++;
            }
        }
        sum += step;
        return sum;
    }
    public static void main(String[] args) {
        int[] ratings ={2,2};
        System.out.println(new Candy().candy(ratings));
    }
}