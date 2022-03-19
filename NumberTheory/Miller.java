package Discrete;
import java.math.BigInteger;

public class Miller {

    //Function to get the value of k inorder to use it in calculating the value of m.
    public static long getK(long n){
        long i=1;
        //Dividing everytime by powers of 2 starting from 2^1 until we get a value that isn't an integer.
        //Then the previous value will be the m and the previous "i" will be the k value.
        while(true){
            if(n%Math.pow(2,i)!=0){
                i--;
                break;
            }
            i++;
        }
        return i;
    }

    public static void miller(long n,long a){
        
        if(n==2 || n==3){
            System.out.println(n+" is a prime.");
            return;
        }
        
        //Even or 1  or negative will obviously be a composite.
        if(n%2==0 || n==1|| n<=0){
            System.out.println(n+" is a composite.");
            return;
        }
        
        //Accuracy level range.
        if(a<=1 || a>=n-1){
            System.out.println("Enter a correct value of  'a' (1< a <n-1)!!");
            return;
        }
        
        //Getting k value.
        long k = getK(n-1);
        //Getting m value.
        long m = (long) ((n-1)/Math.pow(2,k));
        boolean isPrime = false;
        long b=0;
        //Using BigInteger as the values may be too long.
        BigInteger bigN = BigInteger.valueOf(n);
        BigInteger bigA = BigInteger.valueOf(a);
        BigInteger bigM = BigInteger.valueOf(m);
        BigInteger bigC = bigA.modPow(bigM,bigN);

        long i=0;
        
        for(i=0;i<=k-1;i++){
           //If the a^m mod n == -1 or 1, then n is probably a prime.
           //Else we will test again (a^m)^2i , starting from i=1 till i=k.
           //If (a^m)^2i = -1, then n is probably a prime.
           //If (a^m)^2i = 1, then n is a composite. 
           if(bigC.longValue()==n-1){
               isPrime=true;
               break;
           }else if(bigC.longValue()==1) {
               if (i == 0) {
                   isPrime = true;
               }else {
                   isPrime = false;
               }
               break;
           }

          bigC=bigC.modPow(BigInteger.valueOf(2),bigN);

        }
        if(isPrime==true){
            System.out.println(n+" is probably a prime.");
        }else{
            System.out.println(n+" is a composite.");
        }
    }
}