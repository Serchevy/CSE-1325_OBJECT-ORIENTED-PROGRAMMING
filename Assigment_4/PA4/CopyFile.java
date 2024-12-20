//Servando Olvera, 1001909287

import java.util.Scanner;
import java.io.*;

public class CopyFile {

    static void copyData(File a, File b) throws IOException {
        FileInputStream f_in = new FileInputStream(a);
        FileOutputStream f_out = new FileOutputStream(b);

        try {
            int n;

            while((n = f_in.read()) != -1) {
                f_out.write(n);
            }
        } catch(IOException e) {
            System.out.println("\n  ERROR! FILE COULD NOT BE FOUND.\n");
        } finally {
            if(f_in != null) {
                f_in.close();
            }
            if(f_out != null) {
                f_out.close();
            }
        }
    }

    static void makeCopyOfFile(File a, String dirct, String file) throws IOException {
        File a2 = new File(dirct + File.separator + file);

        try {
            a2.createNewFile();
        } catch(IOException e) {
            System.out.println("    ERROR! DIRECTORY/FILE COULD NOT BE FOUND.");
        }
        
        copyData(a, a2);

        a.delete();
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
    
        System.out.print("Enter name of file 1: ");
        String f1 = scan.nextLine();
        File a = new File(f1);


        System.out.print("Enter name of file 2: ");
        String f2 = scan.nextLine();
        String substr = f2.substring(f2.length()-4);

        if(substr.equals(".txt")) {
            File b = new File(f2);
            copyData(a, b);
            System.out.println("\nFile has been copied!\n");
        } else {
            makeCopyOfFile(a, f2, f1);
            System.out.println("\nFile has been copied to directory!");
            System.out.println("[Old file has been deleted]\n");
        }

        scan.close();
    }
    
}
