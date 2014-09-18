/** Climbing Stairs T
 * Created with IntelliJ IDEA.
 * User: Alvin
 * Date: 14-9-18
 * Time: 下午2:56
 You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class Climbing_Stairs {
}

//python:
//class Solution:
//        def climbStairs(self, n):
//        a,b = 1,2
//        result = 1
//        for i in range(3,n+1):
//        result = a + b
//        a = b
//        b = result
//        if n <=2:
//        return n
//        else:
//        return result