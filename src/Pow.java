/**
 * 2014-5-16
 * @author Alvin
 * 
 */

public class Pow {

   public double pow(double x, int n) {
      if(n < 0)
    	  return 1/ pow2(x,-n);
      else
    	  return pow2(x,n);
	}
   
   public double pow2(double x, int n){
	   double result =1;
		  double temp = 1;
		  if(n == 0){
			  return 1;
		  }else{
			  if(n % 2 ==1){
				  temp = pow2(x,n/2);
				  return temp*temp*x;
			  }else
			  {
				  temp = pow2(x,n/2);
				  return temp*temp;
			  }
		  }
		
   }
	public static void main(String[] args) {
		System.out.println(new Pow().pow(2,-5));

	}

}
