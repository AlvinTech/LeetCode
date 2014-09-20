package com.alvin.java;

/** Climbing Stairs T
 * Created with IntelliJ IDEA.
 * User: Alvin
 * Date: 14-9-18
 * Time: 下午2:56
 You are climbing a stair case. It takes n steps to reach to the top.
 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 DP: if in n step;
 1. for n-1 climb 1 step to n;
 2. fro n-2 climb 2 step to n;
 */
public class Climbing_Stairs {
    public int climbStairs(int n) {
        int[] array = new int[n+1];
        array[0] = 1;
        array[1] = 1;
        for(int i = 2; i <= n; i++){
           array[i] = array[i-1] + array[i-2];
        }
        return array[n];
    }
}
