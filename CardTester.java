import java.sql.SQLOutput;
import java.util.*;

public class CardTester {

    public static void main(String[] args) { //main method array of strings
        Card card = new Card(3,2);
        System.out.println(card);
        Deck deck = new Deck();
        System.out.println(deck);
        deck.shuffle();
        System.out.println(deck);
        /*ArrayList<Card> testHand = new ArrayList<Card>();
        testHand.add(new Card(1,1));
        testHand.add(new Card(1,2));

        testHand.add(new Card(1,3));
        testHand.add(new Card(1,4));
        testHand.add(new Card(1,5));*/
        Game test = new Game(new String[]{"s1", "s2", "s3", "s4", "s5"});
        test.play();
        System.out.println(test.getPlayer().getHand());
        //System.out.println(test.getBankroll());



       // Shuffle shuffle = new shuffle(temp.toString());

    }

    
    //public int ageAdd() {
    //Scanner s = new Scanner();
    //int y = s.nextInt();

    //System.out.println("Enter your age here");

    //System.out.println( y + 7);
    //}

}