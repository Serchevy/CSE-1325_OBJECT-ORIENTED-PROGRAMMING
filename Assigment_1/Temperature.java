// Servando Olvera, 1001909287

import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.NumberFormat;

class Temperature {
  double degrees;

  public Temperature(Double tempt) { // Constrcutor to update degrees
    degrees = tempt;
  }

  public double getFahrenheit() { 
    return degrees;
  }

  public double getCelsius() {
    return (5 * (degrees - 32) / 9);
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in); 
    NumberFormat formatter = new DecimalFormat("#0.00"); // Fancy Formatting

    double tempt1, tempt2;

    System.out.print(">Enter temperature in thermometer1 in F: "); 
    tempt1 = scn.nextDouble();
    Temperature thermometer1 = new Temperature(tempt1); // Object Thermometer 1
    System.out.println("\nThe Fahrenheit temperature of thermometer1 is "+ formatter.format(thermometer1.getFahrenheit())+ " degrees");
    System.out.println("The Celsius temperature of thermometer1 is " + formatter.format(thermometer1.getCelsius())+ " degrees\n");

    System.out.print(">Enter temperature in thermometer2 in F: "); 
    tempt2 = scn.nextDouble();
    Temperature thermometer2 = new Temperature(tempt2); // Object Thermometer 2
    System.out.println("\nThe Fahrenheit temperature of thermometer1 is "+ formatter.format(thermometer2.getFahrenheit())+ " degrees");
    System.out.println("The Celsius temperature of thermometer1 is "+ formatter.format(thermometer2.getCelsius())+ " degrees");
  }
}
