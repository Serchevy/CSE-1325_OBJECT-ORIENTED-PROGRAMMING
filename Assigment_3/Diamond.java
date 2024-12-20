//Servando Olvera, 1001909287

import java.util.Scanner;

public class Diamond {
	int N = 0;

	public Diamond(int r) {
		N = r;
	}

	public void printDiamond() {
		// Upper Half
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j < N - i; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k < (2 * i) - 1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}

		// Bottom Half
		for (int i = N - 1; i > 0; i--) {
			for (int j = 0; j < N - i; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k < (2 * i) - 1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char option = 'y';

		//keep running if user chooses to 
		while (option == 'y') {
			System.out.print("Input number of rows (half of the diamond) :");
			int num_rows = sc.nextInt();

			Diamond D = new Diamond(num_rows);
			D.printDiamond();
			
			System.out.print("\nWould you like to go again? [y] or [n]: ");
			option = sc.next().charAt(0);
		}
	}
}