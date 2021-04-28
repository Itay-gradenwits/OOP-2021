public class Product {

    private int value;
    private String name;

    public Product(int value, String name) {
        this.value = value;
        this.name = name;
    }

    int getValue() {
        return this.value;
    }
    String getName() {
        return this.name;
    }
}
