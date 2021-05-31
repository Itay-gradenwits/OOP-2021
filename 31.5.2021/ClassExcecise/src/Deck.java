import java.util.ArrayList;
import java.util.List;

public final class Deck {
    private final List<ImmutableCard> my_cards;

    public Deck() {
        List<ImmutableCard> temp = new ArrayList<>();
        temp.add(new ImmutableCard('1',"Clubs"));
        temp.add(new ImmutableCard('2',"Clubs"));

        temp.add(new ImmutableCard('1',"Hearts"));
        temp.add(new ImmutableCard('2',"Hearts"));

        temp.add(new ImmutableCard('1',"Diamonds"));
        temp.add(new ImmutableCard('2',"Diamonds"));

        temp.add(new ImmutableCard('1',"Spades"));
        temp.add(new ImmutableCard('2',"Spades"));

        my_cards = temp;

    }

    public ImmutableCard getCard(char number, String color) {
        for (ImmutableCard c : my_cards) {
            if(c.getColor().equals(color) && number == c.getNumber()) {
                return c;
            }
        }
        return null;
    }
}
