import java.util.Random;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.Node;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ScrollPane;


/**
 * This class represents a game of Guillotine, where the user inputs a 
 * number of cards to play with and plays the game with another person
 * @author Shankar Choudhury
 */
public class Guillotine extends Application {
  // Number of cards game will be played with
  private static int numCards;
  // Array of randomely-drawn cards
  private static int[] drawnCards;
  // Linked list of drawn cards to play with
  private static LinkedList<Card> playCards;
  private static Label title;
  
  // Players and their information
  // Player 1 information
  private static Player player1 = new Player("Player 1");
  private static Text p1Name;
  private static Text p1Score;
  private static Text p1Cards;
  private static VBox p1Info;
  private static VBox p1CollectedCards = new VBox();
  // Player1 Buttons
  private Button p1DrawCard = new Button("draw card");
  private Button p1SkipTurn = new Button("skip turn");
  private Button p1MoveFrontToEnd = new Button("move front to end");
  private Button p1MoveEndToFront = new Button("move end to front");
  private Button p1MoveBack4 = new Button("move front card back 4");
  private Button p1MoveBack3 = new Button("move front card back 3");
  private Button p1MoveBack2 = new Button("move front card back 2");
  private Button p1MoveBack1 = new Button("move front card back 1");
  private Button p1ReverseCards = new Button("reverse cards");
  private Button p1ReverseFirst5Cards = new Button("reverse first five cards");

  // Player 2 information
  private static Player player2 = new Player("Player 2");
  // Text info
  private static Text p2Name;
  private static Text p2Score;
  private static Text p2Cards;
  private static VBox p2Info;
  private static VBox p2CollectedCards = new VBox();
  // Player2 Buttons
  private Button p2DrawCard = new Button("draw card");
  private Button p2SkipTurn = new Button("skip turn");
  private Button p2MoveFrontToEnd = new Button("move front to end");
  private Button p2MoveEndToFront = new Button("move end to front");
  private Button p2MoveBack4 = new Button("move front card back 4");
  private Button p2MoveBack3 = new Button("move front card back 3");
  private Button p2MoveBack2 = new Button("move front card back 2");
  private Button p2MoveBack1 = new Button("move front card back 1");
  private Button p2ReverseCards = new Button("reverse cards");
  private Button p2ReverseFirst5Cards = new Button("reverse first five cards");
  
  // Playing cards window 
  VBox cards = new VBox();
  // Layout of Guillotine
  BorderPane layout = new BorderPane();
  
  /**
   * Return number of cards game is being played with
   * @return numCards The number of cards game is being played with
   */
  public static int getNumCards() {
    return numCards;
  }
  
  /**
   * Assign number of cards for game to play with
   * @param numberOfCards The number of cards to be played with
   */
  public static void setNumCards(int numberOfCards) {
    numCards = numberOfCards;
  }
  
  /**
   * Return an array of numbers representing randomly-selected cards
   * @return cards The array of numbers representing randomly-selected cards
   */
  public static int[] getDrawnCards() {
    return drawnCards;
  }
  
  /**
   * Return linked list of cards being played with
   * @return playCards The linked list of cards being played with
   */
  public static LinkedList<Card> getPlayCards() {
    return playCards;
  }
  
  /**
   * Create a list of user-input amount of random numbers between 1 and 40
   * to represent randomly-selected cards drawn for game
   * @param numCards Number of cards to be randomly drawn for game
   */
  public static void drawCards(int numCards) {
    drawnCards = new Random().ints(1, 41).distinct().limit(numCards).toArray();
  }
  
