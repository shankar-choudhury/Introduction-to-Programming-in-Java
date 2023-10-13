// Shankar Choudhury
// This class builds a contract for contractors to bid on
public class Contract {
  
  // Name of contract
  private String contractID = null;
  // Minimum pay for contractor
  private double minValue = 0;
  // Max pay fo contractor
  private double maxValue = 0;
  // Bonus-per-day for contractor if contractor finishes contract x days before deadline
  private double bonus = 0;
  // Penalty-per-day for contractor if contract finishes contract x days after deadline
  private double penalty = 0;
  // Deadline for contractor to finish contract
  private Date deadline = null;
  // Can contractor can submit a bid for contract?
  private boolean acceptBids = false;
  // Best bid for contractor, initialized to null to indicate no bids have been excepted;
  private Bid bestBid = null;
  // Is the contract complete?
  private boolean complete = false;
  // Date when contract was finished
  private Date completedDate = null;
  
  // Constructor to make contract
  public Contract(String contractID, double minValue, double maxValue, double bonus, double penalty, Date deadline){
    // Assign values
    this.contractID = contractID;
    this.minValue = minValue;
    // Ensures proposed max value of contract is greater than proposed min value
    if(maxValue > minValue)
      this.maxValue = maxValue;
    this.bonus = bonus;
    this.penalty = penalty;
    this.deadline = deadline;
    acceptBids = true;
  }
  
  // Accessor getter/setter methods
  // Return contract name
  public String getID(){
    return contractID;
  }
  
  // Return minimum value of contract
  public double getMinValue(){
    return minValue;
  }
  
  // Set minimum value of contract
  public void setMinValue(double minValue){
    this.minValue = minValue;
  }
  
  // Return max value of contract
  public double getMaxValue(){
    return maxValue;
  }
  
  // Set maximum value of contract
  public void setMaxValue(double maxValue){
    this.maxValue = maxValue;
  }
  
  // Return per-day bonus of completing contract early
  public double getBonus(){
    return bonus;
  }
  
  // Set per-day bonus of completing contract early
  public void setBonus(double bonus){
    this.bonus = bonus;
  }
  
  // Return per-day penalty of completing contract late
  public double getPenalty(){
    return penalty;
  }
  
  // Set per-day penalty of completing contract late
  public void setPenalty(double penalty){
    this.penalty = penalty;
  }
  
  // Return deadline for contract
  public Date getDeadline(){
    return deadline;
  }
  
  // Set deadline for contract
  public void setDeadline(Date deadline){
    this.deadline = deadline;
  }
  
  // Sets acceptBids to true and returns acceptBids 
  public boolean isAcceptingBids(){
      return acceptBids;
  }
  
  // Return best bid so far
  public Bid getBestBid(){
    return bestBid;
  }
  
  // Process a bid, return true if the bid is acceptable and is best bid, return false if bid is not accepted
  public boolean makeBid(Bid bid){
    /* If contract is accepting bids, bid's contract is the same as this contract, 
     * and bid is an acceptable value between the min and max value specified in contract */
    if (acceptBids == true && bid.contract() == this && 
        (bid.value() >= getMinValue() && bid.value() <= getMaxValue())){
      // If no best bid has been accepted yet
      if(bestBid == null){
        bestBid = bid;
        return true;
      }
      // If bid is better than current best bid by having a lower value
      else if (bid.value() < getBestBid().value()){
        bestBid = bid;
        return true;
      }
    }
    /* If contract doesn't accept bid because it isn't accepting bids, bid's contract does not match 
     * this contract, or if bid is outside bounds of minimum and maximum value */
    return false;
  }
  
  // Contract is not accepting bids
  public void awardContract(){
    acceptBids = false;
  }
  
  // returns whether contract is complete or not
  public boolean isComplete(){
    return complete;
  }
  
  // Return completion date of contract
  public Date completeDate(){
    return completedDate;
  }
  
  // Set contract to completed, sets the completed date for contract, and pay contractor their bid (the best bid)
  public void setComplete(Date completedDate){
    complete = true;
    this.completedDate = completedDate;
    /* Difference in days used to calculate bonus if difference is positive, penalty if difference is negative, 
     * and if 0 then contractor gets paid their bid */
    int diffDays = Date.difference(getDeadline(), completeDate());
    /* Compute final pay, 
     * case 1: contract was completed before deadline contractor is paid bid plus bonus, 
     * case 2: completed after deadline and contractor's bid is penalized so what they are paid is less than bid, 
     * case 3: contracted completed on deadline (diffDays == 0) and no bonuses or penalties are applied */
    // Case 1
    if (diffDays > 0){
      // Pay contractor maxValue if computed bonus plus bid value is more than maxValue 
      if (getBonus() * diffDays + getBestBid().value() > getMaxValue())
        getBestBid().getContractor().pay(getMaxValue());
      // Pay contractor their bid plus bonus
      else
        getBestBid().getContractor().pay(getBonus() * diffDays + getBestBid().value());
    }
    // Case 2 
    else if(diffDays < 0){
      // Pay contractor 0 if bid value minus computed penalty is less than 0
      if (getPenalty() * diffDays + getBestBid().value() < 0)
        getBestBid().getContractor().pay(0);
      // Pay contractor their bid minus penalty
      else
        getBestBid().getContractor().pay(getPenalty() * diffDays + getBestBid().value());
    }
    // Case 3
    else
      getBestBid().getContractor().pay(getBestBid().value());
  }
}