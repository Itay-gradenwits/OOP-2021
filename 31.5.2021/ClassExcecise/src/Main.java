public class Main {
    public static void main(String[] args ){
        Deck deck = new Deck();

        Pile pile1 = new Pile(deck);
        Pile pile2 = new Pile(deck);

        pile1.addCard('1', "Hearts");
        pile1.addCard('2', "Hearts");

        pile2.addCard('1', "Hearts");


        pile1.printPile();
        pile2.printPile();

    }
}