  /**
   * Loop through cards array, call card constructors corresponding to number range in card array, and add to playCards linked list in that order
   * @param drawnCards Array of randomly drawn cards
   * @return playCards Linked list of cards being played with
   */
  public static LinkedList<Card> setPlayCards(int[] drawnCards) {
    // Create linked list of cards to play with
    playCards = new LinkedList<Card>();
    for (int i = 0; i < drawnCards.length; i++) {
      // If number is in range of royal cards, create a royal card and store it in playCards linked list
      if (drawnCards[i] > 31)
        playCards.addToFront(new Royal(drawnCards[i]));
      // If number is in range of church cards, create a church card and store it in playCards linked list
      else if (drawnCards[i] > 24 && drawnCards[i] < 32)
        playCards.addToFront(new Church(drawnCards[i]));
      // If number is in range of civic cards, create a civic card and store it in playCards linked list
      else if (drawnCards[i] > 16 && drawnCards[i] < 25)
        playCards.addToFront(new Civic(drawnCards[i]));
      // If number is in range of military cards, create a military card and store it in playCards linked list
      else if (drawnCards[i] > 6 && drawnCards[i] < 17)
        playCards.addToFront(new Military(drawnCards[i]));
      // If number is in range of commoner cards, create a commoner card and store it in playCards linked list
      else if (drawnCards[i] > 0 && drawnCards[i] < 7)
        playCards.addToFront(new Commoner(drawnCards[i]));
    }
    return playCards;
  }
  
  /**
   * Show cards on playing board
   */
  public void showPlayingCards() {
    LLNode<Card> nodeptr = getPlayCards().getFirstNode();
    int i = 0;
    while (nodeptr != null) {
      Button b;
      // If card is a special card, display its points as a *
      if (nodeptr.getElement().getName() == "Count" || nodeptr.getElement().getName() == "Countess" || 
          nodeptr.getElement().getName() == "Lord" || nodeptr.getElement().getName() == "Lady" ||
          nodeptr.getElement().getName() == "Heretic" || nodeptr.getElement().getName() == "Tax Collector" ||
          nodeptr.getElement().getName() == "Palace Guard" || nodeptr.getElement().getName() == "Tragic Figure") 
        b = new Button(nodeptr.getElement().getName() + ", *");
      else
        b = new Button(nodeptr.getElement().getName() + ", " + nodeptr.getElement().getPoints());
      // Stylize buttons
      b.setMaxSize(175, 60);
      b.setStyle("-fx-border-color: Black; " + setColor(nodeptr.getElement()));
      // Add to display
      cards.getChildren().addAll(b);
      nodeptr = nodeptr.getNext();
    }
  }
  
  /**
   * Refresh remaining cards on playing board
   */
  public void refreshCards() {
    cards.getChildren().clear();
    showPlayingCards();
  }
  
  /**
   * Update display of player's collected cards
   */
  public void showCardsCollected(Player player, VBox info) {
    LLNode<Card> nodeptr = player.getCardsCollected().getFirstNode();
    if (nodeptr != null)
      info.getChildren().clear();
    while (nodeptr != null) {
      Button b;
      // If card is a special card, display its points as a *
      if (nodeptr.getElement().getName() == "Count" || nodeptr.getElement().getName() == "Countess" || 
          nodeptr.getElement().getName() == "Lord" || nodeptr.getElement().getName() == "Lady" ||
          nodeptr.getElement().getName() == "Heretic" || nodeptr.getElement().getName() == "Tax Collector" ||
          nodeptr.getElement().getName() == "Palace Guard" || nodeptr.getElement().getName() == "Tragic Figure") 
        b = new Button(nodeptr.getElement().getName() + ", *");
      else
        b = new Button(nodeptr.getElement().getName() + ", " + nodeptr.getElement().getPoints());
      // Stylize buttons
      b.setMaxSize(175, 60);
      b.setStyle("-fx-border-color: Black; " + setColor(nodeptr.getElement()));
      // Add to player's display of collected cards
      info.getChildren().addAll(b);
      nodeptr = nodeptr.getNext();
    }
  }
  
