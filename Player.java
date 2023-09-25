/**
 * This class represents a player and its attributes
 * @author Shankar Choudhury
 */
public class Player {
  // Name of player
  private String name;
  // Score of player
  private int score;
  // Player's cards collected from playing cards
  private LinkedList<Card> cardsCollected;
  // Value of whether it is this player's turn or not
  private boolean isTurn;
  
  // Boolean values of whether special abilities have been used once or not
  // Value of whether move front back by 4 has been used
  private boolean moveBackFourUsed;
  // Value of whether move front back by 3 has been used
  private boolean moveBackThreeUsed;
  // Value of whether move front back by 2 has been used
  private boolean moveBackTwoUsed;
  // Value of whether move front back by 1 has been used
  private boolean moveBackOneUsed;
  // Value of whether move front to end has been used
  private boolean moveFrontToEndUsed;
  // Value of whether move end to front has been used
  private boolean moveEndToFrontUsed;
  // Value of whether reverse drawn cards being played with has been used
  private boolean reverseCardsUsed;
  // Value of whether reverse first k cards of cards being played with has been used has been used
  private boolean reverseFirstFiveCardsUsed;
  // Value of whether skip turn has been used
  private boolean skipTurnUsed;
  
  // Boolean values of whether specific cards with special points have been collected
  // Value of whether a count has been collected
  private boolean countCollected;
  // Value of whether a countess has been collected
  private boolean countessCollected;
  // Value of whether a lord has been collected
  private boolean lordCollected;
  // Value of whether a lady has been collected
  private boolean ladyCollected;
  
  // Int values of how many specific special cards have been collected
  // Number of church cards in player's hand
  private int numChurchCards = 0;
  // Number of civic cards in player's hand
  private int numCivicCards = 0;
  // Number of palace guard cards in player's hand
  private int numPalaceGuardCards = 0;
  // Number of commoner cards in player's hand
  private int numCommonerCards = 0;
  
  /**
   * Default constructor for player with no input
   */
  public Player(String name) {
    this.name = name;
    score = 0;
    cardsCollected = new LinkedList<Card>();
  }
  
  /**
   * Return player's name
   * @return name The player's name
   */
  public String getName() {
    return name;
  }
  
  /**
   * Return score of player
   * @return score The score of this player
   */
  public int getScore() {
    return score;
  }
  
  /**
   * Set score of player
   * @param points The total points that player's score will be set to
   */
  public void setScore(int points) {
    score = points;
  }
  
  /**
   * Return cards collected
   * @return cardsCollected The cards collected by this player
   */
  public LinkedList<Card> getCardsCollected() {
    return cardsCollected;
  }
  
  /**
   * Return whether it is this player's turn
   * @return isTurn The value of whether it is this player's turn
   */
  public boolean getTurn() {
    return isTurn;
  }
  
  /**
   * Assign this player's turn to be a truth value
   * @param isTurn The value to be assigned to this player of whether it is this player's turn or not
   */
  public void setTurn(boolean isTurn) {
    this.isTurn = isTurn;
  }
  
  /**
   * Return whether move back by four was used
   * @return moveBackFourUsed Whether move back by four has been used
   */
  public boolean getMoveBackFourUsed() {
    return moveBackFourUsed;
  }
  
  /**
   * Set moveBackFourUsed to true
   */
  public void setMoveBackFourUsed() {
    moveBackFourUsed = true;
  }
    
  /**
   * Return whether move back by three was used
   * @return moveBackThreeUsed Whether move back by three has been used
   */
  public boolean getMoveBackThreeUsed() {
    return moveBackThreeUsed;
  }
  
  /**
   * Set moveBackThreeUsed to true
   */
  public void setMoveBackThreeUsed() {
    moveBackThreeUsed = true;
  }
  
  /**
   * Return whether move back by two was used
   * @return moveBackTwoUsed Whether move back by two has been used
   */
  public boolean getMoveBackTwoUsed() {
    return moveBackTwoUsed;
  }
  
