import java.util.ArrayList;
import java.util.List;

//not immutable class.
public final class Pile {
    private final Deck deck;
    private List<Card> myCards;
    public Pile(Deck d) {
        deck = d;
        myCards = new ArrayList<>();
    }
    public void addCard(String color, String number) {
        myCards.add(deck.getCard(color,number));
    }
    public void printPile() {
        System.out.println("Pile content:");
        for (Card c : myCards) {
            System.out.println(c.getNumber() +" " + c.getColor());
        }
        System.out.println();
    }
}
