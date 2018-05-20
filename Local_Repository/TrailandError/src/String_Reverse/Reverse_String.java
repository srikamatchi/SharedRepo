package String_Reverse;

import java.sql.Array;

public class Reverse_String {
	
	public static String sname = "Prasanth";
	
	public static void reverse(){
	
		String A[] = sname.split("");
		
		System.out.println(A.length);
		
		int temp=0;
		
		for (int i=7; i>=temp ; i--){
		
		System.out.println(A[i]);	
			
		}
		
	}
	
	public static void main(String[] args) {
		
		reverse();
		
		
	}
	

}