  /**
   * Return a color corresponding to the card
   * @param c Card being read to find corresponding color
   * @return Color to be assigned to button
   */
  public String setColor(Card c) {
    if (c instanceof Royal)
      return "-fx-background-color: #A000C8; "; //purple
    else if (c instanceof Church)
      return "-fx-background-color: #29C5F6; " ; //blue
    else if (c instanceof Civic)
      return "-fx-background-color: #32CD32; "; //green
    else if (c instanceof Military)
      return "-fx-background-color: #D2042D; "; //red
    else
      return "-fx-background-color: #767676; "; //grey
  }
  
  /**
   * Return winner of game in title of game
   */
  public String getWinner() {
    if (player1.getScore() > player2.getScore())
      return "Player 1 wins!";
    else if (player1.getScore() < player2.getScore())
      return "Player 2 wins!";
    else
      return "Tie!";
  }
  
  /**
   * Disable all player action buttons in game after winner is declared
   */
  public void disableAllButtons() {
    p1DrawCard.setDisable(true);
    p1SkipTurn.setDisable(true);
    p1MoveFrontToEnd.setDisable(true);
    p1MoveEndToFront.setDisable(true);
    p1MoveBack4.setDisable(true);
    p1MoveBack3.setDisable(true);
    p1MoveBack2.setDisable(true); 
    p1MoveBack1.setDisable(true); 
    p1ReverseCards.setDisable(true); 
    p1ReverseFirst5Cards.setDisable(true);
    
    p2DrawCard.setDisable(true);
    p2SkipTurn.setDisable(true);
    p2MoveFrontToEnd.setDisable(true); 
    p2MoveEndToFront.setDisable(true); 
    p2MoveBack4.setDisable(true); 
    p2MoveBack3.setDisable(true);
    p2MoveBack2.setDisable(true);
    p2MoveBack1.setDisable(true); 
    p2ReverseCards.setDisable(true);
    p2ReverseFirst5Cards.setDisable(true);
  }
  
