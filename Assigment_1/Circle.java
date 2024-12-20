//Servando Olvera, 1001909287

import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;
import java.text.NumberFormat;

class Circle {
  NumberFormat formatter = new DecimalFormat("#0.00"); // Fancy Formatting
  double radius;
  double area;
  double circumference;

  public Circle(Double diameter) { // Constructor to update radius
    radius = diameter / 2;
  }

  public void calculations() { // Did everything in a single Method
    area = Math.PI * radius * radius;
    circumference = 2 * Math.PI * radius;

    System.out.println("\nThe Diameter of circle is: " + formatter.format(radius * 2));
    System.out.println("The Area of the Circle is: " + formatter.format(area));
    System.out.println("The Circumference of the circle is: " + formatter.format(circumference)+ "\n");
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    Double diameter1, diameter2;
    
    System.out.print("Enter Diamater of Circle 1: "); 
    diameter1 = scn.nextDouble();
    Circle c1 = new Circle(diameter1); // Object Circle 1
    c1.calculations();

    System.out.print("Enter Diamater of Circle 2: "); 
    diameter2 = scn.nextDouble();
    Circle c2 = new Circle(diameter2); // Object Circle 2
    c2.calculations();
  }
}