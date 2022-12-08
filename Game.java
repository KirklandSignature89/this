
import java.util.*;

import static java.lang.Integer.parseInt;
// add your own banner here

public class Game {
	
	private Player p;
	private Deck cards;

	private Player testPlayer;

	private final String ROYAL_FLUSH = "Royal Flush";
	private final String STRAIGHT_FLUSH = "Straight Flush";
	private final String FOUR_OF_A_KIND = "Four of a Kind";
	private final String FULL_HOUSE = "Full House";
	private final String FLUSH = "Flush";
	private final String STRAIGHT = "Straight";
	private final String THREE_OF_A_KIND = "Three of a Kind";
	private final String TWO_PAIR = "Two Pairs";
	private final String ONE_PAIR = "One Pair";

	// you'll probably need some more here
	
	
	public Game(String[] testHand){
		// This constructor is to help test your code.
		// use the contents of testHand to
		Scanner s = new Scanner(System.in);
		System.out.println("What is your name? ");
		String playerName = s.nextLine();
		//cards = new Deck();
		this.testPlayer = new Player(playerName);
		ArrayList<Card> testerHand = new ArrayList<Card>();

		for(int i =0; i<5; i++) {
			String testCard = testHand[i];
			String testSuit = testCard.substring(0,1);
			String testRank = testCard.substring(1);

			int testSuitAsNumber;

			switch(testSuit){
				case "s":
					testSuitAsNumber = 1;
					break;
				case "h":
					testSuitAsNumber = 2;
					break;
				case "c":
					testSuitAsNumber = 3;
					break;
				default:
					testSuitAsNumber = 4;
					break;

			}
			Card card = new Card(testSuitAsNumber, parseInt(testRank));
			testerHand.add(card);


		}
		testPlayer.setHand(testerHand);
		// make a hand for the player
		// use the following encoding for cards
		// c = clubs
		// d = diamonds
		// h = hearts
		// s = spades
		// 1-13 correspond to ace-king
		// example: s1 = ace of spades


		
	}
	
	public Game(){
		// This no-argument constructor is to actually play a normal game
		
	}
	private void dealCards() {

		for(int i = 0; i < 5; i++){
			p.addCard(cards.deal());
			//computer.addCard(cards.deal());
		}
	}
	private void removeCard() {


		

	}
	
