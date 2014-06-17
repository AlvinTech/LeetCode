/**
 * 2014-6-13
 * @author Alvin
 * 
 */

public class Median_of_Two_Sorted_Arrays {
	public double findMedianSortedArrays(int A[], int B[]) {
		if(A.length ==0)
			return  B== null? null : B[B.length/2];
		if(B.length ==0)
			return A == null ? null :A[A.length/2]; 
		int lengthA = A.length;
		int lengthB = B.length;
		int k  = (lengthA + lengthB+1) /2;
	      return findMdian(A,0,lengthA,B,0,lengthB,k);  
	}
	
	public int findMdian(int A[],int startA,int endA, int B[],int  startB,int endB,int k){
		// 不包括 endA endB
		if(k == 0)
			return Math.min(A[startA>= endA? endA-1:startA ], B[startB>=endB? endB-1: startB]);
		int lengthA = endA - startA;
		int lengthB = endB  - startB;
		if(lengthA == 0)
			return B[startB+k-1];
		if(lengthB == 0)
			return A[startA+k-1];
		// i + j + 1 = k  ===> i +j = k -1;  按照比例分配
		// [indexB-1]< [indexA] <[indexB]   k = indexB +indexA +1(A[indexA]);
		// [indexA-1]< [indexB] <[indexA]   k = indexB +indexA +1(B[indexB]);
		int indexA = (int) (1.0* lengthA* (k -1) / (lengthA+lengthB));
		int indexB = k- 1 - indexA;
		
		int Ai_1 =((indexA ==0)? 0xffff: A[ startA + indexA-1]);
		int Ai = ((indexA == endA)? 0x0fff: A[ startA + indexA]);
		int Bi_1 = ((indexB ==0)? 0xffff: B[ startB + indexB-1]);
		int Bi = ((indexB == endB)? 0x0fff: B[ startB + indexB>= endB? endB-1:startB + indexB]);
		if(Ai >= Bi_1 && Ai<=Bi)
			return Ai;
		else if(Bi >= Ai_1 && Bi<= Ai)
			return Bi;
		else if(Ai <  Bi){
			return findMdian(A,startA+indexA+1,endA,B,startB,endB,k-indexA-1);
		}else 
			return findMdian(A,startA,endA,B,startB+indexB+1,endB,k-indexB-1);
	}

	public static void main(String[] args) {
		int[] a = {5,6,7,8,9};
		int [] b={1,2,3,4};
		System.out.println(new Median_of_Two_Sorted_Arrays().findMedianSortedArrays(a,b));
	}

}
