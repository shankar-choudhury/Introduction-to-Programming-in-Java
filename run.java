//This class tests the entire contract package
public class run {
  public run() {
    Contractor c1 = new Contractor("Peter Jopek", "123", "Lisa Jopek");
    Contractor c2 = new Contractor("John Hancock", "789", "Emma Hancock");
    Contractor c3 = new Contractor("Shankar Choudhury", "101112", "Kerry Swartz");
  
    // Early finish
    Date c1finish = new Date(10, 10, 2010);
    // On deadline finish
    Date c2finish = new Date(11, 10, 2010);
    // late finish
    Date c3finish = new Date(12, 10, 2010);
    // Deadline
    Date deadline = new Date(11, 10, 2010);
  
    Contract con = new Contract("Contract 1", 20.0, 30.0, 1, 1, deadline);
  
    Bid bc1 = new Bid(con, c1, 22);
    Bid bc2 = new Bid(con, c2, 23);
    Bid bc3 = new Bid(con, c3, 24);
  }
}