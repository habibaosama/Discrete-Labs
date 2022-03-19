package Discrete;
import java.util.*; 
public class ExtendedEuclidean {
	public static void euclidean(int a ,int b){
		int  x = 0;  int xOld = 1;
	    int y = 1; int yOld = 0;
	    int b1 = b; int  a1 = a;
	    while(b != 0) {
	        int  quotient = a/b;
	      //temp used to store value of b to be assigned to a in coming step
	        int temp =b ;
	        //new b will get from last  remainder
	        b = a - quotient*b;
	        a = temp;
	      //the  Bezout’s coefficients will be xOld and yOld
	        //the variables of extended euclidean
	       // Xold store value of next
	        temp = x;
	        x = xOld - quotient*x;
	        xOld = temp;

	        temp =y ;
	        y = yOld - quotient*y;
	        yOld = temp;
	    }
	    
        System.out.println(" s a + t b  =  gcd ");
		 System.out.println("( " + xOld +" * "+ a1 +" ) "+ " + "+" ( " +yOld+" * " + b1 + " ) "+ " = "+ a );
	}

}
