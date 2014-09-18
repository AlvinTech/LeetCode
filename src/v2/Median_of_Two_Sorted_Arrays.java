/*   Median of Two Sorted Arrays
There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
* */
/**
 * Created with IntelliJ IDEA.
 * User: Alvin
 * Date: 14-9-16
 * Time: 下午8:09
 * To change this template use File | Settings | File Templates.
 */
public class Median_of_Two_Sorted_Arrays {

    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;
        int left = (m+n+1)/2; // 使得left 是第left个数，从1开始。
        int right =(m+n+2)/2;
        if(left == right)
            return  median(A,0,m,B,0,n,left) ;
        else
            return (median(A,0,m,B,0,n,left)+median(A,0,m,B,0,n,right))/2;
    }
    public double median(int[] A,int sta1, int end1,int[] B, int sta2,int end2, int k){
        int m = end1 - sta1;
        int n = end2 - sta2;
        if(m > n){// swap let A > B
            return  median(B,sta2,end2,A,sta1,end1,k);
        }
        if(m == 0)
            return B[sta2 + k-1];
        if(k ==1){
            return Math.min(A[sta1], B[sta2]);
        }
        int i = Math.min(m, k/2);
        int j = Math.min(n, k/2);
        if( A[sta1 + i-1] > B[sta2 + j-1])
            return median(A,sta1,end1,B,sta2+j,end2,k-j);
        else
            return median(A,sta1+i,end1,B,sta2,end2,k-i);

    }
    public static void main(String[] args) {
        int[] A = {1,3,5,7,9,11};
        int[] B= {0,2,4,6,8,10,12};
        System.out.println(new Median_of_Two_Sorted_Arrays().findMedianSortedArrays(A, B));

    }
}
