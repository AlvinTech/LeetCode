package v1;

import java.util.Date;

public class Time {

	private Date date ;
	long start;
	public void start(){
		start =  new Date().getTime();
	}
	public long end(){
		long end = new Date().getTime();
		return end -start;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
