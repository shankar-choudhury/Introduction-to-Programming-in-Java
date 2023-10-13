// Shankar Choudhury
// This class represents a contractor with a name, address, contact person, and balance
public class Contractor {

  // Name of Contractor
  private String name = null;
  // Address of Contractor
  private String address = null;
  // Contact of Contractor
  private String contact = null;
  // Total amount contractor has been paid, initializing it to zero
  private double totalPaid = 0;
  
  // Constructor to build Contractor 
  public Contractor (String name, String address, String contact) {
    // Assign name
    this.name = name;
    // Assign address
    this.address = address;
    // Assign contact
    this.contact = contact;
  }
  
  // Accessor methods
  // Return name of contractor
  public String getName() {
    return this.name;
  }
  
  // Assign nameof contractor
  public void setName(String name) {
    this.name = name;
  }
  
  // Return address of contractor
  public String getAddress() {
    return this.address;
  }
  
  // Set address of contractor
  public void setAddress(String address) {
    this.address = address;
  }
  
  // Return contact of contractor
  public String getContact() {
    return this.contact;
  }
  
  // Assign name of contact
  public void setContact(String contact) {
    this.contact = contact;
  }
  
  // Return total amount paid to contractor
  double getAmountPaid() {
    return totalPaid;
  }
  
  // Pay contractor and add to total paid to contractor
  public void pay(double pay) {
    this.totalPaid += pay;
  }
  
  // Overridden methods of Object
  // Override toString so that it returns contractor name, address, and contact
  @Override
  public String toString() {
    return " name: " + getName() + "\n address: " + getAddress() + "\n contact: " + getContact();
  }
  
  // Override equals so that two contractors are equal if their names are equal
  @Override 
  public boolean equals(Object o) {
    // First check if o is a contractor, use "instanceof" to ask if we can typecast 
    if (o instanceof Contractor) {
      // Create copy of Object o for comparison's sake
      Contractor e = (Contractor) o;
      // Return truth value of whether input contractor is the same as what it is being compared to
      return this.getName().equals(e.getName());
    }
    // Initialized return value
    return false;
  }
  
}