  /**
   * Set moveBackTwoUsed to true
   */
  public void setMoveBackTwoUsed() {
    moveBackTwoUsed = true;
  }
  
  /**
   * Return whether move back by one was used
   * @return moveBackOneUsed Whether move back by one has been used
   */
  public boolean getMoveBackOneUsed() {
    return moveBackOneUsed;
  }
  
  /**
   * Set moveBackOneUsed to true
   */
  public void setMoveBackOneUsed() {
    moveBackOneUsed = true;
  }
  
  /**
   * Return whether move front card to end of drawn playing cards has been used
   * @return moveFrontToEndUsed Whether move front card to end of playing cards was used
   */
  public boolean getMoveFrontToEndUsed() {
    return moveFrontToEndUsed;
  }
  
  /**
   * Set moveFrontToEndUsed to true
   */
  public void setMoveFrontToEndUsed() {
    moveFrontToEndUsed = true;
  }
  
  /**
   * Return whether move back card to front of drawn playing cards has been used
   * @return moveEndToFront whether move back card to front of playing cards was used
   */
  public boolean getMoveEndToFrontUsed() {
    return moveEndToFrontUsed;
  }
  
  /**
   * Set moveEndToFrontUsed to true
   */
  public void setMoveEndToFrontUsed() {
    moveEndToFrontUsed= true;
  }
  
  /**
   * Return whether reverse drawn cards being played with has been used
   * @return reverseCardsUsed Whether reverse cards was used
   */
  public boolean getReverseCardsUsed() {
    return reverseCardsUsed;
  }
  
  /**
   * Set reverseCardsUsed to true
   */
  public void setReverseCardsUsed() {
    reverseCardsUsed= true;
  }
  
  /**
   * Return whether reverse first k cards of drawn cards being played with has been used
   * @return reverseFirstKCardsUsed Wether reverse first k cards of drawn cards being played with has been used
   */
  public boolean getReverseFirstFiveCardsUsed() {
    return reverseFirstFiveCardsUsed;
  }
  
  /**
   * Set reverseFirstFiveCardsUsed to true
   */
  public void setReverseFirstFiveCardsUsed() {
    reverseFirstFiveCardsUsed= true;
  }
  
  /**
   * Return whether skip this player's turn has been used
   * @return skipTurnUsed Whether skip this player's turn has been used
   */
  public boolean getSkipTurnUsed() {
    return skipTurnUsed;
  }
  
  /**
   * Set skipTurnUsed  to true
   */
  public void setSkipTurnUsed() {
    skipTurnUsed= true;
  }
  
  /**
   * Return whether a count has been collected
   * @return countCollected Boolean value of whether a count has been collected
   */
  public boolean getCountCollected() {
    return countCollected;
  }
  
  /**
   * Set count collected to be true
   */
  public void setCountCollected() {
    countCollected = true;
  }
  
  /**
   * Return whether a countess has been collected
   * @return countessCollected Boolean value of whether a countess has been collected
   */
  public boolean getCountessCollected() {
    return countessCollected;
  }
  
  /**
   * Set countess collected to be true
   */
  public void setCountessCollected() {
    countessCollected = true;
  }
  
  /**
   * Return whether a lord has been collected
   * @return lordCollected Boolean value of whether a lord has been collected
   */
  public boolean getLordCollected() {
    return lordCollected;
  }
  
  /**
   * Set lord collected to be true
   */
  public void setLordCollected() {
    lordCollected = true;
  }
  
  /**
   * Return whether a lady has been collected
   * @return ladyCollected Boolean value of whether a lady has been collected
   */
  public boolean getLadyCollected() {
    return ladyCollected;
  }
  
  /**
   * Set lady collected to be true
   */
  public void setLadyCollected() {
    ladyCollected = true;
  }
  
  /**
   * Return number of church cards collected by player
   * @return numChurchCards The number of church cards collected by player
   */
  public int getNumChurchCards() {
    return numChurchCards;
  }
  
