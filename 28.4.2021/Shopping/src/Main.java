import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Store store1 = new Castro(1000000);
        store1.buyMerch(new Product(40,"Red T shirt"));
        store1.buyMerch(new Product(20,"Wide Blue Jeans"));
        store1.buyMerch(new Product(20,"Black shoes"));

        Store store2 = new CastroEilat(100000);
        store2.buyMerch(new Product(40,"Red T shirt"));
        store2.buyMerch(new Product(20,"Wide Blue Jeans"));
        store2.buyMerch(new Product(20,"Black shoes"));

        Store store3 = new Zara(100000);
        store3.buyMerch(new Product(10,"White socks"));
        store3.buyMerch(new Product(100,"Yellow jacket"));
        store3.buyMerch(new Product(150,"Blue coat"));

        store1.sellMerch("Red T shirt");
        store1.sellMerch("Wide Blue Jeans");
        System.out.println();

        store2.sellMerch("Red T shirt");
        store2.sellMerch("Wide Blue Jeans");
        System.out.println();

        store3.sellMerch("Yellow jacket");
        store3.sellMerch("Blue coat");

    }
}
