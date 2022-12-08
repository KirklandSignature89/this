import java.util.*;
// add your own banner here

public class Deck {
	
	private Card[] cards;
	private int top; // the index of the top of the deck

	// add more instance variables if needed
	
	public Deck(){
		cards = new Card[52];
		top = 0;
		for( int s = 1; s < 5; s++) {// make a 52 card deck here
			for( int r = 1; r < 14; r++) {
				cards[top] = new Card(s,r);
				top++;
			}


			
		}
		top = 0;
		//shuffle();
		//System.out.println(top);

            
	
	}

	
	public void shuffle(){
		// shuffle the deck here

		Random rand = new Random();

		int i = 0;
		while(i < 100000) {
			i++;
			int b = rand.nextInt(52);
			int a = rand.nextInt(52);


			Card temp = cards[a];
			cards[a] = cards[b];
			cards[b] = temp;
			}
		top = 0;
		//System.out.println(top);
	}
	
	public Card deal(){
		// deal the top card in deck

		return cards[top++];
	}
	
	public String toString(){

		String wholeDeck = new String();

		for (int i = 0; i < cards.length; i++) {
			wholeDeck+=cards[i].toString()+"\n";

		}
		return "fuck off Randy" + wholeDeck;
	}
	// add more methods here if needed

}