  /**
   * Increment number of church cards collected by player by one
   */
  public void incNumChurchCards() {
    numChurchCards += 1;
  }
  
  /**
   * Return number of civic cards collected by player
   * @return numCivicCards The number of civic cards collected by player
   */
  public int getNumCivicCards() {
    return numCivicCards;
  }
  
  /**
   * Increment number of civic cards collected by player by one
   */
  public void incNumCivicCards() {
    numCivicCards += 1;
  }
  
  /**
   * Return number of palace guard cards collected by player
   * @return numPalaceGuardCards The number of palace guard cards collected by player
   */
  public int getNumPalaceGuardCards() {
    return numPalaceGuardCards;
  }
  
  /**
   * Increment number of palace cards collected by player by one
   */
  public void incNumPalaceGuardCards() {
    numPalaceGuardCards += 1;
  }
  
  /**
   * Return number of commoner cards collected by player
   * @return numCommonerCards The number of commoner cards collected by player
   */
  public int getNumCommonerCards() {
    return numCommonerCards;
  }
  
  /**
   * Increment number of commoner cards collected by player by one
   */
  public void incNumCommonerCards() {
    numCommonerCards += 1;
  }
  
  /**
   * Sum total points of this player's hand and set it as player's score
   */
  public void sumScore() {
    LLNode<Card> nodeptr = getCardsCollected().getFirstNode();
    int sum = 0;
    while (nodeptr != null) {
     sum += nodeptr.getElement().getPoints();
     nodeptr = nodeptr.getNext();
    }
    setScore(sum);
  }
  
  /**
   * Check if drawn card is a Count, Countess, Lord, or Lady, and adjust boolean values accordingly
   * @param cardsCollected This player's hand of cards they have collected
   */
  public void checkForSpecialCard(LinkedList<Card> cardsCollected) {
    // Check if card is the count card
    if (cardsCollected.getFirstNode().getElement().getName() == "Count")
      setCountCollected();
    // Check if card is the countess card
    else if (cardsCollected.getFirstNode().getElement().getName() == "Countess")
      setCountessCollected();
    // Check if card is the lord card
    else if (cardsCollected.getFirstNode().getElement().getName() == "Lord")
      setLordCollected();
    // Check if card is the lady card
    else if (cardsCollected.getFirstNode().getElement().getName() == "Lady")
      setLadyCollected();    
  }
  
  /**
   * Increment special card count if drawn card is a church, civic, palace guard, or commoner
   * @param cardsCollected This player's hand of cards they have collected
   */
  public void incSpecialCardCount(LinkedList<Card> cardsCollected) {
    // Check if card is type church
    if (cardsCollected.getFirstNode().getElement() instanceof Church)
      incNumChurchCards();
    // Check if card is type civic
    else if (cardsCollected.getFirstNode().getElement() instanceof Civic)
      incNumCivicCards();
    // Check if card is a palace guard
    else if (cardsCollected.getFirstNode().getElement().getName() == "Palace Guard")
      incNumPalaceGuardCards();
    // Check if card is type commoner
    else if (cardsCollected.getFirstNode().getElement() instanceof Commoner)
      incNumCommonerCards();
  }
  