  public void start(Stage primaryStage) {
    title = new Label("Guillotine");
    layout.setTop(title);
    layout.setAlignment(title, Pos.CENTER);
    //layout.setLength(300);
    
    // Player 1's side of window on left
    // Text info
    p1Name = new Text(player1.getName());
    p1Score = new Text("score: " + player1.getScore());
    p1Cards = new Text("cards collected:");
    // Create vertical box to hold all info and buttons
    p1DrawCard.setMaxSize(175, 60);  
    p1SkipTurn.setMaxSize(175, 60);  
    p1MoveFrontToEnd.setMaxSize(175, 60);
    p1MoveEndToFront.setMaxSize(175, 60);
    p1MoveBack4.setMaxSize(175, 60);
    p1MoveBack3.setMaxSize(175, 60); 
    p1MoveBack2.setMaxSize(175, 60); 
    p1MoveBack1.setMaxSize(175, 60);
    p1ReverseCards.setMaxSize(175, 60);
    p1ReverseFirst5Cards.setMaxSize(175, 60);
    p1Info = new VBox(1, p1Name, p1Score, p1DrawCard, p1SkipTurn, p1MoveFrontToEnd, p1MoveEndToFront, p1MoveBack4, 
                      p1MoveBack3, p1MoveBack2, p1MoveBack1, p1ReverseCards, p1ReverseFirst5Cards, p1Cards, p1CollectedCards);
    ScrollPane s1 = new ScrollPane();
    s1.setContent(p1CollectedCards);
    s1.setFitToWidth(true);
    p1Info.getChildren().add(s1);
    // Set to left side
    layout.setLeft(p1Info);
    //actions of player 1 buttons
    p1DrawCard.setOnAction(e -> {
      if (player1.getTurn()) {
        player1.drawPlayCard(getPlayCards(), player2);
        refreshCards();
        p1Score.setText("score: " + player1.getScore()); 
        showCardsCollected(player1, p1CollectedCards);
        if (getPlayCards().isEmpty()) {
          title.setText(getWinner());
          disableAllButtons();
        }
      }
    });
    p1SkipTurn.setOnAction(e -> {
      if (player1.getTurn()) {
        player1.skipTurn(player2);
        p1SkipTurn.setDisable(true);
      }
    });
    p1MoveFrontToEnd.setOnAction(e -> {
      if (player1.getTurn()) {
        player1.moveFrontToEnd(getPlayCards());
        p1MoveFrontToEnd.setDisable(true);
        refreshCards();
      }
    });
    p1MoveEndToFront.setOnAction(e -> {
      if (player1.getTurn()) {
        player1.moveEndToFront(getPlayCards());
        p1MoveEndToFront.setDisable(true);
        refreshCards();
      }
    });
    p1MoveBack4.setOnAction(e -> {
      if (player1.getTurn()) {
        player1.moveBackFour(getPlayCards());
        p1MoveBack4.setDisable(true);
        refreshCards();
      }
    });
    p1MoveBack3.setOnAction(e -> {
      if (player1.getTurn()) {
        player1.moveBackThree(getPlayCards());
        p1MoveBack3.setDisable(true);
        refreshCards();
      }
    });
    p1MoveBack2.setOnAction(e -> {
      if (player1.getTurn()) {
        player1.moveBackTwo(getPlayCards());
        p1MoveBack2.setDisable(true);
        refreshCards();
      }
    });
    p1MoveBack1.setOnAction(e -> {
      if (player1.getTurn()) {
        player1.moveBackOne(getPlayCards());
        p1MoveBack1.setDisable(true);
        refreshCards();
      }
    });
    p1ReverseCards.setOnAction(e -> {
      if (player1.getTurn()) {
        player1.reverseCards(getPlayCards());
        p1ReverseCards.setDisable(true);
        refreshCards();
      }
    });
    p1ReverseFirst5Cards.setOnAction(e -> {
      if (player1.getTurn()) {
        player1.reverseFirstFiveCards(getPlayCards());
        p1ReverseFirst5Cards.setDisable(true);
        refreshCards();
      }
    });
      
    // Player 2's side of window on right
    // Text info
    p2Name = new Text(player2.getName());
    p2Score = new Text("score: " + player1.getScore());
    p2Cards = new Text("cards collected:");
    // Create vertical box to hold all info and buttons
    p2DrawCard.setMaxSize(175, 60);  
    p2SkipTurn.setMaxSize(175, 60); 
    p2MoveFrontToEnd.setMaxSize(175, 60);  
    p2MoveEndToFront.setMaxSize(175, 60);  
    p2MoveBack4.setMaxSize(175, 60); 
    p2MoveBack3.setMaxSize(175, 60);  
    p2MoveBack2.setMaxSize(175, 60);  
    p2MoveBack1.setMaxSize(175, 60);
    p2ReverseCards.setMaxSize(175, 60);
    p2ReverseFirst5Cards.setMaxSize(175, 60);
    p2Info = new VBox(1, p2Name, p2Score, p2DrawCard, p2SkipTurn, p2MoveFrontToEnd, p2MoveEndToFront, p2MoveBack4, 
                      p2MoveBack3, p2MoveBack2, p2MoveBack1, p2ReverseCards, p2ReverseFirst5Cards, p2Cards, p2CollectedCards);
    ScrollPane s2 = new ScrollPane();
    s2.setContent(p2CollectedCards);
    s2.setFitToWidth(true);
    p2Info.getChildren().add(s2);
    // Set to right side
    layout.setRight(p2Info);
    //actions of player 1 buttons
    p2DrawCard.setOnAction(e -> {
      if (player2.getTurn()) {
        player2.drawPlayCard(getPlayCards(), player1);
        refreshCards();
        p2Score.setText("score: " + player2.getScore());
        showCardsCollected(player2, p2CollectedCards);
        if (getPlayCards().isEmpty()) {
          title.setText(getWinner());
          disableAllButtons();
        }
      }
    });
    p2SkipTurn.setOnAction(e -> {
      if (player2.getTurn()) {
        player2.skipTurn(player1);
        p2SkipTurn.setDisable(true);
      }
    });
    p2MoveFrontToEnd.setOnAction(e -> {
      if (player2.getTurn()) {
        player2.moveFrontToEnd(getPlayCards());
        p2MoveFrontToEnd.setDisable(true);
        refreshCards();
      }
    });
    p2MoveEndToFront.setOnAction(e -> {
      if (player2.getTurn()) {
        player2.moveEndToFront(getPlayCards());
        p2MoveEndToFront.setDisable(true);
        refreshCards();
      }
    });
    p2MoveBack4.setOnAction(e -> {
      if (player2.getTurn()) {
        player2.moveBackFour(getPlayCards());
        p2MoveBack4.setDisable(true);
        refreshCards();
      }
    });
    p2MoveBack3.setOnAction(e -> {
      if (player2.getTurn()) {
        player2.moveBackThree(getPlayCards());
        p2MoveBack3.setDisable(true);
        refreshCards();
      }
    });
    p2MoveBack2.setOnAction(e -> {
      if (player2.getTurn()) {
        player2.moveBackTwo(getPlayCards());
        p2MoveBack2.setDisable(true);
        refreshCards();
      }
    });
    p2MoveBack1.setOnAction(e -> {
      if (player2.getTurn()) {
        player2.moveBackOne(getPlayCards());
        p2MoveBack1.setDisable(true);
        refreshCards();
      }
    });
    p2ReverseCards.setOnAction(e -> {
      if (player2.getTurn()) {
        player1.reverseCards(getPlayCards());
        p2ReverseCards.setDisable(true);
        refreshCards();
      }
    });
    p2ReverseFirst5Cards.setOnAction(e -> {
      if (player2.getTurn()) {
        player2.reverseFirstFiveCards(getPlayCards());
        p2ReverseFirst5Cards.setDisable(true);
        refreshCards();
      }
    });

    // Display cards
    ScrollPane s = new ScrollPane();
    showPlayingCards();
    s.setContent(cards);
      
    // Set to center
    layout.setCenter(s);
    layout.setAlignment(s, Pos.TOP_CENTER);
      
      
    Scene scene = new Scene (layout);
    primaryStage.setScene(scene); 
    primaryStage.setMinHeight(500);
    primaryStage.setMaxHeight(600);
    primaryStage.setTitle("Guillotine.java");
    primaryStage.show(); 
  }
   
