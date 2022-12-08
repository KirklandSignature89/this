
// add your own banner here

public class Card implements Comparable<Card>{
	
	private int suit; // use integers 1-4 to encode the suit
	private int rank; // use integers 1-13 to encode the rank
	
	public Card(int s, int r){
		suit = s;
		rank = r;
		//
	}
	public int compareTo(Card c){
		if(this.rank > c.rank) {
			return 1;
		}
		else if(this.rank < c.rank) {
			return -1;
		}
		else {
			return 0;
		}	// use this method to compare cards so they 
		// may be easily sorted

	}
	public int getRank() {
		return rank;
	}
	public int getSuit() {
		return suit;
	}
	public String toString(){
		String r = "";
		String s = "";
		//String = suitString;
		//String = rankString;
		
		switch(suit) {
			case 1:
				s = "Spades";
				break;
			case 2:
				s = "Hearts";
				break;
			case 3:
				s = "Clubs";
				break;
			case 4:
				s = "Diamonds";
				break; 
		}

		switch(rank) {
			case 1:
				r = "Ace";
				break;
			case 2:
				r = "Two";
                break;
            case 3:
                r = "Three";
                break;
            case 4:
                r = "Four";
                break;
            case 5:
                r = "Five";
                break;
            case 6:
                r = "Six";
                break;
            case 7:
                r = "Seven";
                break;
            case 8:
                r = "Eight";
                break;
            case 9:
                r = "Nine";
                break;
            case 10:
                r = "Ten";
                break;
            case 11:
                r = "Jack";
                break;
            case 12:
                r = "Queen";
                break;
            case 13:
                r = "King";
                break;
		}
		return r + " of " + s;

		//return s + Integer.toString(rank);//I am using suit and string value of the rank integer to match encoding requirments on Game class
		
	}
	// add some more methods here if needed

}