  /**
   * Go through player's hand and adjust value of cards collected by this player as necessary
   * @param cardsCollected This player's cards they have in their hand
   */
  public void adjustCardValue(LinkedList<Card> cardsCollected) {
    LLNode<Card> nodeptr = cardsCollected.getFirstNode();
    while (nodeptr != null) {
      // If current card is a Count and their counterpart is present, set their value to four
      if (nodeptr.getElement().getName() == "Count" && getCountessCollected())
        nodeptr.getElement().setPoints(4);
      // If current card is a Countess and their counterpart is present, set value to four  
      else if (nodeptr.getElement().getName() == "Countess" && getCountCollected())
        nodeptr.getElement().setPoints(4);
      // If current card is a Lord and their counterpart is present, set their value to four
      else if (nodeptr.getElement().getName() == "Lord" && getLadyCollected())
        nodeptr.getElement().setPoints(4);
      // If current card is a Lady card and their counterpart is present, set their value to four
      else if (nodeptr.getElement().getName() == "Lady" && getLordCollected())
        nodeptr.getElement().setPoints(4);
      // If card is a Heretic, adjuts value based on how many Church cards have been collected
      else if (nodeptr.getElement().getName() == "Heretic")
        nodeptr.getElement().setPoints(getNumChurchCards());
      // If card is a Tax Collector, adjust value based on how many Civic cards have been collected
      else if (nodeptr.getElement().getName() == "Tax Collector")
        nodeptr.getElement().setPoints(getNumCivicCards());
      // If card is a Palace Guard, adjust value based on how many palace guard cards have been collected
      else if (nodeptr.getElement().getName() == "Palace Guard")
        nodeptr.getElement().setPoints(getNumPalaceGuardCards());
      // If card is a Tragic Figure, adjust value based on how many commoner cards have been collected
      else if (nodeptr.getElement().getName() == "Tragic Figure")
        nodeptr.getElement().setPoints(-1 * getNumCommonerCards());
      nodeptr = nodeptr.getNext();
    }
  }
                           
  /**
   * Draw front card from cards being played with to add to this player's "hand"
   * "Remove" front node of card of cards being played with to return its element and "add" that element to this player's hand
   * Adjust point value of cards if conditions are met
   * Total up score based on current value of cards after adjustment
   * @param playCards List of cards having been randomely drawn and played with
   * @param otherPlayer The other player being played with
   * @return 0 Method was able to execute under appropriate conditions
   * @return 1 Method did not execute original task and returned this player as winner
   * @return 2 Method did not execute original task and returned other player as winner
   * @return 3 Method did not execute original task and returned tie between players
   * @return -2 Method was unable to execute due to not being this player's turn
   */
  public int drawPlayCard(LinkedList<Card> playCards, Player otherPlayer) {
    // If it is this player's turn
    if (getTurn()) {
      // If the cards being played with are not empty, then draw card from front of playing card list and switch turns with other player
      if (!playCards.isEmpty()) {
        // Draw card and add it to player's hand
        cardsCollected.addToFront(playCards.removeFromFront());
        // Check if drawn card is a Count, Countess, Lord, or Lady
        checkForSpecialCard(getCardsCollected());
        // Increment special card count
        incSpecialCardCount(getCardsCollected());
        // Adjust value of cards collected
        adjustCardValue(getCardsCollected());
        // Total score of player's hand and set it to be this player's score
        sumScore();
        // Make it be other player's turn
        otherPlayer.setTurn(true);
        setTurn(false);
        return 0;
      }
      // If there are no playing cards left to draw, compare total scores of this player and the other player, and return winner
      else {
        if (getScore() > otherPlayer.getScore()) {
          System.out.println(getName() + " wins!");
          return 1;
        }
        else if (getScore() < otherPlayer.getScore()){
          System.out.println(otherPlayer.getName() + " wins!");
          return 2;
        }
        else {
          System.out.println("Tie!");
          return 3;
        }
      }
    }
    // If it is not this player's turn
    else {
      System.out.println("Not " + getName() + "'s turn");
      return -2;
    }
  }
  
