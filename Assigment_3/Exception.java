//Servando Olvera, 1001909287

import java.util.Scanner;

public class Exception {
	int arr[];

	void insort(int arr[]) {
		// Test if array trhows a NullPointerException
		// if so, popolate given arr 
		try{
			int n = arr.length;
		} catch(NullPointerException e) {
			System.out.println("\nWoops! You have a NULL array reference");
			System.out.println("Fixing issues...\n");
			System.out.println("Please Enter data again :)");
			arr = makeArr();
		}
		// Insetion sort that I know
		int n = arr.length;
		for (int i = 1; i < n; ++i) {
			int key = arr[i];
			int j = i - 1;

			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}

		System.out.println("\nSorted array:");
		printArray(arr);
	}

	// Prints given array
	static void printArray(int arr[]) {
		int N = arr.length;
		for (int i = 0; i < N; ++i) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n");
	} 

	// create arr and populate it given size and values
	static int[] makeArr() {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter size of array: ");
		int size = in.nextInt();

		int arr[] = new int[size];

		System.out.println("Enter the elements of the array one by one:");
    for(int i=0; i<size; i++) {
       arr[i] = in.nextInt();
    }
		return arr;
	}

	public static void main(String args[]) {
		Exception ob = new Exception();
		System.out.println("\nThis program will sort any given array!");

		int arr[] = makeArr();
		
		ob.insort(ob.arr);
	}
}