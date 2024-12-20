//Servando Olvera, 1001909287

import java.util.Scanner;

public class BigInteger {
	int big1[] = new int[51];   // Arr that contains int 1
	int big2[] = new int[51];   // Arr that contains int 2
	int big3[] = new int[51];   // Arr that contains sum or diff. Result arr
	
	// Method to populate 1st & 2nd arr
	static void takeInput(int N, int big[]) {
		Scanner in = new Scanner(System.in);
		int indx = 50;

		if (N == 0) {
			System.out.println("\nEnter fisrt number with up to 50 digits: ");
			System.out.print(" > ");
		} else {
			System.out.println("\nEnter second number with up to 50 digits: ");
			System.out.print(" > ");
		}
		//Store large int as a string
		String num = in.nextLine();                     

		//Turn every character of str into int & place it inside resoective int arr
		for (int i = num.length() - 1; i >= 0; i--) {    
			int n = num.charAt(i) - '0';
			big[indx] = n;
			indx--;
		}
	}

	//Print given array
	//The N is so that it prints 51 decimals in result arr
	static void printArr(int big[], int N) {
		for (int i = 1-N; i < 51; i++) {
			System.out.print(big[i]);
		}
		System.out.println();
	}

	//Sumattion method
	static void summation(int big1[], int big2[], int big3[]) {
		for (int i = 50; i >= 0; i--) {
			int sum = big1[i] + big2[i];

			if (sum >= 10) {        //if sum is bigger than 10, 
				big3[i] = sum - 10;   //sub 10 from result
				big1[i - 1] += 1;     //then add 1 to int arr1
			} else {
				big3[i] = sum;
			}
		}
	}

	//Subtraction method
	static void subtraction(int big1[], int big2[], int big3[]) {
		for (int i = 50; i >= 0; i--) {
			int diff = big1[i] - big2[i];

			if (diff < 0) {              //if diff is negative
				big1[i] += 10;						 //add 10 to int arr1
				big1[i - 1] -= 1;					 //take 1 away from next value to the left in arr1
				diff = big1[i] - big2[i];  //calculate diff again
				big3[i] = diff;						 //set result = new calculated diff
			} else {
				big3[i] = diff;
			}
		}
	}

	public static void main(String[] arg) {
		Scanner in = new Scanner(System.in);

		int N = 0;
		char option = 'y';
		
		//keep runing if user chooses to 
		while (option == 'y') {
			BigInteger IntArr = new BigInteger();
			takeInput(N, IntArr.big1);             //Craete int arr1
			N++;
			takeInput(N, IntArr.big2);             //Create int arr2
			System.out.println();

			System.out.print("Would you like to Add [+] or Subtract [-] these numbers: ");
			char c = in.next().charAt(0);
			System.out.println();
			N--;
			System.out.print("Big Int1: ");       //Display arr1
			printArr(IntArr.big1, N);
			System.out.print("Big Int2: ");       //Display arr2
			printArr(IntArr.big2, N);
			
			for (int i = 0; i < 60; i++) {        //Dsplay a long line
				System.out.print("-");
			}
			System.out.println();
			N++;

			//Based on user's input display sum or add store in arr3
			if (c == '+') {
				summation(IntArr.big1, IntArr.big2, IntArr.big3);
				System.out.print("   sum = ");
				printArr(IntArr.big3, N);
			} else if(c=='-'){
				subtraction(IntArr.big1, IntArr.big2, IntArr.big3);
				System.out.print("  diff = ");
				printArr(IntArr.big3, N);
			} else {
				System.out.println("Huh?");
			}
			N--;
			System.out.print("\nWould you like to go again? [y] or [n]: ");
			option = in.next().charAt(0);
		}
	}
}