  /**
   * Move front card of drawn cards being played with back by four
   * @param playCards The drawn cards being played with
   * @return 0 Method was able to execute under appropriate conditions
   * @return -1 Method was unable to execute due to it already having been used once
   * @return -2 Method was unable to execute due to not being this player's turn
   * @return -3 Method was unable to execute due to magnitude of playing cards being insufficient for action to be performed
   * @return -4 Method was unable to execute at all due to unknown reason
   */
  public int moveBackFour(LinkedList<Card> playCards) {
    // If it is this player's turn
    if (getTurn()) {
      // If action hasn't been used
      if (!getMoveBackFourUsed() && 4 < playCards.length()) {
        // Do action and call 
        playCards.moveBack(4);
        // Disable this action from being used again
        setMoveBackFourUsed();
        return 0;
      }
      else if (4 >= playCards.length()) {
        System.out.println("Move's magnitude exceeds playing cards count");
        return -3;
      }
      // If action has been used, indicate to player that action has been used
      else if (getMoveBackFourUsed()) {
        System.out.println("Action already used");
        return -1;
      }
    }
    else {
      System.out.println("Not " + getName() + "'s turn");
      return -2;
    }
    return -4;
  }
  
  /**
   * Move front card of drawn cards being played with back by three
   * @param playCards The drawn cards being played with
   * @return 0 Method was able to execute under appropriate conditions
   * @return -1 Method was unable to execute due to it already having been used once
   * @return -2 Method was unable to execute due to not being this player's turn
   * @return -3 Method was unable to execute due to magnitude of playing cards being insufficient for action to be performed
   * @return -4 Method was unable to execute at all due to unknown reaso
   */
  public int moveBackThree(LinkedList<Card> playCards) {
    if (getTurn()) {
      // If action hasn't been used
      if (!getMoveBackThreeUsed() && 3 < playCards.length()) {
        //  Do action
        playCards.moveBack(3);
        // Disable this action from being used again
        setMoveBackThreeUsed();
        return 0;
      }
      else if (3 >= playCards.length()) {
        System.out.println("Move's magnitude exceeds playing cards count");
        return -3;
      }
      else if (getMoveBackThreeUsed()) {
        System.out.println("Action already used");
        return -1;
      }
    }
    else {
      System.out.println("Not " + getName() + "'s turn");
      return -2;
    }
    return -4;
  }
  
  /**
   * Move front card of drawn cards being played with back by two
   * @param playCards The drawn cards being played with
   * @return 0 Method was able to execute under appropriate conditions
   * @return -1 Method was unable to execute due to it already having been used once
   * @return -2 Method was unable to execute due to not being this player's turn
   * @return -3 Method was unable to execute due to magnitude of playing cards being insufficient for action to be performed
   * @return -4 Method was unable to execute at all due to unknown reaso
   */
  public int moveBackTwo(LinkedList<Card> playCards) {
    if (getTurn()) {
      if (!getMoveBackTwoUsed() && 2 < playCards.length()) {
        playCards.moveBack(2);
        setMoveBackTwoUsed();
        return 0;
      }
      else if (2 >= playCards.length()) {
        System.out.println("Move's magnitude exceeds playing cards count");
        return -3;
      }
      else if (getMoveBackTwoUsed()) {
        System.out.println("Action already used");
        return -1;
      }
    }
    else {
      System.out.println("Not " + getName() + "'s turn");
      return -2;
    }
    return -4;
  }
  
  /**
   * Move front card of drawn cards being played with back by one
   * @param playCards The drawn cards being played with
   * @return 0 Method was able to execute under appropriate conditions
   * @return -1 Method was unable to execute due to it already having been used once
   * @return -2 Method was unable to execute due to not being this player's turn
   * @return -3 Method was unable to execute due to magnitude of playing cards being insufficient for action to be performed
   * @return -4 Method was unable to execute at all due to unknown reaso
   */
  public int moveBackOne(LinkedList<Card> playCards) {
    if (getTurn()) {
      if (!getMoveBackOneUsed()) {
        playCards.moveBack(1);
        setMoveBackOneUsed();
        return 0;
      }
      else if (1 >= playCards.length()) {
        System.out.println("Move's magnitude exceeds playing cards count");
        return -3;
      }
      else if (getMoveBackOneUsed()) {
        System.out.println("Action already used");
        return -1;
      }
    }
    else {
      System.out.println("Not " + getName() + "'s turn");
      return -2;
    }
    return -4;
  } 
  
