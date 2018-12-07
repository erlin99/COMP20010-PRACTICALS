/* Calculating the first n terms of the fibonacci sequence 
 * iteratively and recursively
 * @author Er Lin 
 */

import java.util.Scanner;

public class Fibonnacci {
	
	//Compute fibonacci's nth term using loops 
	public static int fibonacciIterative(int n)
	{
		int term1 = 0; //fibonnaci 1st term
		int term2 = 1;//fibonacci 2nd term
		int next = 0;
		
		if(n == 1) //if only asking for 1st term
			return term1;
		else if(n == 2) //if only asking for 2nd term
			return term2;
		else { 
			for(int i = 0; i < n-2; i++) {
				next = term1 + term2;
				term1 = term2;
				term2 = next;
			}
			return next;
		}
	}
	
	//Computes fibonnacci's nth term  using recursive algorithm 
	public static int fibonacciRecursive(int n) {
		if(n <= 1)
			return n; 
		else 
			return fibonacciRecursive(n-1) + fibonacciRecursive(n-2);
	}
	
	public static void main(String [] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the number of terms: ");
		int num = scan.nextInt();
		System.out.println("\nUsing iteration algorithm");
		System.out.println("The term " + num + " is: " + fibonacciIterative(num));
		
		System.out.println("\nUsing recursive algorithm ");
		System.out.println("The term " + num + " is: " + fibonacciRecursive(num-1));

		scan.close();
	}
}
