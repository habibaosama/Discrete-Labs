package Discrete;

public class Sieve {
	public  static void sieveOfEratosthenes(int n) {
		//Array where location which assigned to 1 is prime
		int[] primes = new int[n+1]; 
		if(n==1) {
		System.out.println("there is no prime numbers up to 1 ");
		return;
		}
		for(int i=0 ;i<=n;i++) {
			primes[i]=1;
			//as 0 and 1 are not prime
			primes[0]=0;
			primes[1]=0;
		}
		
		for(int i=2;i<=Math.sqrt(n);i++) {
			if(primes[i]==1) {
				//for the multiplies of prime
				for(int j=2; j*i<=n ;j++) {
					primes[i*j]=0;
				}
			}
		}
		
		System.out.println("the prime numbers up to "+ n);

		 for (int i = 2; i <= n; i++)
	        {
	            if (primes[i] == 1)
	                System.out.print(i + " ");
	        }
	} 

}
