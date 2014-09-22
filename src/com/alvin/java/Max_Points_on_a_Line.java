/* Max Points on a Line
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
* */
package com.alvin.java;
// Definition for a point.
class Point {
     int x;
     int y;
     Point() { x = 0; y = 0; }
     Point(int a, int b) { x = a; y = b; }
 }

public class Max_Points_on_a_Line {

   public int maxPoints(Point[] points) {
       int big =0;
       int flag =0;
       if(points.length<2){
           return points.length;
       }
       for(int i = 0; i < points.length ; i++)
           for(int j=i+1; j <points.length; j++){
               if((points[i].x != points[j].x) || (points[i].y != points[j].y) ){
                   int temp = Number(points[i],points[j],points);
                   if(temp > big)
                       big = temp;
                   flag =1;
               }
           }
       if(flag ==0) // 所有的点同一行或者同一列。
           return points.length;
       else
           return big;

   }
   private int Number(Point point, Point point2, Point[] points) {
       int count =0;
       for(int i=0; i<points.length ;i++){
           if((point2.x- point.x)*(points[i].y-point.y) ==
                   (points[i].x- point.x)*(point2.y-point.y)){
               count++;
           }
       }
       return count;
   }
}
