import java.util.ArrayList;
import java.util.List;

public class Pile {
    private Deck deck;
    private List<ImmutableCard> myCards;

    public Pile(Deck d) {
        deck = d;
        myCards = new ArrayList<>();
    }

    public void addCard(char number, String color) {
        myCards.add(deck.getCard(number,color));
    }

    public void printPile() {
        System.out.println("my deck contains:");
        for (ImmutableCard c : myCards) {
            System.out.println(c.getColor() + " " + c.getNumber());
        }
        System.out.println();
    }

}
