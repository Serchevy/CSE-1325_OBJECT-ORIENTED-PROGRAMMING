//Servando Olvera, 1001909287

import java.util.Scanner;
import java.util.Arrays;

public class Anagram {
	String words[] = new String[100];

	//Take String Arr and Sort it
	static String[] sort(String words[], int size) {
		String sorted[] = new String[size];
		for (int i = 0; i < size; i++) {  //Make a copy of provide arr to do logic
			sorted[i] = words[i];
		}

		Arrays.sort(sorted); //Alphabetically sort given arr'
		
		//Logic to group anagrams together using the ascii value of each word
		for (int i = 0; i < size; i++) { 
			int s1 = asciiVal(sorted[i]);
			int k = 1;

			for (int j = i + 1; j < size; j++) {
				int s2 = asciiVal(sorted[j]);

				if (s1 == s2 && i + k < size) {
					String temp = sorted[i + k];
					sorted[i + k] = sorted[j];
					sorted[j] = temp;
					k++;
				}
			}
		}
		return sorted;
	}

	//Calculate ascii value of a word and returs it
	static int asciiVal(String s) {
		int val = 0;

		for (int i = 0; i < s.length(); i++) {
			val += (int) s.toLowerCase().charAt(i);
		}
		return val;
	}

	//Print anagram dictionary
	static void anagram(String sorted[]) {
		int indx_val[] = new int[sorted.length];

		//Store ascii vals of every word in an int arr
		for (int i = 0; i < sorted.length; i++) { 
			int val = asciiVal(sorted[i]);
			indx_val[i] = val;
		}

		int k =0;
		while (k < sorted.length) {
			char chars[] = sorted[k].toCharArray(); 		//Copy word at k into a char[]
			Arrays.sort(chars);                         //Sort char[] alphabetically
			String str = new String(chars);							//Make it a string again
			System.out.print( "["+str+"]" + " ---> ");  //Display it

			int val = asciiVal(str);                    //Get its ascii val

			for(int i=k; i<sorted.length; i++){         //Compare value to values in int arr, after indx k
				if(indx_val[i] == val) {									//if there is a match, print respective the word in str[]
					System.out.print(sorted[i] +", ");
					k++;																		//increment k
				}
			}
			System.out.println();
		}
	}

	
	public static void main(String[] arg) {
		Scanner in = new Scanner(System.in);
		Anagram Dict = new Anagram();

		int i = 0;

		System.out.println("\nAfter typing a word hit enter!");
		System.out.println("STOP early by enetring [-1]");
		System.out.println("Enter up to 100 words for anagram dictionary: ");

		while (i < 100) { //Read up to 100 words. Stop when user types "-1"
			Dict.words[i] = in.nextLine();

			if (Dict.words[i].equals("-1")) {
				break;
			}
			i++;
		}
		
		String sorted[] = sort(Dict.words, i); //Call sort and asigne retuned value to sorted               
		System.out.println("\nHere's your anagram dictionary");
		
		anagram(sorted); //call anagram on sorted
		System.out.println();
	}
}