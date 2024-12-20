// Servando Olvera, 1001909287

class Donor {
  private String name = new String();
  private String rating = new String();

  public Donor(String s1, String s2) {
    name = s1;
    if(s2.equals("high") || s2.equals("medium") || s2.equals("none")) {
      rating = s2;
    }
  }

  public String getName() {
    return name;
  }

  public String getRating() {
    return rating;
  }
  
  public static void main(String[] args) {
    Donor donor1 = new Donor("NewDonor", "high"); 
    System.out.println("Donor’s name is " + donor1.getName()); 
    System.out.println(donor1.getName() + "’s rating is " + donor1.getRating()); 
    
    Donor donor2 = new Donor("NewDonor2", "medium"); 
    System.out.println("Donor’s name is " + donor2.getName()); 
    System.out.println(donor2.getName() + "’s rating is " + donor2.getRating()); 
    
    Donor donor3 = new Donor("NewDonor3", "unknown"); 
    System.out.println("Donor’s name is " + donor3.getName()); 
    System.out.println(donor3.getName() + "’s rating is " + donor3.getRating()); 
  }
}