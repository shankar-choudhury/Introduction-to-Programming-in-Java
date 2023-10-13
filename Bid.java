// Shankar Choudhury
// This class represents a bid that a contractor makes for the contract
public class Bid {
  // Value of bid made by contractor
  private double value = 0;
  // Bid's contractor
  Contractor contractor = null;
  // Contract that bid is for
  Contract contract = null;
  
  // Bid constructor
  public Bid(Contract contract, Contractor contractor, double value){
    this.contract = contract;
    this.contractor = contractor;
    this.value = value;
  }
  
  // Accessor Methods
  // Returns the contract for bid
  public Contract contract(){
    return contract;
  }
  // Return the contractor for bid
  public Contractor getContractor(){
    return contractor;
  }
  // Return the value of the bid
  public double value(){
    return value;
  }
  
}