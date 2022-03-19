package Discrete;

import java.util.Scanner;

public class MainLab2 {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("1-sieve of Eratosthenes ");
		System.out.println("2-trial Division");
		System.out.println("3-The Extended Euclidean");
		System.out.println("4-Chinese remainder");
		System.out.println("5-Miller's test");
		System.out.println("6-EXIT");
		int op;
		boolean flag = true;
		while (flag) {
			System.out.println();
			System.out.println("--------------------------------");
			System.out.println("Enter number of method:");
			op = input.nextInt();
			switch (op) {
			case 1: {
				int n;
				System.out.println("sieve of Eratosthenes");
				System.out.println("Enter the limit :");
				n = input.nextInt();
				Sieve.sieveOfEratosthenes(n);
			}
				break;

			case 2: {
				int n;
				System.out.println("Trial Division");
				System.out.println("Enter the number :");
				n = input.nextInt();
				TrialDivision.trialDiv(n);
			}
				break;
			case 3: {
				int a;
				int b;
				System.out.println("Extended Euclidean");
				System.out.println("Enter first number :");
				a = input.nextInt();
				System.out.println("Enter second number :");
				b = input.nextInt();
				ExtendedEuclidean.euclidean(a, b);

			}
				break;
			case 4: {
				input.nextLine();
				System.out.println("Chinese remainder");
				System.out.println("Enter values of a1,a2,...an:");
				String s1 = input.nextLine();
				System.out.println("Enter values of m1,m2,...mn :");
				String s2 = input.nextLine();
				CRT.crt(s1, s2);
			}
				break;

			case 5: {
				System.out.println("Miller's test");
				System.out.println("Enter the number :");
				long p= input.nextLong();
		        System.out.println("If you want to enter value of 'a' : Enter 1 and if you want to make it random: Enter 2 !! ");
		        long k= input.nextLong();
		        if(k==1){
		            System.out.println("enter value of  'a':");
		            k=input.nextLong();
		        }else if(k==2){
		            k= (long) (Math.random()*(p-4))+2;
		        }else{
		            System.out.println("Enter Valid Input!!");

		        }
		       
		        Miller.miller(p,k);
			}
				break;

			case 6:
				flag = false;
				break;
			default:
				System.out.print("INVALID INPUT!! ");

			}
			
		}

	}

}