  /**
   * main method to launch a game of Guillotine
   * @param args Number of cards to play with
   */
  public static void main(String[] args) {
    
    // Check user input for number of cards
    try {
      if (args.length > 1|| Integer.parseInt(args[0] )< 2 || Integer.parseInt(args[0]) > 40)
        System.out.println("Enter one integer between 2 and 40");
      else {
        setNumCards(Integer.parseInt(args[0]));
        // Randomly draw number of cards specified by user to be used in game
        drawCards(getNumCards());
        // Create a linked list and store in every node sequentially the corresponding card in order from cards array
        setPlayCards(getDrawnCards());
        // Create players 1 and 2, and make it player 1's turn
        player1.setTurn(true);
        Application.launch(args);
      }
    }
    // If user has bad input
    catch (NumberFormatException e) {
      System.out.println("Enter an integer between 2 and 40 or enter nothing for a default 20 cards for game");
    }
    // If user chooses to not input a number and use default number of cards
    catch (ArrayIndexOutOfBoundsException e) {
      setNumCards(20);
      drawCards(getNumCards());
      // Create a linked list and store in every node sequentially the corresponding card in order from cards array
      setPlayCards(getDrawnCards());
      // Create players 1 and 2, and make it player 1's turn
      player1.setTurn(true);
      Application.launch(args);
    }
    catch (IllegalStateException e) {
      ;
    }
  }
}
  
   
    
