import java.sql.Array;
import java.util.*;
// add your own banner here

public class Player {
	
	private String name;
	private ArrayList<Card> hand; // the player's cards
	private double bankroll;
    private double bet;

	// you may choose to use more instance variables
		
	/*public Player(){
	    this("Computer");
    create a player here
        hand = new ArrayList<Card>();
        name = "Computer";
	} */


   public Player(String playerString){ //takes a parameter and sets String to name i.e. My name is Franklin
        //name = new ArrayList<Card>();
        this.name = playerString;
        this.hand = new ArrayList<Card>();
   }

	public void addCard(Card c){
	    // add the card c to the player's hand
        hand.add(c);
	}

	public void removeCard(Card c){
	    // remove the card c from the player's hand
        hand.remove(c);
        }
		
        public void bets(double amt){
            bet = amt;



            
        }

        public void winnings(double odds){
            
            //	adjust bankroll if player wins
        }
        public void setBankroll(double bankroll) { //setter function that set bankroll = to local bankroll.
            this.bankroll = bankroll;
        }

        public double getBankroll() {//getter functions to get bankroll
            // return current balance of bankroll

            return this.bankroll;
        }

        public ArrayList<Card> getHand() {//getter fucntion (get hand)
            return this.hand;

        }

        public void setHand(ArrayList<Card> hand) {
            this.hand = hand;

        }
        public void resetHand() {
            this.hand = new ArrayList<Card>();
        }



        // you may wish to use more methods here
}


