// Servando Olvera, 1001909287

abstract class Employee { 
  protected String name;
  protected String jobTitle;

  public String toString() {
    return name + ", " + jobTitle;
  }
  
  public abstract double calculateWeeklyPay();
}