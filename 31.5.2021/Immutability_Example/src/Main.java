public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Pile pile1 = new Pile(deck);
        Pile pile2 = new Pile(deck);

        pile1.addCard("Hearts", "3");
        pile1.addCard("Diamonds", "K");
        pile1.addCard("Spades", "10");

        pile2.addCard("Hearts", "3");
        pile2.addCard("Diamonds", "J");
        pile2.addCard("Clubs", "2");

        pile1.printPile();
        pile2.printPile();

    }
}