  /**
   * Move front card of drawn cards being played with to end
   * @param playCards The drawn cards being played with
   * @return 0 Method was able to execute under appropriate conditions
   * @return -1 Method was unable to execute due to it already having been used once
   * @return -2 Method was unable to execute due to not being this player's turn
   */
  public int moveFrontToEnd(LinkedList<Card> playCards) {
    if (getTurn()) {
      if (!getMoveFrontToEndUsed()) {
        playCards.moveFirstToLast();
        setMoveFrontToEndUsed();
        return 0;
      }
      else {
        System.out.println("Action already used");
        return -1;
      }
    }
    else {
      System.out.println("Not " + getName() + "'s turn");
      return -2;
    }
  }
  
  /**
   * Move back card of drawn cards being played with to front
   * @param playCards The drawn cards being played with
   * @return 0 Method was able to execute under appropriate conditions
   * @return -1 Method was unable to execute due to it already having been used once
   * @return -2 Method was unable to execute due to not being this player's turn
   */
  public int moveEndToFront(LinkedList<Card> playCards) {
    if (getTurn()) {
      if (!getMoveEndToFrontUsed()) {
        playCards.moveLastToFirst();
        setMoveEndToFrontUsed();
        return 0;
      }
      else {
        System.out.println("Action already used");
        return -1;
      }
    }
    else {
      System.out.println("Not " + getName() + "'s turn");
      return -2;
    }
  }
  
  /**
   * Reverse drawn cards being played with 
   * @param playCards The drawn cards being played with
   * @return 0 Method was able to execute under appropriate conditions
   * @return -1 Method was unable to execute due to it already having been used once
   * @return -2 Method was unable to execute due to not being this player's turn
   */
  public int reverseCards(LinkedList<Card> playCards) {
    if (getTurn()) {
      if (!getReverseCardsUsed()) {
        playCards.reverseList();
        setReverseCardsUsed();
        return 0;
      }
      else {
        System.out.println("Action already used");
        return -1;
      }
    }
    else {
      System.out.println("Not " + getName() + "'s turn");
      return -2;
    }
  }
  
  /**
   * Reverse first k cards of drawn cards being played with
   * @param playCards The drawn cards being played with
   * @return 0 Method was able to execute under appropriate conditions
   * @return -1 Method was unable to execute due to it already having been used once
   * @return -2 Method was unable to execute due to not being this player's turn
   * @return -3 Method was unable to execute due to magnitude of playing cards being insufficient for action to be performed
   * @return -4 Method was unable to execute at all due to unknown reaso
   */
  public int reverseFirstFiveCards(LinkedList<Card> playCards) {
    if (getTurn()) {
      if (!getReverseFirstFiveCardsUsed() && 5 <= playCards.length()) {
        playCards.reverseFirstK(5);
        setReverseFirstFiveCardsUsed();
        return 0;
      }
      else if (5 > playCards.length()) {
        System.out.println("Move's magnitude exceeds playing cards count");
        return -3;
      }
      else if (getReverseFirstFiveCardsUsed()) {
        System.out.println("Action already used");
        return -1;
      }
    }
    else {
      System.out.println("Not " + getName() + "'s turn");
      return -2;
    }
    return -4;
  }
  
  /**
   * Skip this player's turn and make it other player's turn
   * @param otherPlayer The other player
   * @return 0 Method was able to execute under appropriate conditions
   * @return -1 Method was unable to execute due to it already having been used once
   * @return -2 Method was unable to execute due to not being this player's turn
   */
  public int skipTurn(Player otherPlayer) {
    if (getTurn()) {
      if (!getSkipTurnUsed()) {
        setSkipTurnUsed();
        otherPlayer.setTurn(true);
        setTurn(false);
        return 0;
      }
      else {
        System.out.println("Action already used");
        return -1;
      }
    }
    else {
      System.out.println("Not " + getName() + "'s turn");
      return -2;
    }
  }
    
}