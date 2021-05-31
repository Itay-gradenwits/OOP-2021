import java.util.ArrayList;
import java.util.List;

public final class Deck {
    private final List<Card> theCards;

    public Deck() {
        List<Card> temp = new ArrayList<>();
        temp.add(new Card("Diamonds","1"));
        temp.add(new Card("Diamonds","2"));
        temp.add(new Card("Diamonds","3"));
        temp.add(new Card("Diamonds","4"));
        temp.add(new Card("Diamonds","5"));
        temp.add(new Card("Diamonds","6"));
        temp.add(new Card("Diamonds","7"));
        temp.add(new Card("Diamonds","8"));
        temp.add(new Card("Diamonds","9"));
        temp.add(new Card("Diamonds","10"));
        temp.add(new Card("Diamonds","J"));
        temp.add(new Card("Diamonds","Q"));
        temp.add(new Card("Diamonds","K"));
        temp.add(new Card("Hearts","1"));
        temp.add(new Card("Hearts","2"));
        temp.add(new Card("Hearts","3"));
        temp.add(new Card("Hearts","4"));
        temp.add(new Card("Hearts","5"));
        temp.add(new Card("Hearts","6"));
        temp.add(new Card("Hearts","7"));
        temp.add(new Card("Hearts","8"));
        temp.add(new Card("Hearts","9"));
        temp.add(new Card("Hearts","10"));
        temp.add(new Card("Hearts","J"));
        temp.add(new Card("Hearts","Q"));
        temp.add(new Card("Hearts","K"));
        temp.add(new Card("Clubs","1"));
        temp.add(new Card("Clubs","2"));
        temp.add(new Card("Clubs","3"));
        temp.add(new Card("Clubs","4"));
        temp.add(new Card("Clubs","5"));
        temp.add(new Card("Clubs","6"));
        temp.add(new Card("Clubs","7"));
        temp.add(new Card("Clubs","8"));
        temp.add(new Card("Clubs","9"));
        temp.add(new Card("Clubs","10"));
        temp.add(new Card("Clubs","J"));
        temp.add(new Card("Clubs","Q"));
        temp.add(new Card("Clubs","K"));
        temp.add(new Card("Spades","1"));
        temp.add(new Card("Spades","2"));
        temp.add(new Card("Spades","3"));
        temp.add(new Card("Spades","4"));
        temp.add(new Card("Spades","5"));
        temp.add(new Card("Spades","6"));
        temp.add(new Card("Spades","7"));
        temp.add(new Card("Spades","8"));
        temp.add(new Card("Spades","9"));
        temp.add(new Card("Spades","10"));
        temp.add(new Card("Spades","J"));
        temp.add(new Card("Spades","Q"));
        temp.add(new Card("Spades","K"));
        theCards = temp;
    }
    public Card getCard(String color, String number) {
        for (Card c : theCards) {
            if(c.getNumber().equals(number) && c.getColor().equals(color)) {
                return c;
            }
        }
        return null;
    }
}
