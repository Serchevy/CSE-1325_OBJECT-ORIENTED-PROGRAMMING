// Servando Olvera, 1001909287

class SalaryEmployee extends Employee {
  private double weeklySalary = 0;

  public SalaryEmployee(String s, String jb) {
    name = s;
    jobTitle = jb;
  }

  public void setSalary(double s) {
    weeklySalary = s;
  }

  public double calculateWeeklyPay() {
    return weeklySalary;
  }

  public static void main(String[] args) {
    SalaryEmployee empl = new SalaryEmployee("William Jones", "Analyst");
    empl.setSalary(439.00);
    System.out.println("The employee is " + empl.toString());
    System.out.println("whose salary last week was $" + String.format("%.2f", empl.calculateWeeklyPay()));
  }
}