	public void play(){
		// this method should play the game
		Scanner s = new Scanner(System.in);
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println("%%%%%%%%% VIDEO POKER %%%%%%%%%%");
		System.out.println("%%%%%%____________________%%%%%%");
		System.out.println("Would you like to Play?");
		System.out.println("If so, enter your name below!");
		String playerName = s.nextLine();
		this.p = new Player(playerName);

		p.setBankroll(50);

		while (p.getBankroll() > 0) {

			cards = new Deck();
			System.out.println(playerName + " You currently have " + p.getBankroll() + " ShitTokens");
			System.out.println("You can bet between 1-5 Shit tokens");
			System.out.println("Please enter an amount you'd like to gamble!");
			int amt = s.nextInt();
			while(amt < 1 || amt > 5) {
				System.out.println("this is an invalid amount, Try again!");
				amt = s.nextInt();
			}

			//System.out.println("out of loop");

			p.bets(amt);
			p.setBankroll(p.getBankroll() - amt);
			System.out.println(p.getBankroll());
			cards.shuffle();
			dealCards();
			System.out.println();
			System.out.println(p.getHand());

			System.out.println("Do you want to remove a card?");
			System.out.println("if so choose the card number you'd like to remove");
			System.out.println("enter 1-5 indicate the specific card you want to remove");
			System.out.println("enter 0 to keep your current hand");

			int cardLoc = s.nextInt();

			while(cardLoc != 0 && p.getHand().size() > 0) {

				p.removeCard(p.getHand().get(cardLoc - 1));
				System.out.println("these are your remaining cards " + p.getHand().toString());
				System.out.println("do you want to remove another card?");
				System.out.println("enter the number card you would like to remove");
				System.out.println("if not enter 0 to keep the remaining cards and deal the new ones!");

				cardLoc = s.nextInt();
			}

			// Add cards until hand size is 5
			int cardsToDeal = 5 - p.getHand().size();

			for (int i = 0; i < cardsToDeal; i++) {
				p.addCard(cards.deal());
			}

			System.out.println(p.getHand());

			String finalHand = checkHand(p.getHand());
			int winnings = 0;

			if (finalHand == null) {
				System.out.println("You lose");

			} else {
				switch (finalHand) {
					case ROYAL_FLUSH ->  //{Ace of spades, King of Spade, Queen of Spade, Jack of Spade, Ten of Spades} s has to the same && A-10
							winnings = 250;
					case STRAIGHT_FLUSH -> winnings = 50;
					case FOUR_OF_A_KIND ->  //
							winnings = 25;
					case FULL_HOUSE ->  // 1 pair and 1 three of kind
							winnings = 6;
					case FLUSH ->  // and 5 card hand where all cards == s
							winnings = 5;
					case STRAIGHT -> winnings = 4;
					case THREE_OF_A_KIND -> winnings = 3;
					case TWO_PAIR -> winnings = 2;
					case ONE_PAIR -> winnings = 1;
				}

				System.out.println("you have a winning hand!");
				System.out.println(finalHand);
				System.out.println("you have made " + winnings*amt + " shit tokens");
				p.setBankroll(p.getBankroll() + (winnings * amt));

				System.out.println("Do you want to play again? 1 for yes, 0 for no");

				if(s.nextInt() == 0) {
					p.resetHand();

					return;
				}


			}


		}


	}
	public boolean isRoyalFlush(ArrayList<Card> hand) {
		Collections.sort(hand);
		int[] royalFlush = {1, 10, 11, 12, 13}; //hard coding royal flush with in array
		boolean straightFlushToAce = true;

		for(int i = 0; i <5; i++) {
			if (hand.get(i).getRank() != royalFlush[i]) {
				straightFlushToAce = false;
				break;
			}
		}
		return straightFlushToAce;
	}
	public boolean isFlush(ArrayList<Card> hand) {
		Collections.sort(hand);
		int currentSuit = hand.get(0).getSuit();
		boolean isSameSuit = true;

		for (int i = 1; i <5; i++) {
			if (currentSuit != hand.get(i).getSuit()) {
				isSameSuit = false;
				break;
			}
		}

		return isSameSuit;
	}
	public boolean isStraight(ArrayList<Card> hand) {
		Collections.sort(hand);
		int currentRank = hand.get(0).getRank();
		boolean isConsecutiveRank = true;

		for (int i = 1; i <5; i++) {
			if (currentRank + i != hand.get(i).getRank()) {
				isConsecutiveRank = false;
				break;
			}
		}

		return isConsecutiveRank;
	}

	public int[] getCardCounts(ArrayList<Card> hand) {
		//Collections.sort(hand);
//		if(rankCount >3 then four of a kind) esle if rankcou

		int[] counts = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

		for(int i = 0; i < 5; i++) {
			counts[hand.get(i).getRank() - 1]++;
		}

		return counts;
	}

	public boolean isOfAKind(int[] counts, int kind) {
		for(int i = 0; i < 13; i++) {
			if (counts[i] == kind) {
				return true;
			}
		}
		return false;
	}

	public boolean isFullHouse(int[] counts) {
		boolean isThreeOfAKind = false;
		boolean isPair = false;
		for(int i = 0; i < 13; i++) {
			if (counts[i] == 3) {
				isThreeOfAKind = true;
			}
			if (counts[i] == 2) {
				isPair = true;
			}
		}

		return isThreeOfAKind && isPair;
	}

	public boolean isTwoPair(int[] counts) {
		int pairCount = 0;
		for(int i = 0; i < 5; i++) {
			if (counts[i] == 2) {
				pairCount++;
			}
		}
		if(pairCount == 2) {
			return true;
		}
		return false;
	}



	public String checkHand(ArrayList<Card> hand){
		if (isFlush(hand)) {
			if (isRoyalFlush(hand)) {
				return ROYAL_FLUSH;
			}
			if (isStraight(hand)) {
				return STRAIGHT_FLUSH;
			}
			return FLUSH;
		}
		int[] counts = getCardCounts(hand);

		if (isOfAKind(counts, 4)) {
			return FOUR_OF_A_KIND;
		}

		if (isFullHouse(counts)) {
			return FULL_HOUSE;
		}

		if (isOfAKind(counts,3)) {
			return THREE_OF_A_KIND;
		}

		if (isTwoPair(counts)) {
			return TWO_PAIR;
		}
		if (isOfAKind(counts, 2)) {
			return ONE_PAIR;
		}

		return null;
	}

	public Player getPlayer() { //getter function
		return p;
	}


	// you will likely want many more methods here
	// per discussion in class
}
