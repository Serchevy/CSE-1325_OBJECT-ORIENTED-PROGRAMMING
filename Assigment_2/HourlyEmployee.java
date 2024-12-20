// Servando Olvera, 1001909287

class HourlyEmployee extends Employee {
  private double payRate = 0;
  private double hoursWorked = 0;

  public HourlyEmployee(String s, String jb) {
    name = s;
    jobTitle = jb;
  } 

  public double calculateWeeklyPay() {
    return payRate * hoursWorked;
  }

  public void setRate(double r) {
    payRate = r;
  }

  public void setHours(double h) {
    hoursWorked = h;
  }

  public static void main(String[] args) {
    HourlyEmployee empl = new HourlyEmployee("Marsha Smith", "Programmer");
    empl.setRate(16.70);
    empl.setHours(38.5);
    System.out.println("The employee is " + empl.toString());
    System.out.println("whose salary last week was $" + String.format("%.2f", empl.calculateWeeklyPay()));
  }
}