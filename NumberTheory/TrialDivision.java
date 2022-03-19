package Discrete;
import java.util.*;
public class TrialDivision {
	public static LinkedList <Integer> factorization =new LinkedList<Integer>();
	public static void trialDiv(int n) {
		if(n==0|| n==1) {
			System.out.println(n +" is not Prime");
			return;
		}
		if(n==2) {
			System.out.println(n +" is Prime");
			return;
		}
		boolean f=primeFactorization(n);
	    if(f==true) {
		System.out.println(n+" is Prime");
	     }else {
	    	 System.out.println(n +" is not Prime");
	    	 System.out.println("the prime factorization of the number");
	    	 for(int i =0;i<factorization.size()-1;i++) {
	    		 
	    		 System.out.print(factorization.get(i) + " * ");

	    	 }
	    	 System.out.print(factorization.get(factorization.size()-1));
	     }
	    //as it is global to set it again
	    factorization.clear();
	    
	}
	//this function return false if it has prime factorization so it is not prime and true otherwise
   public static  boolean primeFactorization(int n) { 
	  
	  boolean flag=true;
	   for(int i=2 ;i<=Math.sqrt(n);i++) {
		   if(n%i==0) { 
			   flag= false;
			   while(n%i==0) {
				   n=n/i;
				   factorization.add(i);   
			   }   
		   }  
	   }
	   if(n!=1) {
		   factorization.add(n);
		   
	   }
	   return flag;
	   
   }
}
