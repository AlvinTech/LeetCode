/*
com.alvin.java.Candy
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
*/
package com.alvin.java;
public class Candy{
    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        //allocate candies, considering the minimal rating on the left
        candy[0] = 1;
        for(int i = 1; i < ratings.length; i++){
            candy[i] = ratings[i] > ratings[i-1] ? candy[i-1]+1 : 1;
        }
        //modify the allocation, considering the minimal rating on the right
        //ex: 2,4,3,1 -> candy: 1,2,1,1   so wo should modify the  element index of 3
        int totalCandy = candy[ratings.length-1];
        for(int i = ratings.length-2; i >= 0; i--){
            candy[i] = (ratings[i] > ratings[i+1] && candy[i] < candy[i+1]+1  ) ? candy[i+1]+1 : candy[i];
            //count total candies by the way
            totalCandy += candy[i];
        }
        return totalCandy;
    }
    public static void main(String[] args) {
        int[] ratings ={1,4,1,1,2,4,3,1,1};
        System.out.println(new Candy().candy(ratings));
    }

}