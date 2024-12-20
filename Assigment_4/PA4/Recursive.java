//Servando Olvera, 1001909287

import java.util.Scanner;

public class Recursive {
    String str;

    public Recursive(String s) {
        str = s;

        if(str.length()==0) {
            System.out.print("\nMmmm...That's an empty string!\n");
        } else {
            if(isPalindrome(str)){
                System.out.println("\nString a palindrome!\n");
            } else {
                System.out.println("\nString is NOT a palindrome\n");
            }
        }
    }
    
    public boolean isPalindrome(String str) {
        int l = str.length();

        if(l==1 || l==0) {
            return true;
        }
        if(str.charAt(0) == str.charAt(l-1)) {
            return isPalindrome(str.substring(1, l-1));
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("[A palindrome is a string that is equal to its reverse]");
        System.out.println("Enter a String to test if it is a palindrome");
        System.out.print("> ");
        String s = sc.nextLine();

        Recursive rec = new Recursive(s);
        sc.close();
    }
}
